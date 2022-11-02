package com.taeheon.calendar.event.dto;

import lombok.Getter;

import java.util.Date;

@Getter
public class EventSearchParams {
    private String summary;
    private Date startDate;
    private Date endDate;
    private Integer maxResults;
    private String timezone;
}
