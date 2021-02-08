package com.ireland.task.todolist.config;

import com.ireland.task.todolist.service.CustomUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.ExceptionMappingAuthenticationFailureHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class Config {

    @Bean
    public MessageSource messageSource(){
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setDefaultEncoding("UTF-8");
        messageSource.setBasename("messages");
        return messageSource;
    }

    @Configuration
    @EnableWebSecurity
    protected static class SecurityConfig extends WebSecurityConfigurerAdapter {

        @Autowired
        CustomUserDetailService customuserdetailservice;

        @Bean
        public PasswordEncoder passwordEncoder() {
            return new BCryptPasswordEncoder();
        }

        @Bean
        public ExceptionMappingAuthenticationFailureHandler authenticationFailureHandler() {
            ExceptionMappingAuthenticationFailureHandler authenticationfailurehandler = new ExceptionMappingAuthenticationFailureHandler();
            authenticationfailurehandler.setDefaultFailureUrl("/login?error");
            final Map<String, String> mappings = new HashMap<>();
            authenticationfailurehandler.setExceptionMappings(mappings);
            return authenticationfailurehandler;
        }

        @Override
        public void configure(AuthenticationManagerBuilder registry) throws Exception {
            registry.userDetailsService(customuserdetailservice).passwordEncoder(passwordEncoder());
        }

        @Override
        public void configure(WebSecurity web) {
            web.ignoring().antMatchers("/webjars/**", "/fonts/**", "/json/**", "/print/**");
        }

        @Override
        public void configure(HttpSecurity http) throws Exception {
            http
                    .authorizeRequests()
                        .antMatchers("/login").permitAll()
                        .anyRequest().authenticated()
                        .and()
                    .formLogin()
                        .loginPage("/login")
                        .failureHandler(authenticationFailureHandler())
                        .and()
                    .logout()
                        .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                        .invalidateHttpSession(true)
                        .and()
                    .exceptionHandling()
                        .accessDeniedPage("/access?error")
                         .and()
                    .csrf();



        }
    }

}