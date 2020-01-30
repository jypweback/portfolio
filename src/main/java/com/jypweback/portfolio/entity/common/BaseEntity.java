package com.jypweback.portfolio.entity.common;

import lombok.Getter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Created by qkrwpdud1@gmail.com on 2019-10-11
 * Github : http://github.com/jypweback
 */


@DynamicInsert
@DynamicUpdate
@MappedSuperclass
@Getter
public abstract class BaseEntity {

    @Column(length = 200)
    private String creatorId;

    private LocalDateTime createDatetime;

    @Column(length = 200)
    private String editorId;

    private LocalDateTime updateDatetime;

    @PrePersist
    protected void onPersist(){

        if (!(SecurityContextHolder.getContext().getAuthentication() instanceof AnonymousAuthenticationToken) && SecurityContextHolder.getContext().getAuthentication() != null) {

            Authentication auth = (Authentication) SecurityContextHolder.getContext().getAuthentication();
            String username = null;

            try {
                username= auth.getName();
            } catch (Exception e) {
                e.printStackTrace();
            }

            this.creatorId = username;
        }

        this.createDatetime = LocalDateTime.now();

    }

    @PreUpdate
    protected void onUpdate(){

        if (!(SecurityContextHolder.getContext().getAuthentication() instanceof AnonymousAuthenticationToken) && SecurityContextHolder.getContext().getAuthentication() != null) {

            Authentication auth = (Authentication) SecurityContextHolder.getContext().getAuthentication();
            String username = null;

            try {
                username= auth.getName();
            } catch (Exception e) {
                e.printStackTrace();
            }

            this.editorId = username;
        }

        this.updateDatetime = LocalDateTime.now();
    }

}
