package com.taeheon.calendar.event.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Embeddable;
import java.util.Date;

@Getter
@Setter
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class EventTime {
    private String date;
    private Date datetime;
    private String timezone;
}
