package com.boot.ugina.bootexmpl.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

   /* @Bean
    EmbeddedDatabase dataSource(){

    }*/
    @Bean
    JdbcUserDetailsManager jdbcUserDetailsManager(DataSource source ){
        UserDetails admin = User.builder()
                .username("admin")
                .password("password")
                .roles("ADMIN")
                .build();
        JdbcUserDetailsManager user = new JdbcUserDetailsManager(source);
        user.createUser(admin);
        return user;
    }

    /*//@EnableMethodSecurity belong to this
    @Bean
    InMemoryUserDetailsManager userDetailsManager(){
        return new InMemoryUserDetailsManager(User.withUsername("mainuser").
                password("{noop}password").
                roles("ADMIN").
                build());
    }*/
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.authorizeHttpRequests(auth ->
                auth.anyRequest().authenticated())
                //can use '.antMatchers("/address/to/permit").permitAll()' 
                .formLogin().and().httpBasic().and().build();
    }
}
