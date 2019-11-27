package com.jypweback.portfolio.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

/**
 * Created by qkrwpdud1@gmail.com on 2019-11-27
 * Github : http://github.com/jypweback
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestAServiceTest {

    @Autowired
    ApplicationContext applicationContext;

    @Test
    public void 스프링빈출력(){
        System.out.println("##########################" + Arrays.asList(applicationContext.getBeanDefinitionNames()));
    }

}