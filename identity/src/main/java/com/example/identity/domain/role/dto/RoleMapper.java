package com.example.identity.domain.role.dto;

import com.example.identity.core.generic.ExtendedMapper;
import com.example.identity.domain.role.Role;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RoleMapper extends ExtendedMapper<Role, RoleDTO> {
}
