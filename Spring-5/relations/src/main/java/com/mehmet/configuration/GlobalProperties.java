package com.mehmet.configuration;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
@ConfigurationProperties(prefix = "app")
public class GlobalProperties {

    private List<Server> servers;

    @Value("${key}")

    private String key;
}
