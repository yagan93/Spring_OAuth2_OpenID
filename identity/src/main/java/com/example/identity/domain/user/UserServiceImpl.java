package com.example.identity.domain.user;

import com.example.identity.core.generic.ExtendedRepository;
import com.example.identity.core.generic.ExtendedServiceImpl;
import com.example.identity.domain.role.RoleService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
public class UserServiceImpl extends ExtendedServiceImpl<User> implements UserService {

    private final RoleService roleService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserServiceImpl(ExtendedRepository<User> repository, Logger logger, RoleService roleService, BCryptPasswordEncoder bCryptPasswordEncoder) {
        super(repository, logger);
        this.roleService = roleService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return ((UserRepository) repository).findByEmail(email).map(UserDetailsImpl::new).orElseThrow(() -> new UsernameNotFoundException(email));
    }

    @Override
    @Transactional
    public User register(User user) {
        user.setRoles(Set.of(roleService.findByName("INITIAL_ROLE")));
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return save(user);
    }
}
