package com.example.springdeeply;

import com.example.springdeeply.slices.organizations.api.dtos.OrganizationDto;
import com.example.springdeeply.slices.organizations.service.OrganizationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringDeeplyApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SpringDeeplyApplication.class, args);
    }

    @Autowired
    OrganizationsService service;
    
    @Override
    public void run(String... args) throws Exception {
        service.saveOrganization(OrganizationDto.builder()
                .id(2)
                .name("Name2")
                .build());
    }
}
