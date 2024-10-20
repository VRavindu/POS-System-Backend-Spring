package lk.ijse.gdse.possystembackendspring.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "customers")
@Entity
public class CustomerEntity {
    @Id
    private String custId;
    private String custName;
    private String address;
    private double salary;
    @OneToMany(mappedBy = "customer")
    private List<OrderEntity> orders;
}
