package com.taeheon.calendar.calendar.controller;

import com.taeheon.calendar.calendar.dto.CalendarCreateDTO;
import com.taeheon.calendar.calendar.dto.CalendarDTO;
import com.taeheon.calendar.calendar.dto.CalendarUpdateDTO;
import com.taeheon.calendar.calendar.service.CalendarService;
import com.taeheon.calendar.common.dto.ApiSuccessResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/calendar")
public class CalendarController {
    private final CalendarService calendarService;

    @GetMapping
    public ApiSuccessResponse<List<CalendarDTO>> getCalendarList() {
        List<CalendarDTO> calendarDTOList = calendarService.getAllCalendar();
        return ApiSuccessResponse.ok(calendarDTOList);
    }

    @GetMapping("/{calendarNo}")
    public ApiSuccessResponse<CalendarDTO> getCalendar(@PathVariable Long calendarNo) {
        CalendarDTO calendarDTO = calendarService.getCalendar(calendarNo);
        return ApiSuccessResponse.ok(calendarDTO);
    }

    @PostMapping
    public ApiSuccessResponse<CalendarDTO> postCalendar(@RequestBody CalendarCreateDTO createDTO) {
        CalendarDTO calendarDTO = calendarService.postCalendar(createDTO);
        return ApiSuccessResponse.created(calendarDTO);
    }

    @PutMapping("/{calendarNo}")
    public ApiSuccessResponse<CalendarDTO> updateCalendar(@PathVariable Long calendarNo, @RequestBody CalendarUpdateDTO updateDTO) {
        CalendarDTO calendarDTO = calendarService.updateCalendar(calendarNo, updateDTO);
        return ApiSuccessResponse.ok(calendarDTO);
    }

    @DeleteMapping("/{calendarNo}")
    public ApiSuccessResponse<?> deleteCalendar(@PathVariable Long calendarNo) {
        Long deletedCalendarNo = calendarService.deleteCalendar(calendarNo);
        return ApiSuccessResponse.noContent();
    }
}
