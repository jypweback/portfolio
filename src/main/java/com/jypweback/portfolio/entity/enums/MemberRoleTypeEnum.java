package com.jypweback.portfolio.entity.enums;

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
