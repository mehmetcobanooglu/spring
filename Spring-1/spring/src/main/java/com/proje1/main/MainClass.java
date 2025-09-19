package com.proje1.main;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.proje1.config.AppConfig;
import com.proje1.config.userService;
import com.proje1.model.User;
import com.proje1.services.UserServies;

public class MainClass {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        UserServies userServies = context.getBean(com.proje1.services.UserServies.class);
        for (User user : userServies.getUserList()) {
            System.out.println(user);
        }
    }
}
