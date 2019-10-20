package com.jypweback.portfolio.controller.web;

import com.jypweback.portfolio.dto.board.BoardResponseDto;
import com.jypweback.portfolio.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by qkrwpdud1@gmail.com on 2019-10-08
 * Github : http://github.com/jypweback
 */

@Controller
public class WebViewController {
    @GetMapping("/")
    public String create() {
        return "redirect:/boards";
    }

    @GetMapping("/login")
    public String hello() {
        return "login";
    }

    @GetMapping("/create")
    public String test1() {
        return "create";
    }

    @GetMapping("/tables")
    public String tables() {
        return "tables";
    }
}
