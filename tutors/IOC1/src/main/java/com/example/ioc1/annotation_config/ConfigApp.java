package com.example.ioc1.annotation_config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.example.ioc1.annotation_config")
public class ConfigApp {
    /* or you can delete "@ComponentScan("com.example.ioc1.annotation_config")"
    * and start adding beans here in the config class */
}
