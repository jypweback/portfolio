package com.jypweback.portfolio.controller.web;

import com.jypweback.portfolio.dto.MemberDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 * Created by qkrwpdud1@gmail.com on 2019-10-08
 * Github : http://github.com/jypweback
 */

@Controller
@AllArgsConstructor
public class WebController {

   /* @GetMapping("/")
    public String login(Model model) {
        Question question = Question.builder().title("1ddd,ㄴㄴㄴㄴㄴㄴㄴ").author("aa").content("zzz").build();
        model.addAttribute("question",question);
        return "login";
    }*/

    @GetMapping("/login")
    public String login(@ModelAttribute("loginForm") MemberDto memberDto, Model model) {
        return "login";
    }

    @GetMapping("/index")
    public String index() {
        return "view/index";
    }


    @GetMapping("/board")
    public String board(Model model)
    {
        return "view/board";
    }

    @GetMapping("/boards")
    public String boardList(Model model)
    {
        return "view/board/list";
    }

/*    @GetMapping("/blank")
    public String blank(Model model) {
        Question question = Question.builder().title("1").author("aa").content("zzz").build();

        QuestionReqDto dto = new QuestionReqDto();
        dto.setTitle("titlezzzz");
        dto.setContent("contentszzz");
        dto.setAuthor("authorzzzz");

        model.addAttribute("question", dto);
        return "view/blank";
    }*/
}
