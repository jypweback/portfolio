package com.jypweback.portfolio.repository;

import com.jypweback.portfolio.entity.Member;
import com.jypweback.portfolio.entity.MemberRole;
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

        this.memberRepository.save(Member.builder().userId("jypweback").userPassword("password").userEmail("jypweback@hunet.co.kr").build());

        Member member = this.memberRepository.findByUserId("jypweback").get();

        assertThat(member.getUserId(), is("jypweback"));

    }

    @Test
    public void 사용자_AND_권한_등록(){

        Member newMember = Member.builder().userId("test1").userPassword("test1").userEmail("test1@hunet.co.kr").build();
        MemberRole memberRole = new MemberRole(MemberRoleTypeEnum.ADMIN);
        newMember.addRole(memberRole);
        this.memberRepository.save(newMember);

        Member member = this.memberRepository.findByUserId("test1").get();

        assertThat(member.getUserId(), is("test1"));
        assertThat(member.getRoles().get(0).getRoleName(), is(MemberRoleTypeEnum.ADMIN));

    }

}