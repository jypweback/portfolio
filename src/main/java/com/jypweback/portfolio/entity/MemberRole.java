package com.jypweback.portfolio.entity;

import com.jypweback.portfolio.entity.enums.MemberRoleTypeEnum;
import com.jypweback.portfolio.entity.enums.MemberRoleTypeEnumConverter;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode(of = "id")
public class MemberRole {

    public MemberRole(MemberRoleTypeEnum roleName) {
        this.roleName = roleName;
    }

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @Convert(converter = MemberRoleTypeEnumConverter.class)
    @Column(nullable = false, length=50)
    private MemberRoleTypeEnum roleName;

    public void setMember(Member member){
        if(this.member != null){
            this.member.getRoles().remove(this);
        }

        this.member = member;
        member.getRoles().add(this);
    }
}
