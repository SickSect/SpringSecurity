package com.example.secprop;

import com.example.secprop.entity.AppUser;
import com.example.secprop.entity.Role;
import com.example.secprop.service.AppUserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

@SpringBootApplication
public class SecPropApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecPropApplication.class, args);
    }

    @Bean
    CommandLineRunner run(AppUserService service){
        return args -> {
            service.saveRole(new Role(null, "USR"));
            service.saveRole(new Role(null, "ADM"));
            service.saveRole(new Role(null, "SU_USR"));
            service.saveRole(new Role(null, "MNG"));

            service.saveUser(new AppUser(null,"Strange Name", "stranger", "123", new ArrayList<>()));
            service.saveUser(new AppUser(null,"Scolp Delta", "rango", "456", new ArrayList<>()));
            service.saveUser(new AppUser(null,"Alpha Criek", "salto", "789", new ArrayList<>()));
            service.saveUser(new AppUser(null,"Beta Tamer", "wow", "101", new ArrayList<>()));

            service.addRoleToUser("stranger", "ADM");
            service.addRoleToUser("rango", "USR");
            service.addRoleToUser("salto", "SU_USR");
            service.addRoleToUser("wow", "ADM");
        };
    }
}
