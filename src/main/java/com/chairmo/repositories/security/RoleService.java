package com.chairmo.repositories.security;

import com.chairmo.model.User;
import com.chairmo.model.role.Role;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface RoleService {
    Role save(Role role);
    List<Role> findAll();
    Optional<Role> findById(Integer id);
    void deleteById(Integer id);

    //Using Page and pageable
    Page<Role> findRoleByRole(Role role, Pageable pageable);
    Page<Role> findAll(Pageable pageable);
}
