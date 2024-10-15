package lk.ijse.gdse.possystembackendspring.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "order_details")
public class OrderDetailEntity {
    @Id
    private String orderDetailId;
    @ManyToOne
    @JoinColumn(name = "order_id", referencedColumnName = "orderId")
    private OrderEntity order;
    @ManyToOne
    @JoinColumn(name = "item_code", referencedColumnName = "itemCode")
    private ItemEntity item;
    private int quantity;
    private double price;
}
