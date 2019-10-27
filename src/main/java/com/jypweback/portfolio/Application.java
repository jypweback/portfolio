package com.jypweback.portfolio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Created by qkrwpdud1@gmail.com on 2019-10-03
 * Github : http://github.com/jypweback
 */

@SpringBootApplication
@EnableJpaAuditing
public class Application {

    @Bean
    public PasswordEncoder passwordEncoder(){return PasswordEncoderFactories.createDelegatingPasswordEncoder(); }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
