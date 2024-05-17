package com.sparta.planner.entity;

import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class) //Auditing Enitity 생성/수정/삭제시 시간기록
public abstract class TimeStamped {

    @CreatedDate
    @Column(updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime createdAt;

//    @LastModifiedDate
//    @Column
//    @Temporal(TemporalType.TIMESTAMP)
//    private LocalDateTime modifiedAt; //현재로서는 필요 없음
}