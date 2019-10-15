package com.jypweback.portfolio.entity.enums;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class MemberRoleTypeEnumConverter implements AttributeConverter<MemberRoleTypeEnum, String> {

    @Override
    public MemberRoleTypeEnum convertToEntityAttribute(String dbData) {
        return MemberRoleTypeEnum.getType(dbData);
    }

    @Override
    public String convertToDatabaseColumn(MemberRoleTypeEnum attribute) {
        return attribute != null ? attribute.getRoleName() : null;
    }
}



