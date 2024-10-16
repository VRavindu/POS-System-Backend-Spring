package lk.ijse.gdse.possystembackendspring.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lk.ijse.gdse.possystembackendspring.customObj.ItemResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ItemDTO implements Serializable, ItemResponse {
    @NotEmpty(message = "Item Code cannot be Empty")
    private String itemCode;
    @NotEmpty(message = "Description cannot be Empty")
    @Size(min = 2, max = 100, message = "Description must be between 2 and 100 Characters")
    private String description;
    @Min(value = 1, message = "Quantity must be at Least 1")
    private int quantity;
    @Min(value = 0, message = "Price must be a Positive Number")
    private double price;
}
