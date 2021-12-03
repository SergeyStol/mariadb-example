package com.example.springdeeply.slices.organizations.api;

import com.example.springdeeply.slices.organizations.api.dtos.OrganizationDto;
import com.example.springdeeply.slices.organizations.service.OrganizationsService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/organizations")
@AllArgsConstructor
public class OrganizationsController {
    private final OrganizationsService service;

    // GET /v1/organizations/:id
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public OrganizationDto getOrganization(@PathVariable long id) {
        return service.getOrganization(id);
    }

    // GET /v1/organizations
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<OrganizationDto> getAllOrganizations() {
        return service.getAllOrganizations();
    }

    // POST /v1/organizations
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OrganizationDto addOrganization(@RequestBody OrganizationDto newOrganizationDto) {
        return service.saveOrganization(newOrganizationDto);
    }
}
