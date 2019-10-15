package com.jypweback.portfolio.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private SpringSecurityProvider provider;

    @Override
    public void configure(WebSecurity web) throws Exception {
        //web.ignoring().antMatchers("/h2-console");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers("/css/**", "/img/**","/js/**","/scss/**","/vendor/**").permitAll()
                .antMatchers("/index/**").hasRole("ADMIN") // 내부적으로 접두어 "ROLE_"가 붙는다.
                //.antMatchers("/auth/**").hasAnyRole("ADMIN", "USER") // 내부적으로 접두어 "ROLE_"가 붙는다.
                .anyRequest().authenticated();

        http.formLogin()
                .loginPage("/login") // default
                .loginProcessingUrl("/authenticate")
                .failureUrl("/login?error") // default
                .defaultSuccessUrl("/index")
                .usernameParameter("userId")
                .passwordParameter("userPassword")
                .permitAll();

        http.logout()
                .logoutUrl("/logout") // default
                .logoutSuccessUrl("/login")
                .permitAll();


/*
        http.authorizeRequests().antMatchers("/").permitAll()
        .and().authorizeRequests().antMatchers("/console/**").permitAll();

        http.csrf().disable();
        http.headers().frameOptions().disable();
 */

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) {
        auth.authenticationProvider(provider);
    }
}
