package lk.ijse.gdse.possystembackendspring.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "items")
@Entity
public class ItemEntity {
    @Id
    private String itemCode;
    private String description;
    private int quantity;
    private double price;
}
