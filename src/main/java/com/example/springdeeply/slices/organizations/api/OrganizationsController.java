package com.example.springdeeply.slices.organizations.api;

import com.example.springdeeply.slices.organizations.api.dtos.OrganizationDto;
import com.example.springdeeply.slices.organizations.service.OrganizationsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/organizations")
@AllArgsConstructor
public class OrganizationsController {
    private final OrganizationsService service;

    // GET /v1/organizations/:id
    @GetMapping("/{id}")
    public OrganizationDto getOrganization(@PathVariable long id) {
        return service.getOrganization(id);
    }
}
