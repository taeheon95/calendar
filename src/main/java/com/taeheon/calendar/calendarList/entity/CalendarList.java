package com.taeheon.calendar.calendarList.entity;

import com.taeheon.calendar.calendar.entity.CalendarEntity;
import com.taeheon.calendar.user.entity.User;
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
public class CalendarList {
    @Id
    @GeneratedValue
    private Long calendarListNo;
    @CreationTimestamp
    private LocalDateTime createTimestamp;
    @UpdateTimestamp
    private LocalDateTime updateTimestamp;
    @ManyToOne
    @JoinColumn(name = "user_no")
    private User user;
    @ManyToOne
    @JoinColumn(name = "calendar_no")
    private CalendarEntity calendar;

    @ManyToOne
    @JoinColumn(name = "role")
    private Role role;
    private String subjectOverride;
    private String colorId;
    private String backgroundColor;
    private String foregroundColor;
    private Boolean isHidden;
    private Boolean isPrimary;
    private Boolean isDeleted;

    public CalendarList(User user, CalendarEntity calendar, Role role) {
        this.user = user;
        this.calendar = calendar;
        this.subjectOverride = calendar.getSubject();
        this.isPrimary = false;
        this.isDeleted = false;
        this.colorId = "#ffffff";
        this.backgroundColor = "#ffffff";
        this.foregroundColor = "#ffffff";
        this.isHidden = false;
    }

}
