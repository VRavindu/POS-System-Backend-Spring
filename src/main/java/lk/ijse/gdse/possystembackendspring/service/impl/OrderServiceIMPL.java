package lk.ijse.gdse.possystembackendspring.service.impl;

import lk.ijse.gdse.possystembackendspring.dto.OrderDTO;
import lk.ijse.gdse.possystembackendspring.entity.OrderEntity;
import lk.ijse.gdse.possystembackendspring.exception.DataPersistFailedException;
import lk.ijse.gdse.possystembackendspring.repository.OrderRepository;
import lk.ijse.gdse.possystembackendspring.service.OrderService;
import lk.ijse.gdse.possystembackendspring.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class OrderServiceIMPL implements OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private Mapping mapping;
    @Override
    public String saveOrder(OrderDTO orderDTO) {
            OrderEntity orderEntity = mapping.convertToOrderEntity(orderDTO);
        OrderEntity saveOrder = orderRepository.save(orderEntity);
        if (saveOrder != null) {
            return "Order Saved Successfully";
        }else {
            throw new DataPersistFailedException("Order Saving Failed");
        }
    }
}
