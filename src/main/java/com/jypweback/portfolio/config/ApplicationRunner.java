package com.jypweback.portfolio.config;

import com.jypweback.portfolio.dto.MemberDto;
import com.jypweback.portfolio.entity.Member;
import com.jypweback.portfolio.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/**
 * Created by qkrwpdud1@gmail.com on 2019-10-18
 * Github : http://github.com/jypweback
 */

@Component
@Profile({"local"})
public class ApplicationRunner implements CommandLineRunner {

    @Autowired
    private MemberService memberService;

    @Override
    public void run(String... args) throws Exception {
        Member member = Member.builder().username("jypweback").password("123").email("jypweback@gmail.com").build();
        this.memberService.createMember(new MemberDto(member));
    }
}
