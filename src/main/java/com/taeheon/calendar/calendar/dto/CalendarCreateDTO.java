package com.taeheon.calendar.calendar.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CalendarCreateDTO {
    private String location;
    private String timezone;
    private String subject;
    private String description;
}
