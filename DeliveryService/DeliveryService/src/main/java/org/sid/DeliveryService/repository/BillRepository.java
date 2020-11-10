package org.sid.DeliveryService.repository;

import org.sid.DeliveryService.model.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;



@Repository
@RepositoryRestResource
public interface BillRepository extends JpaRepository<Bill, Long> {


}
