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
@Table(name = "customers")
@Entity
public class CustomerEntity {
    @Id
    private String id;
    private String name;
    private String address;
    private double salary;
}
