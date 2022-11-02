package com.taeheon.calendar.event.repository;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.DateTimeExpression;
import com.querydsl.core.types.dsl.StringPath;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.taeheon.calendar.event.dto.EventSearchParams;
import com.taeheon.calendar.event.entity.EventEntity;
import com.taeheon.calendar.event.entity.QEventEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.util.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static com.taeheon.calendar.event.entity.QEventEntity.eventEntity;

@RequiredArgsConstructor
public class EventCustomRepositoryImpl implements EventCustomRepository {

    QEventEntity event = eventEntity;

    private final JPAQueryFactory queryFactory;

    @Override
    public List<EventEntity> findEvent(EventSearchParams searchParams) throws ParseException {
        queryFactory.select()
                .from(event)
                .where(
                        searchSummary(searchParams.getSummary()),
                        searchStartDate(searchParams.getStartDate())
                        )
                .limit(searchParams.getMaxResults())
                .fetch();
        return null;
    }

    private BooleanExpression searchSummary(String summary) {
        if(!StringUtils.hasText(summary)) {
            return null;
        }
        return event.summary.like(summary);
    }

    private BooleanExpression searchStartDate(Date startDate) throws ParseException {
        if(startDate == null){
            return null;
        }
        return null;
//        return event.start.date.goe(date)
//                .or(event.start.datetime.goe(date));
    }

    private BooleanExpression searchEndDate(String endDate) throws ParseException {
        if(!StringUtils.hasText(endDate)) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf.parse(endDate);
        return null;
//        return event.end.date.goe(date);
    }
}
