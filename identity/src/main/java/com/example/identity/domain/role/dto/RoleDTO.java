package com.example.identity.domain.role.dto;

import com.example.identity.core.generic.ExtendedDTO;
import com.example.identity.domain.authority.dto.AuthorityDTO;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;
import java.util.UUID;

public class RoleDTO extends ExtendedDTO {

    @NotNull
    @Size(min = 1, max = 255)
    private String name;

    @Valid
    private Set<AuthorityDTO> authorities;

    public RoleDTO() {
    }

    public RoleDTO(UUID id, String name, Set<AuthorityDTO> authorities) {
        super(id);
        this.name = name;
        this.authorities = authorities;
    }

    public String getName() {
        return name;
    }

    public RoleDTO setName(String name) {
        this.name = name;
        return this;
    }

    public Set<AuthorityDTO> getAuthorities() {
        return authorities;
    }

    public RoleDTO setAuthorities(Set<AuthorityDTO> authorities) {
        this.authorities = authorities;
        return this;
    }
}