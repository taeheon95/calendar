package com.taeheon.calendar.calendarList.controller;

import com.taeheon.calendar.calendarList.service.CalendarListService;
import com.taeheon.calendar.calendarList.vo.CalendarListVO;
import com.taeheon.calendar.common.dto.ApiSuccessResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("calendarList")
public class CalendarListController {
    private final CalendarListService calendarListService;

    @GetMapping
    public ApiSuccessResponse<List<CalendarListVO>> getCalendarList() {
        return ApiSuccessResponse.ok(null);
    }
}
