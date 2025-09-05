package com.taeheon.api.calendar.calendar

import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne

@Entity(name = "t_calendar_reminder")
class CalendarReminder {
    @Id
    private var id:String? = null
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id", nullable = false)
    private var calendarMember: CalendarMemberEntity? = null
}