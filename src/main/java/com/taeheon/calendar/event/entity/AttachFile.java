package com.taeheon.calendar.event.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class AttachFile {
    @Id
    @GeneratedValue
    private Long attachFileNo;

    @ManyToOne
    @JoinColumn(name = "event_no")
    private EventEntity event;

    private String name;

    private String uuid;

    private String ext;

    private Boolean isDeleted;

    private Long createUserNo;

    @CreationTimestamp
    private LocalDateTime createTimestamp;

    @UpdateTimestamp
    private LocalDateTime updateTimestamp;
}
