package com.taeheon.calendar.calendarList.entity;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class Authority {
    @Id
    private String authority;
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "authorities")
    private List<Role> role = new ArrayList<>();
}
