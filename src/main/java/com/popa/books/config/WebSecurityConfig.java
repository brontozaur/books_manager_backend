package com.popa.books.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/login").permitAll()
                .antMatchers("/css/login.css").permitAll()
                .antMatchers("/api/**").permitAll()
                .antMatchers("/internal/**").hasRole("INTERNAL")
//                .anyRequest().fullyAuthenticated()
                .anyRequest().permitAll()
                .and().csrf().disable()
                .cors().disable()
                .httpBasic();

        http.formLogin()
                .loginPage("/login")
                .permitAll();
        http.logout().permitAll();

        http.sessionManagement()
                .maximumSessions(1).expiredUrl("/login?expired")
                .and()
                .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
                .invalidSessionUrl("/");

        http.csrf().disable();
    }
}