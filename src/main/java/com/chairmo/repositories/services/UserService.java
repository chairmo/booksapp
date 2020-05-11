package com.chairmo.repositories.services;

import com.chairmo.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.util.List;
import java.util.Optional;

public interface UserService {
    User save(User user);
    List<User> findAll();
    Optional<User> findById(Integer id);
    void deleteById(Integer id);
    Integer deleteUserByUsername(String username);

    //Using Page and pageable
    Page<User> findByUsername(String lastName, Pageable pageable);
    Page<User> findAll(Pageable pageable);
}
