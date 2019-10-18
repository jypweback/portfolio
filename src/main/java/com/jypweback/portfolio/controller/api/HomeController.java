package com.jypweback.portfolio.controller.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by qkrwpdud1@gmail.com on 2019-10-08
 * Github : http://github.com/jypweback
 */

@RestController
public class HomeController {

    @GetMapping("/hello")
    public String hello(){
        return "Hello World";
    }

}
