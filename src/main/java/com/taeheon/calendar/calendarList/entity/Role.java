package com.taeheon.calendar.calendarList.entity;

import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class Role {
    @Id
    private String role;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "role_authority",
            joinColumns = @JoinColumn(name = "role"),
            inverseJoinColumns = @JoinColumn(name = "authority")
    )
    private List<Authority> authorities = new ArrayList<>();
}
