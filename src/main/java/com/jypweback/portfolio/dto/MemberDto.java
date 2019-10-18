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
        this.userId = member.getUserId();
        this.userPassword = member.getUserPassword();
        this.userEmail = member.getUserEmail();
    }

    private Long id;

    private String userId;

    private String userPassword;

    private String userEmail;

    public Member toEntity(){
        return Member.builder()
                .userId(this.userId)
                .userPassword(this.userPassword)
                .userEmail(this.userEmail)
                .build();
    }
}
