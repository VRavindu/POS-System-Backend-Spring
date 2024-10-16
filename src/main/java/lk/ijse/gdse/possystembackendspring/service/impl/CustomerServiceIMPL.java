package lk.ijse.gdse.possystembackendspring.service.impl;
import jakarta.transaction.Transactional;
import lk.ijse.gdse.possystembackendspring.customObj.CustomerResponse;
import lk.ijse.gdse.possystembackendspring.customObj.impl.CustomerErrorResponse;
import lk.ijse.gdse.possystembackendspring.dto.CustomerDTO;
import lk.ijse.gdse.possystembackendspring.entity.CustomerEntity;
import lk.ijse.gdse.possystembackendspring.exception.CustomerNotFoundException;
import lk.ijse.gdse.possystembackendspring.repository.CustomerRepository;
import lk.ijse.gdse.possystembackendspring.service.CustomerService;
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
        customerDTO.setCustId(AppUtil.CreateCustomerId());
        CustomerEntity saveCust = customerRepository.save(mapping.convertToEntity(customerDTO));
        if (saveCust.getCustId() != null) {
            return "Customer Saved Successfully";
        }else {
            return "Customer Save Failed";
        }
    }
    @Override
    public void updateCustomer(String custId, CustomerDTO customerDTO) {
        Optional<CustomerEntity> tmpCustEntity = customerRepository.findById(custId);
        if (tmpCustEntity.isEmpty()) {
            throw new CustomerNotFoundException("Customer Not Found");
        }else {
            tmpCustEntity.get().setCustName(customerDTO.getCustName());
            tmpCustEntity.get().setAddress(customerDTO.getAddress());
            tmpCustEntity.get().setSalary(customerDTO.getSalary());
        }
    }
    @Override
    public void deleteCustomer(String custId) {
        Optional<CustomerEntity> findId = customerRepository.findById(custId);
        if (findId.isEmpty()){
            throw new CustomerNotFoundException("Customer Not Found");
        }else {
            customerRepository.deleteById(custId);
        }
    }
    @Override
    public CustomerResponse getCustomer(String custId) {
        if (customerRepository.existsById(custId)){
            return mapping.convertToDto(customerRepository.getReferenceById(custId));
        }else {
            return new CustomerErrorResponse(0, "Customer Not Found");
        }
    }
    @Override
    public List<CustomerDTO> getAllCustomers() {
        return mapping.convertToDtoList(customerRepository.findAll());
    }
}
