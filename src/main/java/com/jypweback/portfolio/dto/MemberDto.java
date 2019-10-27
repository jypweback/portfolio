package com.jypweback.portfolio.dto;

import com.jypweback.portfolio.entity.Member;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by qkrwpdud1@gmail.com on 2019-10-08
 * Github : http://github.com/jypweback
 */

@Getter
@Setter
@NoArgsConstructor
public class MemberDto {

    public MemberDto(Member member){
        this.id = member.getId();
        this.username = member.getUsername();
        this.password = member.getPassword();
        this.email = member.getEmail();
        this.role = member.getRole();
    }

    private Long id;

    private String username;

    private String password;

    private String email;

    private String role;

    public Member toEntity(){
        return Member.builder()
                .username(this.username)
                .password(this.password)
                .email(this.email)
                .role(this.role)
                .build();
    }
}
