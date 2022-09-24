package com.example.identity.domain.role;

import com.example.identity.core.generic.ExtendedService;

public interface RoleService extends ExtendedService<Role> {

    Role findByName(String name);

}
