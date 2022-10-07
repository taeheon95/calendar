package com.taeheon.calendar.event.entity;

import com.taeheon.calendar.event.enums.ReminderMethod;
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
public class Reminder {
    @Id
    @GeneratedValue
    private Long reminderNo;

    @ManyToOne
    @JoinColumn(name = "event_no")
    private EventEntity event;

    @Enumerated(EnumType.STRING)
    private ReminderMethod method;

    private Integer minutes;

    private Boolean isDeleted;

    private Long createUserNo;

    private Long updateUserNo;

    @CreationTimestamp
    private LocalDateTime createTimestamp;

    @UpdateTimestamp
    private LocalDateTime updateTimestamp;

    public void setMethod(ReminderMethod method) {
        this.method = method;
    }

    public void setMinutes(Integer minutes) {
        this.minutes = minutes;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }
}
