package com.jypweback.portfolio.entity;

import com.jypweback.portfolio.entity.common.BaseEntity;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by qkrwpdud1@gmail.com on 2019-10-11
 * Github : http://github.com/jypweback
 */

@Entity
@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode(of = "userId")
public class Member extends BaseEntity {

    @Builder
    public Member(String userId, String userPassword, String userEmail) {
        this.userId = userId;
        this.userPassword = userPassword;
        this.userEmail = userEmail;
    }

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, unique = true, length = 50)
    private String userId;

    @Column(nullable = false, length = 200)
    private String userPassword;

    @Column(nullable = false, length = 50)
    private String userEmail;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<MemberRole> roles = new ArrayList<MemberRole>();

    public void addRole(MemberRole role){
        role.setMember(this);
    }
}
