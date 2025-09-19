package com.proje1.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.proje1.model.User;
import com.proje1.services.UserServies;

@Configuration
public class AppConfig {

    @Bean
    public com.proje1.services.UserServies UserServies() {
        UserServies userService = new UserServies();

        List<User> userList = new ArrayList<>();
        userList.add(new User("Mehmet"));
        userList.add(new User("Büşra"));

        userService.setUserList(userList);
        return userService;
    }
}
