package com.boot.ugina.bootexmpl.config;

import com.boot.ugina.bootexmpl.entity.Customer;
import com.boot.ugina.bootexmpl.entity.Role;
import com.boot.ugina.bootexmpl.repo.CustomerRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerUserDetailService implements UserDetailsService {
    private CustomerRepo repo;
    private Logger log = LoggerFactory.getLogger(CustomerUserDetailService.class);
    @Autowired
    public CustomerUserDetailService(CustomerRepo repo) {
        this.repo = repo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Customer customer = repo.findByUsername(username).orElseThrow(()->{
            log.error("Can't find user with username:" + username);
            return new UsernameNotFoundException("Can't find user with username:" + username);
        });
        return new User(customer.getUsername(), customer.getPassword(), mapRolesToAuthorities(customer.getRoles()));
    }

    //it will convert our roles to granted authorities
    private Collection<GrantedAuthority> mapRolesToAuthorities(List<Role> list){
        return list.stream().map(role ->
                new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }
}
