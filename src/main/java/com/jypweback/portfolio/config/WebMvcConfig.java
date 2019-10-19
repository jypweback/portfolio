package com.jypweback.portfolio.config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.persistence.Converter;

/**
 * Created by qkrwpdud1@gmail.com on 2019-10-19
 * Github : http://github.com/jypweback
 */

/*
@Configuration
@EnableWebMvc
public class WebMvcConfig implements WebMvcConfigurer, ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // TODO Auto-generated method stub
        registry.addResourceHandler("/css/**").addResourceLocations("classpath:/static/css/");
        registry.addResourceHandler("/img/**").addResourceLocations("classpath:/static/img/");
        registry.addResourceHandler("/js/**").addResourceLocations("classpath:/static/js/").setCachePeriod(0);
        registry.addResourceHandler("/scss/**").addResourceLocations("classpath:/static/scss/");
        registry.addResourceHandler("/vendor/**").addResourceLocations("classpath:/static/vendor/").setCachePeriod(0);
        registry.addResourceHandler("/resources/**").addResourceLocations("classpath:/resources/");
    }



}
  */