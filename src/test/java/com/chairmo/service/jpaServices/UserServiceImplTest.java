package com.chairmo.service.jpaServices;

import com.chairmo.model.*;
import com.chairmo.service.ProductService;
import com.chairmo.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceImplTest {
    private UserService userService;
    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }


    @Test
    public void listAll() throws Exception {
        User user = new User();
        user.setUsername("chairmo");
        user.setPassword("james");
        userService.saveOrUpdate(user);

        List<User> userList = (List<User>) userService.listAll();

        assert userList.size() != 0;
    }

    @Test
    public void saveAUser() {
        User user = new User();

        user.setUsername("chairmo");
        user.setPassword("james");
        User savedUser = userService.saveOrUpdate(user);

        assert savedUser.getId() != null;
    }

}