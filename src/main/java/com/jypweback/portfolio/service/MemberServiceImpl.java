package com.jypweback.portfolio.service;

import com.jypweback.portfolio.dto.MemberDto;
import com.jypweback.portfolio.entity.Member;
import com.jypweback.portfolio.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qkrwpdud1@gmail.com on 2019-10-18
 * Github : http://github.com/jypweback
 */

@Service
public class MemberServiceImpl implements MemberService, UserDetailsService {

    @Autowired
    MemberRepository memberRepository;

    @Override
    public MemberDto createMember(MemberDto memberDto) {

        Member member = Member.builder()
                .username(memberDto.getUsername())
                .password(memberDto.getPassword())
                .email(memberDto.getEmail()).build();

        return new MemberDto(this.memberRepository.save(member));
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Member member = this.memberRepository.findByUsername(username).get();

        if(member == null){
            throw new UsernameNotFoundException(username);
        }

        return User.builder()
                .username(member.getUsername())
                .password(member.getPassword())
                .roles(member.getRole())
                .build();

    }
}
