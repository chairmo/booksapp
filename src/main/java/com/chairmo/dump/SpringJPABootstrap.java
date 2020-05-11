package com.chairmo.dump;


import com.chairmo.model.User;
import com.chairmo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;


@Component
public class SpringJPABootstrap implements ApplicationListener<ContextRefreshedEvent> {


    private UserService userService;
    @Autowired
    private void setAuthorService(UserService userService){
        this.userService = userService;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        loadUsers();
    }

    private void loadUsers(){

        User user = new User();
        user.setUsername("jayboi");
        user.setPassword("jayjay");
        userService.saveOrUpdate(user);

        User user1 = new User();
        user1.setUsername("jayboi");
        user1.setPassword("jayjay");
        userService.saveOrUpdate(user1);
    }

}
