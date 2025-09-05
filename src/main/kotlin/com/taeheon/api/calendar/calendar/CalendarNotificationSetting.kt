package com.taeheon.api.calendar.calendar

import jakarta.persistence.Entity
import jakarta.persistence.Id

@Entity(name = "t_calendar_member_notification_setting")
class CalendarNotificationSetting {
    @Id
    private var id: Long = 0
}