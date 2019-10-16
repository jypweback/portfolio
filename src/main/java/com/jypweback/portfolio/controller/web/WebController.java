package com.jypweback.portfolio.controller.web;

import com.jypweback.portfolio.dto.MemberDto;
import com.jypweback.portfolio.dto.QuestionReqDto;
import com.jypweback.portfolio.entity.Question;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
@AllArgsConstructor
public class WebController {

    @GetMapping("/test")
    public String test(Model model) {

        QuestionReqDto dto = new QuestionReqDto();
        dto.setTitle("titlezzzz");
        dto.setContent("contentszzz");
        dto.setAuthor("authorzzzz");

        model.addAttribute("question", dto);


        return "view/test";
    }

    @GetMapping("/")
    public String login(Model model) {
        Question question = Question.builder().title("1ddd,ㄴㄴㄴㄴㄴㄴㄴ").author("aa").content("zzz").build();
        model.addAttribute("question",question);
        return "login";
    }

    @GetMapping("/login")
    public String login(@ModelAttribute("loginForm") MemberDto memberDto, Model model) {
        return "login";
    }

    @GetMapping("/index")
    public String index() {
        return "view/index";
    }


    @GetMapping("/guestbook")
    public String guestBook(Model model)
    {
        return "view/guestbook";
    }

    @GetMapping("/blank")
    public String blank(Model model) {
        Question question = Question.builder().title("1").author("aa").content("zzz").build();

        QuestionReqDto dto = new QuestionReqDto();
        dto.setTitle("titlezzzz");
        dto.setContent("contentszzz");
        dto.setAuthor("authorzzzz");

        model.addAttribute("question", dto);
        return "view/blank";
    }
}
