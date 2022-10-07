package com.taeheon.calendar.event.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Event")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class EventEntity {
    @Id
    @GeneratedValue
    private Long eventNo;

    private Long calendarNo;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "date", column = @Column(name = "start_date")),
            @AttributeOverride(name = "datetime", column = @Column(name = "start_datetime")),
            @AttributeOverride(name = "timezone", column = @Column(name = "start_timezone"))
    })
    private EventTime start;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "date", column = @Column(name = "end_date")),
            @AttributeOverride(name = "datetime", column = @Column(name = "end_datetime")),
            @AttributeOverride(name = "timezone", column = @Column(name = "end_timezone"))
    })
    private EventTime end;
    private String recurrence;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "event")
    private List<Reminder> reminders = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "event")
    private List<AttachFile> attachmentFiles = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "event")
    private List<EventExcept> eventExceptList = new ArrayList<>();

    private String summary;
    private String description;
    private Boolean isDeleted;
    private Long createUserNo;
    private Long updateUserNo;

    @CreationTimestamp
    private LocalDateTime createTimestamp;
    @UpdateTimestamp
    private LocalDateTime updateTimestamp;

    public void setUpdateUserNo(Long updateUserNo) {
        this.updateUserNo = updateUserNo;
    }

    public void setUpdateTimestamp(LocalDateTime updateTimestamp) {
        this.updateTimestamp = updateTimestamp;
    }

    public void setRecurrence(String recurrence) {
        this.recurrence = recurrence;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }
}
