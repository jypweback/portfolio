package com.jypweback.portfolio.config;

import com.jypweback.portfolio.entity.Member;
import com.jypweback.portfolio.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by qkrwpdud1@gmail.com on 2019-11-09
 * Github : http://github.com/jypweback
 */

public class CustomAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler{

    @Autowired
    private MemberRepository memberRepository;

    /**
     * Login Success Handler
     * 로그인 성공시 사용자의 마지막 접속일을 갱신한다.
     */
    @Transactional
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws ServletException, IOException {
        User user = (User)authentication.getPrincipal();

        if(user != null){
            Member member = this.memberRepository.findByUsername(user.getUsername()).get();
            member.updateLastLoginDateTIme();
        }
        super.onAuthenticationSuccess(request, response, authentication);
    }
}
