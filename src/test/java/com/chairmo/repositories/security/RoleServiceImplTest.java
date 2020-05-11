package com.chairmo.repositories.security;

import com.chairmo.model.role.Role;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Profile("jpaDao")
public class RoleServiceImplTest {
    private RoleService roleService;
    @Autowired
    private void setRoleService(RoleService roleService){this.roleService = roleService; }

    private List<Role> roles;

    @Before
    public void setUp() throws Exception {
        roles = roleService.findAll();
    }
    @Test
    public void findAll() {
        assertEquals(3, roles.size());
    }

    @Test
    public void findById() {
        assertNotNull(roles.get(0).getId());
    }

    @Test
    public void deleteById() {
        roleService.deleteById(1);
        assertEquals(3, roles.size());
    }

    @Test
    public void findRoleByRole() {
        assert roles.get(0).getRole().equalsIgnoreCase("basics");
    }

}