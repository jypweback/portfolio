package com.jypweback.portfolio.entity.enums;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class MultiTagTypeEnumConverter implements AttributeConverter<MultiTagTypeEnum, String> {

    @Override
    public MultiTagTypeEnum convertToEntityAttribute(String dbData) {
        return MultiTagTypeEnum.getType(dbData);
    }

    @Override
    public String convertToDatabaseColumn(MultiTagTypeEnum attribute) {
        return attribute != null ? attribute.getTagType() : null;
    }
}



