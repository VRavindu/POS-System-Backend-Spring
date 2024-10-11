package lk.ijse.gdse.possystembackendspring.controller;

import lk.ijse.gdse.possystembackendspring.dto.CustomerDTO;
import lk.ijse.gdse.possystembackendspring.service.CustomerService;
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
    @PatchMapping(value = "/{custId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> updateCustomer(@PathVariable ("custId") String custId, @RequestBody CustomerDTO customer) {
        try{
            if (customer == null && (custId == null || custId.equals(""))){
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            customerService.updateCustomer(custId, customer);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping(value = "/{custId}")
    public ResponseEntity<String> deleteCustomer(@PathVariable ("custId") String custId) {
        try{
            if (custId == null || custId.equals("")){
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            customerService.deleteCustomer(custId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/{custId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public CustomerDTO getCustomerById(@PathVariable ("custId") String custId) {
        return null;
    }

    @GetMapping(value = "allcustomer", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CustomerDTO> getAllCustomers() {
        return null;
    }



}
