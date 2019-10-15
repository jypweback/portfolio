package com.jypweback.portfolio.config;

import com.jypweback.portfolio.dto.MemberDto;
import com.jypweback.portfolio.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class AccountAddRunner implements ApplicationRunner {

    @Autowired
    MemberService memberService;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        MemberDto memberDto = new MemberDto();
        memberDto.setUserId("jypweback");
        memberDto.setUserPassword("1234");
        memberDto.setUserEmail("qkrwpdud1@naver.com");
        memberDto = memberService.createMember(memberDto);

        System.out.println("Application Runner : " + memberDto.getUserId() + " " + memberDto.getUserPassword());

    }
}
