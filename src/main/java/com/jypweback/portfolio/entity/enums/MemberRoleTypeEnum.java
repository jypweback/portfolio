package com.jypweback.portfolio.entity.enums;

/**
 * Created by qkrwpdud1@gmail.com on 2019-10-11
 * Github : http://github.com/jypweback
 */

public enum MemberRoleTypeEnum {

    ADMIN("ADMIN"),
    BASIC("BASIC"),
    GUEST("GUEST")
    ;

    private String roleName;
    private MemberRoleTypeEnum(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleName() {
        return this.roleName;
    }

    public static MemberRoleTypeEnum getType(String id) {
        if (id == null) {
            return null;
        }

        for (MemberRoleTypeEnum type : MemberRoleTypeEnum.values()) {
            if (id.equals(type.getRoleName())) {
                return type;
            }
        }

        throw new IllegalArgumentException("Unknown " + id);
    }
}
