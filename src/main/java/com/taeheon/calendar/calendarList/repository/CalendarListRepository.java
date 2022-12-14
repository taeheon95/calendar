package com.taeheon.calendar.calendarList.repository;

import com.taeheon.calendar.calendarList.entity.CalendarList;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CalendarListRepository extends JpaRepository<CalendarList, Long> {
}
