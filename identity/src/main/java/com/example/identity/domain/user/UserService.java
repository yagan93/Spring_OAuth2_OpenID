package com.example.identity.domain.user;

import com.example.identity.core.generic.ExtendedService;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService, ExtendedService<User> {
    User register(User user);
}
