package lk.ijse.gdse.possystembackendspring.service;

import lk.ijse.gdse.possystembackendspring.dto.CustomerDTO;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface CustomerService {
    String saveCustomer(CustomerDTO customerDTO);
    void updateCustomer(String custId ,CustomerDTO customerDTO);
    void deleteCustomer(String custId);
    CustomerDTO getCustomer(String custId);
    List<CustomerDTO> getAllCustomers();
}
