package com.chairmo.repositories;

import com.chairmo.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;


public interface UserRepository extends JpaRepository<User, Integer> {
    @Transactional(readOnly = true)
    Page<User> findByUsername(String lastName, Pageable pageable);
    @Transactional(readOnly = true)
    Page<User> findAll(Pageable pageable);

    @Transactional
    Integer deleteUserByUsername(String username);
}
