package lk.ijse.gdse.possystembackendspring.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.gdse.possystembackendspring.customObj.ItemResponse;
import lk.ijse.gdse.possystembackendspring.dto.ItemDTO;
import lk.ijse.gdse.possystembackendspring.entity.ItemEntity;
import lk.ijse.gdse.possystembackendspring.exception.ItemNotFoundException;
import lk.ijse.gdse.possystembackendspring.repository.ItemRepository;
import lk.ijse.gdse.possystembackendspring.service.ItemService;
import lk.ijse.gdse.possystembackendspring.util.AppUtil;
import lk.ijse.gdse.possystembackendspring.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ItemServiceIMPL implements ItemService {
    private final ItemRepository itemRepository;
    private final Mapping mapping;
    @Autowired
    public ItemServiceIMPL(ItemRepository itemRepository, Mapping mapping) {
        this.itemRepository = itemRepository;
        this.mapping = mapping;
    }
    @Override
    public String saveItem(ItemDTO itemDTO) {
        itemDTO.setItemCode(AppUtil.CreateItemCode());
        ItemEntity saveItem = itemRepository.save(mapping.convertToEntity(itemDTO));
        if (saveItem.getItemCode() != null) {
            return "Item Saved Successfully";
        } else {
            return "Item Save Failed";
        }
    }
    @Override
    public void updateItem(String itemCode, ItemDTO itemDTO) {
        Optional<ItemEntity> tmpItemEntity = itemRepository.findById(itemCode);
        if (tmpItemEntity.isEmpty()){
            throw new ItemNotFoundException("Item Not Found");
        }else {
            tmpItemEntity.get().setDescription(itemDTO.getDescription());
            tmpItemEntity.get().setQuantity(itemDTO.getQuantity());
            tmpItemEntity.get().setPrice(itemDTO.getPrice());
        }
    }
    @Override
    public void deleteItem(String itemCode) {
        Optional<ItemEntity> findId = itemRepository.findById(itemCode);
        if (findId.isEmpty()){
            throw new ItemNotFoundException("Item Not Found");
        }else {
            itemRepository.deleteById(itemCode);
        }
    }
    @Override
    public ItemResponse getItem(String itemCode) {
        if (itemRepository.existsById(itemCode)){
            return mapping.convertToDto(itemRepository.getReferenceById(itemCode));
        }else {
            throw new ItemNotFoundException("Item Not Found");
        }
    }
    @Override
    public List<ItemDTO> getAllItems() {
        return mapping.convertToItemDtoList(itemRepository.findAll());
    }
}
