package com.taeheon.calendar.event.entity;

import com.taeheon.calendar.event.enums.AttendeeResponseStatus;
import com.taeheon.calendar.event.enums.AttendeeType;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class Attendee {
    @Id
    @GeneratedValue
    private Long attendeeNo;

    @ManyToOne
    @JoinColumn(name = "event_no")
    private EventEntity event;

    @Enumerated(EnumType.STRING)
    private AttendeeType type;

    @Enumerated(EnumType.STRING)
    private AttendeeResponseStatus responseStatus;

    private String email;

    private Boolean isDeleted;
}
