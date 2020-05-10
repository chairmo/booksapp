package com.chairmo.service.jpaServices;

import com.chairmo.config.IntegrationTestConfig;
import com.chairmo.model.Author;
import com.chairmo.model.User;
import com.chairmo.service.AuthorService;
import com.chairmo.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = IntegrationTestConfig.class)
public class UserServiceImplTest {
    private UserService userService;
    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }


    @Test
    public void listAll() throws Exception {

        List<?> userList = userService.listAll();

        assert userList.size() == 0;
    }

    @Test
    public void saveAUser() {
        User user = new User();

        Author author = new Author();
        author.setDob(LocalDate.of(2000, 2, 23));
        author.setLastName("james");
        author.setFirstName("jatau");
        author.setEmail("jay@gmail.com");

        user.setUsername("chairmo");
        user.setPassword("james");
        user.setAuthor(new Author());

        User savedUser = userService.saveOrUpdate(user);

        assert savedUser.getId() != null;
        assert savedUser.getAuthor().getId() != null;
        assert savedUser.getAuthor().getEmail().equals("jay@gmail.com");
    }
}