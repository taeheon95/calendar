package com.taeheon.calendar.event.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class EventExcept {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "event_no")
    private EventEntity event;


    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "date", column = @Column(name = "start_date")),
            @AttributeOverride(name = "datetime", column = @Column(name = "start_datetime")),
            @AttributeOverride(name = "timezone", column = @Column(name = "start_timezone"))
    })
    private EventTime startDateTime;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "date", column = @Column(name = "end_date")),
            @AttributeOverride(name = "datetime", column = @Column(name = "end_datetime")),
            @AttributeOverride(name = "timezone", column = @Column(name = "end_timezone"))
    })
    private EventTime endDateTime;
}
