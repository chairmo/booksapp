package com.chairmo.service.jpaServices;


import com.chairmo.config.IntegrationTestConfig;
import com.chairmo.dump.SpringJPABootstrap;
import com.chairmo.model.Author;
import com.chairmo.service.AuthorService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = IntegrationTestConfig.class)
public class AuthorServiceImplTest {

    private AuthorService authorService;

    @Autowired
    public void setAuthorService(AuthorService authorService) {
        this.authorService = authorService;
    }

    @org.junit.Test
    public void listAll() {
        List<Author> authorList = (List<Author>) authorService.listAll();
        assert authorList.size() == 6;
    }
}