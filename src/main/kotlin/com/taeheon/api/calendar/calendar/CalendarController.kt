package com.taeheon.api.calendar.calendar

import com.taeheon.api.calendar.common.ApiResponse
import org.springframework.data.domain.Page
import org.springframework.web.bind.annotation.RestController

@RestController
class CalendarController : Controller {
    override fun getCalendarList(): ApiResponse<Page<CalendarDTO>> {
        TODO("Not yet implemented")
    }

    override fun getCalendar(id: String): ApiResponse<CalendarDTO> {
        TODO("Not yet implemented")
    }
}