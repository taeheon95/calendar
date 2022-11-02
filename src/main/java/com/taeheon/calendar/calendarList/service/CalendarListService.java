package com.taeheon.calendar.calendarList.service;

import com.taeheon.calendar.calendarList.vo.CalendarListVO;

import java.util.List;

public interface CalendarListService {
    List<CalendarListVO> getCalendarListByUserNo(Long userNo);

    CalendarListVO getCalendarList(Long userNo, Long calendarNo);

}
