package lk.ijse.gdse.possystembackendspring.service;

import lk.ijse.gdse.possystembackendspring.dto.OrderDTO;
import lk.ijse.gdse.possystembackendspring.entity.OrderEntity;
import lk.ijse.gdse.possystembackendspring.repository.CustomerRepository;
import lk.ijse.gdse.possystembackendspring.repository.ItemRepository;
import lk.ijse.gdse.possystembackendspring.repository.OrderRepository;
import lk.ijse.gdse.possystembackendspring.service.OrderService;
import lk.ijse.gdse.possystembackendspring.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderServiceIMPL implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private Mapping mapping; // Inject your Mapping class to handle conversion

    @Transactional
    public void saveOrder(OrderDTO orderDTO) throws Exception {
        try {
            // Log the incoming order DTO for debugging
            System.out.println("Saving order: " + orderDTO);

            // Use the Mapping class to convert DTO to Entity
            OrderEntity orderEntity = mapping.convertToOrderEntity(orderDTO);

            // Save the order entity
            orderRepository.save(orderEntity);

            // Log success
            System.out.println("Order successfully saved with ID: " + orderEntity.getOrderId());
        } catch (Exception e) {
            // Log error details
            System.err.println("Error saving order: " + e.getMessage());
            e.printStackTrace();
            throw e; // Rethrow the exception for the controller to handle
        }
    }
}
