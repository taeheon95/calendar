package com.taeheon.calendar.calendar.dto;

import com.taeheon.calendar.calendar.entity.CalendarEntity;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CalendarDTO {
    private final Long calendarNo;
    private final String location;
    private final String timezone;
    private final String subject;
    private final String description;
    private final Boolean isDeleted;
    private final Long createUserNo;
    private final LocalDateTime createTimestamp;
    private final Long updateUserNo;
    private final LocalDateTime updateTimestamp;

    public CalendarDTO(CalendarEntity calendarEntity) {
        this.calendarNo = calendarEntity.getCalendarNo();
        this.location = calendarEntity.getLocation();
        this.timezone = calendarEntity.getTimezone();
        this.subject = calendarEntity.getSubject();
        this.description = calendarEntity.getDescription();
        this.isDeleted = calendarEntity.getIsDeleted();
        this.createUserNo = calendarEntity.getCreateUserNo();
        this.createTimestamp = calendarEntity.getCreateTimestamp();
        this.updateUserNo = calendarEntity.getUpdateUserNo();
        this.updateTimestamp = calendarEntity.getUpdateTimestamp();
    }
}
