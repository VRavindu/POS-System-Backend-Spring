package lk.ijse.gdse.possystembackendspring.controller;

import lk.ijse.gdse.possystembackendspring.dto.CustomerDTO;
import lk.ijse.gdse.possystembackendspring.util.AppUtil;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/customer")
public class CustomerController {
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> createCustomer(@RequestBody CustomerDTO customer) {
        customer.setId(AppUtil.CreateCustomerId());
        System.out.println(customer);
        return ResponseEntity.ok("Customer Saved Successfully");
    }
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CustomerDTO> getAllCustomers() {
        return null;
    }
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public CustomerDTO getCustomerById(@PathVariable ("custId") String custId) {
        return null;
    }
    @PatchMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public void updateCustomer(@PathVariable ("custId") String custId, @RequestBody CustomerDTO customer) {
        System.out.println(custId);
        System.out.println(customer + "Updated Successfully");
    }
    @DeleteMapping
    public void deleteCustomer(@PathVariable ("custId") String custId) {
        System.out.println(custId + "Deleted Successfully");
    }
}
