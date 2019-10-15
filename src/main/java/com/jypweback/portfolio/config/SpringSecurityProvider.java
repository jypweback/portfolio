package com.jypweback.portfolio.config;

import com.jypweback.portfolio.dto.MemberDto;
import com.jypweback.portfolio.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class SpringSecurityProvider implements AuthenticationProvider {

    @Autowired
    MemberService memberService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String userId = authentication.getName();
        String password = (String) authentication.getCredentials();

        MemberDto formDto = new MemberDto();
        formDto.setUserId(userId);
        formDto.setUserPassword(userId);

        MemberDto memberDto = this.memberService.getMember(formDto);

        if(memberDto == null){
            throw new BadCredentialsException("Login Error !!");
        }

        memberDto.setUserPassword(null);

        ArrayList<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        return new UsernamePasswordAuthenticationToken(memberDto, null, authorities);
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return false;
    }
}
