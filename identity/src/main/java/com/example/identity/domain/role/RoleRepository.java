package com.example.identity.domain.role;

import com.example.identity.core.generic.ExtendedRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends ExtendedRepository<Role> {
    Optional<Role> findByName(String name);
}
