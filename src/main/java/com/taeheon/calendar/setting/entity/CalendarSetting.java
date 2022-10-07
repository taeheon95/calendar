package com.taeheon.calendar.setting.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class CalendarSetting {
    @Id
    @GeneratedValue
    private Long calendarSettingNo;
    private String dateFieldFormat;
    private Integer defaultEventLength;
    private Boolean format24HourTime;
    private Boolean hideInvitations;
    private Boolean hideWeekends;
    private String locale;
    private String timezone;
}
