package com.taeheon.calendar.calendarList.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.taeheon.calendar.calendarList.entity.CalendarList;
import com.taeheon.calendar.calendarList.entity.QCalendarList;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class CalendarListRepositoryImpl implements CalendarListCustomRepository {

    private final JPAQueryFactory queryFactory;
    QCalendarList calendarList = QCalendarList.calendarList;

    @Override
    public List<CalendarList> findCalendar(Long userNo, String subjectOverride) {
        return queryFactory.selectFrom(calendarList)
                .where(
                        calendarList.subjectOverride.like(subjectOverride),
                        calendarList.user.userNo.eq(userNo),
                        calendarList.isDeleted.eq(false)
                )
                .fetch();
    }

    @Override
    public List<CalendarList> findCalendarByUserNo(Long userNo) {
        return queryFactory.selectFrom(calendarList)
                .where(
                        calendarList.user.userNo.eq(userNo),
                        calendarList.isDeleted.eq(false)
                ).fetch();
    }
}
