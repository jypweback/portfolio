package com.jypweback.portfolio.entity.common;

import lombok.Getter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;


@DynamicInsert
@DynamicUpdate
@MappedSuperclass
@Getter
public abstract class BaseEntity {

    private LocalDateTime createDatetime;
    private LocalDateTime updateDatetime;

    @PrePersist
    protected void onPersist(){
        this.createDatetime = LocalDateTime.now();

    }

    @PreUpdate
    protected void onUpdate(){
        this.updateDatetime = LocalDateTime.now();

    }

}
