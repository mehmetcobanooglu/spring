package com.mehmetcobanoglu.controller.impl;

import org.springframework.beans.factory.support.RootBeanDefinition;

import com.mehmetcobanoglu.model.RootEntity;

public class RestBaseController {

    public <T> RootEntity<T> ok(T data) {
        return RootEntity.ok(data);
    }

    public <T> RootEntity<T> error(String errorMessage) {
        return RootEntity.error(errorMessage);
    }

}
