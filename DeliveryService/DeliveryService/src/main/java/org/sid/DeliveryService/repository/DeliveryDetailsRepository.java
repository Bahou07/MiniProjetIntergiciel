package org.sid.DeliveryService.repository;

import org.sid.DeliveryService.model.Bill;
import org.sid.DeliveryService.model.DelieveryDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource
public interface DeliveryDetailsRepository extends JpaRepository<DelieveryDetails, Long> {
}