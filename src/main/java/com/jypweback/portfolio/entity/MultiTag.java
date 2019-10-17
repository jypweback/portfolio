package com.jypweback.portfolio.entity;

import com.jypweback.portfolio.entity.common.BaseEntity;
import com.jypweback.portfolio.entity.enums.MultiTagTypeEnum;
import com.jypweback.portfolio.entity.enums.MultiTagTypeEnumConverter;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity(name = "TBL_MULTI_TAG")
public class MultiTag extends BaseEntity {

    @Builder
    public MultiTag(MultiTagTypeEnum tagType, String tagText, String creatorId){
        this.tagType = tagType;
        this.tagText = tagText;
        this.creatorId = creatorId;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(updatable = false)
    private Long rid;

    @Convert(converter = MultiTagTypeEnumConverter.class)
    @Column(length = 50)
    private MultiTagTypeEnum tagType;

    @Column(columnDefinition = "TEXT")
    private String tagText;

    @Column(length = 200)
    private String creatorId;

    @Column(length = 200)
    private String editorId;

}
