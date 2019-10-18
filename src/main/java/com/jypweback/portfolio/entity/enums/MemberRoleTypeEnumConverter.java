package com.jypweback.portfolio.entity.enums;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * Created by qkrwpdud1@gmail.com on 2019-10-11
 * Github : http://github.com/jypweback
 */

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



