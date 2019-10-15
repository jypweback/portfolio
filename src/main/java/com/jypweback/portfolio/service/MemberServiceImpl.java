package com.jypweback.portfolio.service;

import com.jypweback.portfolio.dto.MemberDto;
import com.jypweback.portfolio.entity.Member;
import com.jypweback.portfolio.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    MemberRepository memberRepository;

    @Override
    public MemberDto createMember(MemberDto memberDto) {

        Member member = Member.builder()
                .userId(memberDto.getUserId())
                .userPassword(memberDto.getUserPassword())
                .userEmail(memberDto.getUserEmail()).build();

        return new MemberDto(this.memberRepository.save(member));
    }

    @Override
    public MemberDto getMember(MemberDto memberDto) {
        Member member = this.memberRepository.findByUserIdAndUserPassword(memberDto.getUserId(), memberDto.getUserPassword()).get();
        return new MemberDto(member);
    }
}
