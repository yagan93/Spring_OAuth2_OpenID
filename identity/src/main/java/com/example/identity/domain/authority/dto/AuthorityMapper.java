package com.example.identity.domain.authority.dto;

import com.example.identity.core.generic.ExtendedMapper;
import com.example.identity.domain.authority.Authority;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AuthorityMapper extends ExtendedMapper<Authority, AuthorityDTO> {
}

