package lk.ijse.gdse.possystembackendspring.repository;

import lk.ijse.gdse.possystembackendspring.entity.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<ItemEntity, String> {
}
