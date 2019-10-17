package com.jypweback.portfolio.entity.enums;

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
