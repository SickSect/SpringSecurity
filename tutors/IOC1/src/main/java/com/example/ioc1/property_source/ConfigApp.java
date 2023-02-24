package com.example.ioc1.property_source;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("com.example.ioc1.property_source")
@PropertySource("classpath:app.properties")
public class ConfigApp {
    /* or you can delete "@ComponentScan("com.example.ioc1.annotation_config")"
    * and start adding beans here in the config class */
}
