package com.ireland.task.todolist.service;


import org.springframework.context.annotation.Bean;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomUserDetailService implements UserDetailsService {

    private List<SimpleGrantedAuthority> roles = new ArrayList<>();
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return new User("test","$2a$10$2rrQh/zbZENNOSveUd1iPuSiM9XCZu3IYj59wpeutwuWRtTYrDKIe",roles);
    }
}
