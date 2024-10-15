package lk.ijse.gdse.possystembackendspring.repository;

import lk.ijse.gdse.possystembackendspring.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderEntity, String> {
}
