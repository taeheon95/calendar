package com.taeheon.calendar.user.entity;

import com.taeheon.calendar.calendarList.entity.Authority;
import com.taeheon.calendar.calendarList.entity.CalendarList;
import com.taeheon.calendar.calendarList.entity.Role;
import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

@Entity(name = "member")
@Getter
public class User {
    @Id
    @GeneratedValue
    private Long userNo;
    private String userId;
    private String userPassword;

    private Boolean isEnabled;
    private Boolean isDeleted;

    private LocalDateTime lastLogin;

    @CreationTimestamp
    private LocalDateTime createTimestamp;
    private LocalDateTime updateTimestamp;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<CalendarList> calendarList;

    public List<Role> getRole() {
        return calendarList.stream().map(CalendarList::getRole).toList();
    }

    public boolean isAccountNonExpired() {
        return isEnabled();
    }

    public boolean isEnabled() {
        return isEnabled && !isDeleted;
    }

    public void setLastLogin(LocalDateTime lastLogin) {
        this.lastLogin = lastLogin;
    }
}
