package lk.ijse.gdse.possystembackendspring.service;

import lk.ijse.gdse.possystembackendspring.dto.CustomerDTO;

import java.util.List;

public class CustomerServiceIMPL implements CustomerService {
    @Override
    public String saveCustomer(CustomerDTO customerDTO) {
        return "";
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
