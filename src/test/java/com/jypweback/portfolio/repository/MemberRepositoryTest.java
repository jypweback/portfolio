package com.jypweback.portfolio.repository;

import com.jypweback.portfolio.entity.Member;
import com.jypweback.portfolio.entity.enums.MemberRoleTypeEnum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;


    @Test
    public void 사용자_등록(){

        this.memberRepository.save(Member.builder().username("jypweback").password("password").email("jypweback@hunet.co.kr").build());

        Member member = this.memberRepository.findByUsername("jypweback").get();

        assertThat(member.getUsername(), is("jypweback"));

    }

    @Test
    public void 사용자_AND_권한_등록(){

        Member newMember = Member.builder().username("test1").password("test1").email("test1@hunet.co.kr").role(MemberRoleTypeEnum.ADMIN.getCode()).build();
        this.memberRepository.save(newMember);

        Member member = this.memberRepository.findByUsername("test1").get();

        assertThat(member.getUsername(), is("test1"));
        assertThat(member.getRole(), is(MemberRoleTypeEnum.ADMIN.getCode()));

    }

}