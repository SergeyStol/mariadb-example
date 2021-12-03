package com.example.springdeeply;

import com.example.springdeeply.slices.organizations.persistence.OrganizationsRepository;
import com.example.springdeeply.slices.organizations.persistence.dao.OrganizationEntity;
import com.example.springdeeply.slices.organizations.service.OrganizationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringDeeplyApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringDeeplyApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(OrganizationsRepository repository) {
        return (args) -> {
          repository.save(new OrganizationEntity(1L, "Name1"));
          repository.save(new OrganizationEntity(2L, "Name2"));
          repository.save(new OrganizationEntity(3L, "Name3"));
        };
    }
}
