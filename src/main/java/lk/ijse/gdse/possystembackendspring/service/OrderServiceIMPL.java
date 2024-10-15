package lk.ijse.gdse.possystembackendspring.service;

import jakarta.transaction.Transactional;
import lk.ijse.gdse.possystembackendspring.dto.OrderDTO;
import lk.ijse.gdse.possystembackendspring.dto.OrderDetailDTO;
import lk.ijse.gdse.possystembackendspring.entity.ItemEntity;
import lk.ijse.gdse.possystembackendspring.entity.OrderDetailEntity;
import lk.ijse.gdse.possystembackendspring.entity.OrderEntity;
import lk.ijse.gdse.possystembackendspring.repository.ItemRepository;
import lk.ijse.gdse.possystembackendspring.repository.OrderRepository;
import lk.ijse.gdse.possystembackendspring.util.Mapping;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class OrderServiceIMPL implements OrderService{
    @Autowired
    private OrderRepository orderRepository ;
    @Autowired
    private  ItemRepository itemRepository ;
    @Autowired
    private final Mapping mapping;
    @Override
    public String saveOrder(OrderDTO orderDTO) {
        orderDTO.setOrderId(generateOrderID());
        orderDTO.setDate(LocalDate.now());
        orderDTO.setTotal(orderDTO.getOrderDetails().stream().mapToDouble(detail -> detail.getQuantity() * detail.getPrice()).sum());
        OrderEntity orderEntity = mapping.convertToOrderEntity(orderDTO);

        List<OrderDetailEntity> orderDetailEntities = orderDTO.getOrderDetails().stream().map(detail -> {
                    OrderDetailEntity orderDetailEntity = mapping.convertToOrderDetailEntity(detail);
                    orderDetailEntity.setOrder(orderEntity);
                    return orderDetailEntity;
                })
                .collect(Collectors.toList());
        orderEntity.setOrderDetails(orderDetailEntities);
        boolean allItemsUpdated = orderDTO.getOrderDetails().stream().allMatch(this::updateItemQty);
        if (allItemsUpdated) {
            orderRepository.save(orderEntity);
            return "Order placed successfully";
        } else {
            throw new RuntimeException("place order failed");
        }
    }
    private String generateOrderID() {
        if (orderRepository.count() == 0) {
            return "O001";
        } else {
            String lastId = orderRepository.findAll().get(orderRepository.findAll().size() - 1).getOrderId();
            int newId = Integer.parseInt(lastId.substring(1)) + 1;
            if (newId < 10) {
                return "O00" + newId;
            } else if (newId < 100) {
                return "O0" + newId;
            } else {
                return "O" + newId;
            }
        }
    }
    private boolean updateItemQty(OrderDetailDTO orderDetailDTO) {
        ItemEntity item = itemRepository.findById(orderDetailDTO.getItemCode()).orElse(null);
        if (item == null) {
            throw new RuntimeException("Item not found");
        }

        if (item.getQuantity() < orderDetailDTO.getQuantity()) {
            throw new RuntimeException("Item qty not enough");
        }

        item.setQuantity(item.getQuantity() - orderDetailDTO.getQuantity());
        itemRepository.save(item);
        return true;
    }
}
