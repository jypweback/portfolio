package com.jypweback.portfolio.controller.api;

import com.jypweback.portfolio.dto.MemberDto;
import com.jypweback.portfolio.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/member")
public class MemberController {

    @Autowired
    MemberService memberService;

    @GetMapping("/{role}/{username}/{password}")
    public MemberDto createMember(@ModelAttribute MemberDto memberDto){
        return this.memberService.createMember(memberDto);
    }
}
