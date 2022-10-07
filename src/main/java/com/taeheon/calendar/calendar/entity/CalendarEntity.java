package com.taeheon.calendar.calendar.entity;

import com.taeheon.calendar.calendar.dto.CalendarCreateDTO;
import com.taeheon.calendar.calendar.dto.CalendarUpdateDTO;
import com.taeheon.calendar.calendarList.entity.CalendarList;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "calendar")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CalendarEntity {

    @Id
    @GeneratedValue
    private Long calendarNo;
    private String location;
    private String timezone;
    private String subject;
    private String description;
    @Column(nullable = false, columnDefinition = "boolean default false")
    private Boolean isDeleted;
    @Column(updatable = false, nullable = false)
    private Long createUserNo;

    @CreationTimestamp
    private LocalDateTime createTimestamp;
    private Long updateUserNo;

    @UpdateTimestamp
    private LocalDateTime updateTimestamp;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "calendar")
    private List<CalendarList> calendarList = new ArrayList<>();

    private CalendarEntity(Builder builder) {
        this.createUserNo = builder.createUserNo;
        this.updateUserNo = builder.createUserNo;
        this.subject = builder.subject;
        this.location = builder.location;
        this.timezone = builder.timezone;
        this.description = builder.description;
        this.isDeleted = false;
    }

    public CalendarEntity(Long userNo, CalendarCreateDTO createDTO) {
        this.location = createDTO.getLocation();
        this.timezone = createDTO.getTimezone();
        this.subject = createDTO.getSubject();
        this.description = createDTO.getDescription();
        this.isDeleted = false;
        this.createUserNo = userNo;
        this.updateUserNo = userNo;
    }

    public void updateCalendar(Long updateUserNo, CalendarUpdateDTO updateDTO) {
        this.updateUserNo = updateUserNo;
        this.subject = updateDTO.getSubject();
        this.location = updateDTO.getLocation();
        this.timezone = updateDTO.getTimezone();
        this.description = updateDTO.getDescription();
    }

    public void deleteCalendar(Long userNo) {
        this.isDeleted = false;
        this.updateUserNo = userNo;
    }

    public static class Builder {
        private final Long createUserNo;
        private final String subject;
        private String location;
        private String timezone;
        private String description;

        public Builder(Long createUserNo, String subject) {
            this.createUserNo = createUserNo;
            this.subject = subject;
        }

        public Builder location(String location) {
            this.location = location;
            return this;
        }

        public Builder timezone(String timezone) {
            this.timezone = timezone;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public CalendarEntity build() {
            return new CalendarEntity(this);
        }
    }
}