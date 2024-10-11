package lk.ijse.gdse.possystembackendspring.service;

import jakarta.transaction.Transactional;
import lk.ijse.gdse.possystembackendspring.dto.CustomerDTO;
import lk.ijse.gdse.possystembackendspring.entity.CustomerEntity;
import lk.ijse.gdse.possystembackendspring.repository.CustomerRepository;
import lk.ijse.gdse.possystembackendspring.util.AppUtil;
import lk.ijse.gdse.possystembackendspring.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        CustomerEntity saveCust = customerRepository.save(mapping.convertToEntity(customerDTO));
        if (saveCust != null && saveCust.getId() != null) {
            return "Customer Saved Successfully";
        }else {
            return "Customer Save Failed";
        }
    }
    @Override
    public void updateCustomer(String custId, CustomerDTO customerDTO) {
        Optional<CustomerEntity> tmpCustEntity = customerRepository.findById(custId);
        if (!tmpCustEntity.isPresent()) {
            throw new RuntimeException("Customer Not Found");
        }else {
            tmpCustEntity.get().setName(customerDTO.getName());
            tmpCustEntity.get().setAddress(customerDTO.getAddress());
            tmpCustEntity.get().setSalary(customerDTO.getSalary());
        }
    }
    @Override
    public void deleteCustomer(String custId) {
        Optional<CustomerEntity> findId = customerRepository.findById(custId);
        if (!findId.isPresent()){
            throw new RuntimeException("Customer Not Found");
        }else {
            customerRepository.deleteById(custId);
        }
    }
    @Override
    public CustomerDTO getCustomer(String custId) {
        if (customerRepository.existsById(custId)){
            return mapping.convertToDto(customerRepository.getReferenceById(custId));
        }else {
            throw new RuntimeException("Customer Not Found");
        }
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        return List.of();
    }
}
