package com.lazerrent.spring.infra.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("**/public/**").permitAll() // Acesso público
                .antMatchers("**/admin/**").hasRole("ADMIN") // Apenas ADMIN
                .antMatchers("**/user/**").hasAnyRole("USER", "ADMIN") // USER ou ADMIN
                .anyRequest().authenticated() // Qualquer outro endpoint requer login
                .and()
            .formLogin()
                .loginPage("/login") // Página de login customizada
                .permitAll()
                .and()
            .logout()
                .permitAll();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); // Encoder para senhas
    }
}

