package com.example.eindopdrachtnovibackend.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import javax.sql.DataSource;
@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(dataSource);
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    // Secure the endpoints with HTTP Basic authentication
    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                //HTTP Basic authentication
                .httpBasic()
                .and()
                .authorizeRequests()
                //admin
//                .antMatchers(HttpMethod.GET, "/api/v1/**").hasRole("ADMIN")
                //mechanic
                .antMatchers("/api/v1/repair-jobs/**").hasAnyRole("MECHANIC", "ADMIN")
                .antMatchers(HttpMethod.GET, "/admin/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET,"/authenticated/**").authenticated()
                .anyRequest().permitAll()
                .and()
                .csrf().disable()
                .formLogin().disable();
        // add this line to use H2 web console
        httpSecurity.headers().frameOptions().disable();
    }
}