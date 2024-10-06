package lk.ijse.gdse.possystembackendspring.controller;

import lk.ijse.gdse.possystembackendspring.dto.CustomerDTO;
import lk.ijse.gdse.possystembackendspring.util.AppUtil;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/customer")
public class CustomerController {
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> createCustomer(@RequestBody CustomerDTO customer) {
        customer.setId(AppUtil.CreateCustomerId());
        System.out.println(customer);
        return ResponseEntity.ok("Customer Saved Successfully");
    }
}
