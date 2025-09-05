package com.taeheon.api.calendar.calendar

import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.Id
import jakarta.persistence.OneToMany
import java.time.LocalDateTime

@Entity(name = "t_calendar_member")
class CalendarMemberEntity {
    @Id
    private var id: String? = null
    private var calendarId: String? = null
    private var userNo: Long? = null
    private var memberSummary: String? = null
    private var role: CalendarMemberRole? = null
    private var viewed: Boolean? = null
    @OneToMany(mappedBy = "calendarMember")
    private var reminderList: MutableList<CalendarReminder> = mutableListOf()
    private var notificationSetting: MutableList<Unit> = mutableListOf()
    private var isDeleted:Boolean? = false
    private var createdBy : Long? = null
    private var updatedBy: Long? = null
    private var createdAt: LocalDateTime = LocalDateTime.now()
    private var updatedAt: LocalDateTime = LocalDateTime.now()
}