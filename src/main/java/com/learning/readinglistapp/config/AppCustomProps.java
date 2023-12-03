package com.learning.readinglistapp.config;


import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


@Getter @Setter
@Component
@ConfigurationProperties(prefix = "custom")
public class AppCustomProps {
    private String appName;
    private Long appPort;
}
