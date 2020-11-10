package org.sid.customerservice.repository;


import org.sid.customerservice.entry.CustomerEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@EnableJpaRepositories
@RepositoryRestResource
public interface CustomerEntryRepository extends JpaRepository<CustomerEntry, Long> {
}
