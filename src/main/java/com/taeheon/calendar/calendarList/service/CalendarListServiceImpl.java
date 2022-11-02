package com.taeheon.calendar.calendarList.service;

import com.taeheon.calendar.calendarList.entity.CalendarList;
import com.taeheon.calendar.calendarList.vo.CalendarListVO;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class CalendarListServiceImpl implements CalendarListService{

    @Override
    public List<CalendarListVO> getCalendarListByUserNo(Long userNo) {
        List<CalendarList> calendarLists;

        return null;
    }

    @Override
    public CalendarListVO getCalendarList(Long userNo, Long calendarNo) {
        return null;
    }
}
