package lk.ijse.gdse.possystembackendspring.controller;

import lk.ijse.gdse.possystembackendspring.dto.CustomerDTO;
import lk.ijse.gdse.possystembackendspring.service.CustomerService;
import lk.ijse.gdse.possystembackendspring.util.AppUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> createCustomer(@RequestBody CustomerDTO customer) {
        var isSaved = customerService.saveCustomer(customer);
        if (isSaved.contains("Customer Saved Successfully")){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping(value = "allcustomer", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CustomerDTO> getAllCustomers() {
        return null;
    }
    @GetMapping(value = "/{custId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public CustomerDTO getCustomerById(@PathVariable ("custId") String custId) {
        return null;
    }
    @PatchMapping(value = "/{custId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void updateCustomer(@PathVariable ("custId") String custId, @RequestBody CustomerDTO customer) {
        System.out.println(custId);
        System.out.println(customer + "Updated Successfully");
    }
    @DeleteMapping(value = "/{custId}")
    public void deleteCustomer(@PathVariable ("custId") String custId) {
        System.out.println(custId + "Deleted Successfully");
    }
}
