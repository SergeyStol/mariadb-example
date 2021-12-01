package com.example.springdeeply.slices.organizations.persistence;

import com.example.springdeeply.slices.organizations.persistence.dao.OrganizationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganizationsRepository extends JpaRepository<OrganizationEntity, Long> {
}
