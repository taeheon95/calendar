package com.taeheon.calendar.calendarList.repository;

import com.taeheon.calendar.calendarList.entity.CalendarList;

import java.util.List;

public interface CalendarListCustomRepository {
    List<CalendarList> findCalendar(Long userNo, String subjectOverride);

    List<CalendarList> findCalendarByUserNo(Long userNo);
}
