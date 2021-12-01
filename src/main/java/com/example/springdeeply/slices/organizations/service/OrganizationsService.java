package com.example.springdeeply.slices.organizations.service;

import com.example.springdeeply.slices.organizations.api.dtos.OrganizationDto;
import com.example.springdeeply.slices.organizations.persistence.OrganizationsRepository;
import com.example.springdeeply.slices.organizations.persistence.dao.OrganizationEntity;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrganizationsService {
    private final OrganizationsRepository repo;
    private final ModelMapper modelMapper;

    public OrganizationDto getOrganization(long id) {
        return convertToDto(repo.getById(id));
    }

    public OrganizationDto saveOrganization(OrganizationDto organizationDto) {
        return Optional.of(organizationDto)
                .map(this::convertToEntity)
                .map(repo::save)
                .map(this::convertToDto)
                .orElseThrow();
    }

    private OrganizationEntity convertToEntity(OrganizationDto organizationDto) {
        return modelMapper.map(organizationDto, OrganizationEntity.class);
    }

    private OrganizationDto convertToDto(OrganizationEntity entity) {
        return modelMapper.map(entity, OrganizationDto.class);
    }
}
