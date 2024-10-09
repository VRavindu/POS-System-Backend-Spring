package lk.ijse.gdse.possystembackendspring.repository;

import lk.ijse.gdse.possystembackendspring.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<CustomerEntity, String> {
}
