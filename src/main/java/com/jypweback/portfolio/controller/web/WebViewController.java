package com.jypweback.portfolio.controller.web;

import com.jypweback.portfolio.dto.board.BoardResponseDto;
import com.jypweback.portfolio.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

/**
 * Created by qkrwpdud1@gmail.com on 2019-10-08
 * Github : http://github.com/jypweback
 */

@Controller
public class WebViewController {

    @GetMapping("/")
    public String home() {
        return "view/dashboard";
    }

    @GetMapping("/dashboard")
    public String dashboard() {
        return "view/dashboard";
    }

    @GetMapping("/login")
    public String login() {
        return "view/login";
    }

    @GetMapping("/access-denied")
    public String accessDenied(Principal principal, Model model){
        model.addAttribute("name", principal.getName());
        return "view/access-denied";
    }

}
