package lk.ijse.gdse.possystembackendspring.service;

import jakarta.transaction.Transactional;
import lk.ijse.gdse.possystembackendspring.dto.CustomerDTO;
import lk.ijse.gdse.possystembackendspring.repository.CustomerRepository;
import lk.ijse.gdse.possystembackendspring.util.AppUtil;
import lk.ijse.gdse.possystembackendspring.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class CustomerServiceIMPL implements CustomerService {
    private final CustomerRepository customerRepository;
    private final Mapping mapping;

    @Autowired
    public CustomerServiceIMPL(CustomerRepository customerRepository, Mapping mapping) {
        this.customerRepository = customerRepository;
        this.mapping = mapping;
    }

    @Override
    public String saveCustomer(CustomerDTO customerDTO) {
        customerDTO.setId(AppUtil.CreateCustomerId());
        return null;
    }

    @Override
    public void updateCustomer(String custId, CustomerDTO customerDTO) {

    }

    @Override
    public void deleteCustomer(String custId) {

    }

    @Override
    public CustomerDTO getCustomer(String custId) {
        return null;
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        return List.of();
    }
}
