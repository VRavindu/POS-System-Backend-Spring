package lk.ijse.gdse.possystembackendspring.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderDTO {
    private String orderId;
    private LocalDate date;
    private double total;
    private double discount;
    private String customerId;
}
