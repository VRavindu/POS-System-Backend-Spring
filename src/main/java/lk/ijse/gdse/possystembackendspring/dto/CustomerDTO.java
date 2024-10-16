package lk.ijse.gdse.possystembackendspring.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lk.ijse.gdse.possystembackendspring.customObj.CustomerResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerDTO implements Serializable, CustomerResponse {
    @NotEmpty(message = "Customer ID cannot be Empty")
    private String custId;
    @NotEmpty(message = "Customer Name cannot be Empty")
    @Size(min = 2, max = 50, message = "Customer name must be between 2 and 50 characters")
    private String custName;
    @NotEmpty(message = "Address cannot be Empty")
    private String address;
    @Min(value = 0, message = "Salary must be a Positive Number")
    private double salary;
}
