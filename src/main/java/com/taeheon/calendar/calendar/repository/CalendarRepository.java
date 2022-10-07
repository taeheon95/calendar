package com.taeheon.calendar.calendar.repository;

import com.taeheon.calendar.calendar.entity.CalendarEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CalendarRepository extends JpaRepository<CalendarEntity, Long> {
    List<CalendarEntity> findAllByIsDeleted(boolean isDeleted);
}
