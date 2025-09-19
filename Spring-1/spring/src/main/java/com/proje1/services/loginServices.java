package com.proje1.services;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.proje1.config.AppConfig;

public class loginServices {
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
    UserServies userServies = context.getBean(com.proje1.services.UserServies.class);
}
