package com.example.springdeeply.slices.organizations.service;

import com.example.springdeeply.slices.organizations.api.dtos.OrganizationDto;
import com.example.springdeeply.slices.organizations.api.exceptions.NotFoundException;
import com.example.springdeeply.slices.organizations.persistence.OrganizationsRepository;
import com.example.springdeeply.slices.organizations.persistence.dao.OrganizationEntity;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.example.springdeeply.common.exceptions.ExceptionMessages.CANT_FIND_ORGANIZATION_WITH_ID;

@Service
@RequiredArgsConstructor
public class OrganizationsService {
    private final OrganizationsRepository repo;
    private final ModelMapper modelMapper;

    public OrganizationDto getOrganization(long id) {
        return Optional.of(id)
                .filter(organizationId -> organizationId >= 0)
                .map(List::of)
                .map(repo::findAllById)
                .filter(organizations -> !organizations.isEmpty())
                .map(organizationEntities -> organizationEntities.get(0))
                .map(this::convertToDto)
                .orElseThrow(() -> new NotFoundException(CANT_FIND_ORGANIZATION_WITH_ID + id));
    }

    public List<OrganizationDto> getAllOrganizations() {
        return repo.findAll().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public OrganizationDto saveOrganization(OrganizationDto organizationDto) {
        return Optional.ofNullable(organizationDto)
                .map(this::convertToEntity)
                .map(repo::save)
                .map(this::convertToDto)
                .orElseThrow(IllegalArgumentException::new);
    }

    private OrganizationEntity convertToEntity(OrganizationDto organizationDto) {
        return modelMapper.map(organizationDto, OrganizationEntity.class);
    }

    private OrganizationDto convertToDto(OrganizationEntity entity) {
        return modelMapper.map(entity, OrganizationDto.class);
    }

}
