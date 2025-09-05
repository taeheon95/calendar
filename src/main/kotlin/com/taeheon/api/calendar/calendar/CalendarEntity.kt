package com.taeheon.api.calendar.calendar

import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.time.LocalDateTime

@Entity(name = "t_calendar")
class CalendarEntity {
    @Id
    private var id: String? = null
    @Enumerated(EnumType.STRING)
    private var kind: CalendarKind? = null
    private var summary: String? = null
    private var description: String? = null
    private var timezone: String? = null
    private var location: String? = null
    private var isDeleted:Boolean? = false
    private var createdBy : Long? = null
    private var updatedBy: Long? = null
    private var createdAt: LocalDateTime = LocalDateTime.now()
    private var updatedAt: LocalDateTime = LocalDateTime.now()
}