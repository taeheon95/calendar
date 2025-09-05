package com.taeheon.api.calendar.calendar

import com.taeheon.api.calendar.common.ApiResponse
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.data.domain.Page
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping

@RequestMapping("/calendars")
@Tag(name = "Calendar api", description = "캘린더 api 입니다.")
interface Controller {
    @GetMapping
    @Operation(summary = "캘린더 리스트 검색")
    fun getCalendarList() : ApiResponse<Page<CalendarDTO>>

    @GetMapping("/{calendarId}")
    fun getCalendar(@PathVariable("calendarId") id : String) : ApiResponse<CalendarDTO>
}