package lk.ijse.gdse.possystembackendspring.controller;
import lk.ijse.gdse.possystembackendspring.customObj.CustomerResponse;
import lk.ijse.gdse.possystembackendspring.dto.CustomerDTO;
import lk.ijse.gdse.possystembackendspring.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api/v1/customer")
@CrossOrigin("*")
public class CustomerController {
    private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);
    @Autowired
    private CustomerService customerService;
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> createCustomer(@RequestBody CustomerDTO customer) {
        var isSaved = customerService.saveCustomer(customer);
        if (isSaved.contains("Customer Saved Successfully")){
            logger.info("Customer Saved Successfully", customer.getCustId());
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            logger.error("Customer Saved Failed", customer.getCustId());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @PatchMapping(value = "/{custId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> updateCustomer(@PathVariable ("custId") String custId, @RequestBody CustomerDTO customer) {
        try{
            if (customer == null && (custId == null || custId.isEmpty())){
                logger.error("Customer Not Found");
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            customerService.updateCustomer(custId, customer);
            logger.info("Customer Updated Successfully", customer.getCustId());
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (Exception e){
            logger.error("Customer Update Failed", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping(value = "/{custId}")
    public ResponseEntity<String> deleteCustomer(@PathVariable ("custId") String custId) {
        try{
            if (custId == null || custId.isEmpty()){
                logger.error("Customer Not Found");
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            customerService.deleteCustomer(custId);
            logger.info("Customer Deleted Successfully", custId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (Exception e){
            logger.error("Customer Delete Failed", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping(value = "/{custId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public CustomerResponse getCustomerById(@PathVariable ("custId") String custId) {
        if (custId == null || custId.isEmpty()){
            logger.info("Customer Not Found");
        }
        logger.info("Customer Retrieved Successfully", custId);
            return customerService.getCustomer(custId);
    }
    @GetMapping(value = "allcustomer", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CustomerDTO> getAllCustomers() {
        List<CustomerDTO> allCustomers = customerService.getAllCustomers();
        logger.info("All customers Retrieved Successfully", allCustomers.size());
        return allCustomers;
    }



}
