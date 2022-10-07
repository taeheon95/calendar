package com.taeheon.calendar.calendar.service;

import com.taeheon.calendar.calendar.dto.CalendarCreateDTO;
import com.taeheon.calendar.calendar.dto.CalendarDTO;
import com.taeheon.calendar.calendar.dto.CalendarUpdateDTO;

import java.util.List;

public interface CalendarService {
    List<CalendarDTO> getAllCalendar();

    CalendarDTO getCalendar(Long calendarNo);

    CalendarDTO postCalendar(CalendarCreateDTO createDTO);

    CalendarDTO updateCalendar(Long calendarNo, CalendarUpdateDTO updateDTO);

    Long deleteCalendar(Long calendarNo);
}
