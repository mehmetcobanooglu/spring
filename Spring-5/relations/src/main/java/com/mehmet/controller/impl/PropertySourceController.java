package com.mehmet.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mehmet.configuration.DataSource;
import com.mehmet.configuration.GlobalProperties;
import com.mehmet.configuration.Server;

@RestController
@RequestMapping("rest/api/property")
public class PropertySourceController {

    @Autowired
    private GlobalProperties globalProperties;

    @GetMapping("/datasource")
    public DataSource getDataSource() {

        return null;
    }

    @GetMapping("/getServers")
    public List<Server> getServers() {
        System.out.println("Key Değerim : " + globalProperties.getKey());
        return globalProperties.getServers();
    }
}
