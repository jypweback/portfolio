package com.jypweback.portfolio.entity.enums;

/**
 * Created by qkrwpdud1@gmail.com on 2019-10-11
 * Github : http://github.com/jypweback
 */

public enum MultiTagTypeEnum {

    BOARD("BOARD"),
    COMMENT("COMMENT"),
    ;

    private String tagType;
    private MultiTagTypeEnum(String tagType) {
        this.tagType = tagType;
    }

    public String getTagType() {
        return this.tagType;
    }

    public static MultiTagTypeEnum getType(String id) {
        if (id == null) {
            return null;
        }

        for (MultiTagTypeEnum type : MultiTagTypeEnum.values()) {
            if (id.equals(type.getTagType())) {
                return type;
            }
        }

        throw new IllegalArgumentException("Unknown " + id);
    }
}
