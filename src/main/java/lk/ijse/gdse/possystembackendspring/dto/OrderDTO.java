package lk.ijse.gdse.possystembackendspring.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lk.ijse.gdse.possystembackendspring.customObj.OrderResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderDTO implements Serializable, OrderResponse {
    @NotEmpty(message = "Order ID cannot be Empty")
    private String orderId;
    @NotEmpty(message = "Date cannot be Empty")
    private String date;
    @Min(value = 0, message = "Total must be a Positive Number or Zero")
    private double total;
    @Min(value = 0, message = "Discount must be a Positive Number or Zero")
    private double discount;
    @Min(value = 1, message = "Quantity must be at Least 1")
    private int quantity;
    @NotNull(message = "Customer cannot be Null")
    @Valid // Ensure that the nested CustomerDTO object is also validated
    private CustomerDTO customer;
    @NotEmpty(message = "Order must contain at Least one Item")
    @Valid // Ensure that each ItemDTO object in the list is validated
    private List<ItemDTO> items;
}
