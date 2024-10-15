package lk.ijse.gdse.possystembackendspring.service;

import lk.ijse.gdse.possystembackendspring.dto.OrderDTO;

public interface OrderService {
    void saveOrder(OrderDTO orderDTO) throws Exception;
}
