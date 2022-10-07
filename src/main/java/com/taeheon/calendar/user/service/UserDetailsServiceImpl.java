package com.taeheon.calendar.user.service;

import com.taeheon.calendar.calendarList.entity.Role;
import com.taeheon.calendar.user.entity.User;
import com.taeheon.calendar.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository
                .findByUserId(username)
                .orElseThrow(() -> new UsernameNotFoundException("UserId : " + username + " not found"));

        return new org.springframework.security.core.userdetails.
                User(user.getUserId(), user.getUserPassword(), getAuthorities(user));
    }

    private Collection<? extends GrantedAuthority> getAuthorities(User user) {
        String[] roles = user.getRole().stream().map(Role::getRole).toArray(String[]::new);
        return AuthorityUtils.createAuthorityList(roles);
    }
}
