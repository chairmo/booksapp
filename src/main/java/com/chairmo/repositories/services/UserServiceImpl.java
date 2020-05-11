package com.chairmo.repositories.services;

import com.chairmo.model.User;
import com.chairmo.repositories.UserRepository;
import com.chairmo.repositories.security.EncryptionService;
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
public class UserServiceImpl implements UserService {
    private EncryptionService encryptionService;
    private UserRepository repository;

    @Autowired
    public UserServiceImpl(EncryptionService encryptionService, UserRepository repository) {
        this.encryptionService = encryptionService;
        this.repository = repository;
    }

    @Override
    @Transactional
    public User save(User user) {
        if (user.getPassword() != null){
            user.setEncryptedPassword(encryptionService.encryptionString(user.getPassword()));
        }
        return repository.saveAndFlush(user);
    }

    @Override
    public List<User> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<User> findById(Integer id) {
        return repository.findById(id);
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
    @Override
    public Integer deleteUserByUsername(String username) {
       return repository.deleteUserByUsername(username);
    }

    @Override
    public Page<User> findByUsername(String lastName, Pageable pageable) {
        return repository.findByUsername(lastName, pageable);
    }

    @Override
    public Page<User> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }
}
