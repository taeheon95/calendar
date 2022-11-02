package com.taeheon.calendar.event.repository;

import com.taeheon.calendar.event.dto.EventSearchParams;
import com.taeheon.calendar.event.entity.EventEntity;

import java.text.ParseException;
import java.util.List;

public interface EventCustomRepository {
    List<EventEntity> findEvent(EventSearchParams searchParams) throws ParseException;
}
