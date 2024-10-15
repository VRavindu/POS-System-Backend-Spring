package lk.ijse.gdse.possystembackendspring.util;

import lk.ijse.gdse.possystembackendspring.dto.CustomerDTO;
import lk.ijse.gdse.possystembackendspring.dto.ItemDTO;
import lk.ijse.gdse.possystembackendspring.dto.OrderDTO;
import lk.ijse.gdse.possystembackendspring.dto.OrderDetailDTO;
import lk.ijse.gdse.possystembackendspring.entity.CustomerEntity;
import lk.ijse.gdse.possystembackendspring.entity.ItemEntity;
import lk.ijse.gdse.possystembackendspring.entity.OrderDetailEntity;
import lk.ijse.gdse.possystembackendspring.entity.OrderEntity;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class Mapping {
    @Autowired
    private ModelMapper modelMapper;
    //Customer Mapping
    public CustomerDTO convertToDto(CustomerEntity customerEntity) {
        return modelMapper.map(customerEntity, CustomerDTO.class);
    }
    public CustomerEntity convertToEntity(CustomerDTO customerDTO) {
        return modelMapper.map(customerDTO, CustomerEntity.class);
    }
    public List<CustomerDTO> convertToDtoList(List<CustomerEntity> customers) {
        return modelMapper.map(customers, new TypeToken<List<CustomerDTO>>() {}.getType());
    }
    //Item Mapping
    public ItemDTO convertToDto(ItemEntity itemEntity) {
        return modelMapper.map(itemEntity, ItemDTO.class);
    }
    public ItemEntity convertToEntity(ItemDTO itemDTO) {
        return modelMapper.map(itemDTO, ItemEntity.class);
    }
    public List<ItemDTO> convertToItemDtoList(List<ItemEntity> items) {
        return modelMapper.map(items, new TypeToken<List<ItemDTO>>() {}.getType());
    }
    //Order Mapping
    public OrderEntity convertToOrderEntity(OrderDTO dto){
        return modelMapper.map(dto, OrderEntity.class);
    }
    //Order Details Mapping
    public OrderDetailEntity convertToOrderDetailEntity(OrderDetailDTO dto){
        return modelMapper.map(dto, OrderDetailEntity.class);
    }
}
