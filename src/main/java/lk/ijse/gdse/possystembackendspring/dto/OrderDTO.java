package lk.ijse.gdse.possystembackendspring.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderDTO {
    private String orderId;
    private String date;
    private double total;
    private double discount;
    private int quantity;
    private CustomerDTO customer;
    private List<ItemDTO> items;
}
