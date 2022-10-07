package com.taeheon.calendar.calendar.service.impl;

import com.taeheon.calendar.calendar.dto.CalendarCreateDTO;
import com.taeheon.calendar.calendar.dto.CalendarDTO;
import com.taeheon.calendar.calendar.dto.CalendarUpdateDTO;
import com.taeheon.calendar.calendar.entity.CalendarEntity;
import com.taeheon.calendar.calendar.repository.CalendarRepository;
import com.taeheon.calendar.calendar.service.CalendarService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
@Transactional
public class CalendarServiceImpl implements CalendarService {

    private final CalendarRepository calendarRepository;
    private final EntityManager entityManager;

    @Transactional(readOnly = true)
    public List<CalendarDTO> getAllCalendar() {
        List<CalendarEntity> calendarEntityList = calendarRepository.findAllByIsDeleted(false);
        return calendarEntityList.stream().map(CalendarDTO::new).toList();
    }

    @Transactional(readOnly = true)
    public CalendarDTO getCalendar(Long calendarNo) {
        CalendarEntity calendarEntity = calendarRepository.findById(calendarNo).orElseThrow(() -> {
            throw new NoSuchElementException("no calendar entity");
        });
        return new CalendarDTO(calendarEntity);
    }

    public CalendarDTO postCalendar(CalendarCreateDTO createDTO) {
        CalendarEntity calendarEntity = new CalendarEntity(1L, createDTO);
        entityManager.persist(calendarEntity);
        entityManager.flush();
        return new CalendarDTO(calendarEntity);
    }

    public CalendarDTO updateCalendar(Long calendarNo, CalendarUpdateDTO updateDTO) {
        CalendarEntity calendarEntity = calendarRepository.findById(calendarNo).orElseThrow(() -> {
            throw new NoSuchElementException("no calendar entity");
        });
        calendarEntity.updateCalendar(1L, updateDTO);
        entityManager.persist(calendarEntity);
        entityManager.flush();
        return new CalendarDTO(calendarEntity);
    }

    public Long deleteCalendar(Long calendarNo) {
        CalendarEntity calendarEntity = calendarRepository.findById(calendarNo).orElseThrow(() -> {
            throw new NoSuchElementException("no calendar entity");
        });
        calendarEntity.deleteCalendar(1L);
        return calendarEntity.getCalendarNo();
    }
}
