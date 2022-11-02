package com.taeheon.calendar.calendar.service.impl;

import com.taeheon.calendar.calendar.dto.CalendarCreateDTO;
import com.taeheon.calendar.calendar.dto.CalendarDTO;
import com.taeheon.calendar.calendar.dto.CalendarUpdateDTO;
import com.taeheon.calendar.calendar.entity.CalendarEntity;
import com.taeheon.calendar.calendar.repository.CalendarRepository;
import com.taeheon.calendar.calendar.service.CalendarService;
import com.taeheon.calendar.calendarList.entity.CalendarList;
import com.taeheon.calendar.calendarList.entity.Role;
import com.taeheon.calendar.calendarList.repository.CalendarListRepository;
import com.taeheon.calendar.calendarList.repository.RoleRepository;
import com.taeheon.calendar.user.entity.User;
import com.taeheon.calendar.user.repository.UserRepository;
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
    private final CalendarListRepository calendarListRepository;
    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    private final EntityManager entityManager;

    @Transactional(readOnly = true)
    public List<CalendarDTO> getAllCalendar() {
        List<CalendarEntity> calendarEntityList = calendarRepository.findAllByIsDeleted(false);
        return calendarEntityList
                .stream()
                .map(CalendarDTO::new)
                .toList();
    }

    @Transactional(readOnly = true)
    public CalendarDTO getCalendar(Long calendarNo) {
        CalendarEntity calendarEntity = calendarRepository
                .findById(calendarNo)
                .orElseThrow(() -> {
                    throw new NoSuchElementException("no calendar entity");
                });
        return new CalendarDTO(calendarEntity);
    }

    public CalendarDTO postCalendar(CalendarCreateDTO createDTO) {
        CalendarEntity calendarEntity = new CalendarEntity(1L, createDTO);
        List<CalendarList> calendarLists = calendarEntity.getCalendarList();

        Role role = roleRepository.findById("owner").orElseThrow(() -> {
            throw new NoSuchElementException("no role found");
        });
        User user = userRepository.findById(0L).orElseThrow(() -> {
            throw new NoSuchElementException("no user found");
        });

        CalendarList calendarList = new CalendarList(user, calendarEntity, role);
        calendarLists.add(calendarList);

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
