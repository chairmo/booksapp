package com.chairmo.repositories.security;

import com.chairmo.model.role.Role;
import com.chairmo.repositories.RoleRepository;
import com.chairmo.repositories.security.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Profile("jpaDao")
public class RoleServiceImpl implements RoleService {
    private RoleRepository repository;
    @Autowired
    private void setRepository(RoleRepository repository){this.repository = repository;}

    @Override
    @Transactional
    public Role save(Role role) {
        return repository.saveAndFlush(role);
    }

    @Override
    public List<Role> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Role> findById(Integer id) {
        return repository.findById(id);
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public Page<Role> findRoleByRole(Role role, Pageable pageable) {
        return repository.findRoleByRole(role, pageable);
    }

    @Override
    public Page<Role> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }
}
