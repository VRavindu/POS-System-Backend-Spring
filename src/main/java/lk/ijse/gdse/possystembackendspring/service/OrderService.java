package lk.ijse.gdse.possystembackendspring.service;

import lk.ijse.gdse.possystembackendspring.dto.OrderDTO;

public interface OrderService {
    String saveOrder(OrderDTO orderDTO);
}
