package com.taeheon.api.calendar.setting

import jakarta.persistence.Entity
import jakarta.persistence.Id

@Entity(name = "t_setting")
class SettingEntity {
    @Id
    private var id: String = ""
    private var userNo: Long? = null
    private var dateFormat: String? = null
    private var locale: String? = null
    private var timezone: String? = null
    private var weekStart: String? = null
}