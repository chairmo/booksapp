package com.chairmo.repositories;

import com.chairmo.model.role.Role;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    //Using Page and pageable
    Page<Role> findRoleByRole(Role role, Pageable pageable);
    Page<Role> findAll(Pageable pageable);
}
