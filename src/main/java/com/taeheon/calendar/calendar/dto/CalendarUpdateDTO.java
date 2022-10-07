package com.taeheon.calendar.calendar.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CalendarUpdateDTO {
    private String location;
    private String timezone;
    private String subject;
    private String description;
}
