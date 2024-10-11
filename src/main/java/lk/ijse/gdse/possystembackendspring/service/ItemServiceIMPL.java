package lk.ijse.gdse.possystembackendspring.service;

import jakarta.transaction.Transactional;
import lk.ijse.gdse.possystembackendspring.dto.ItemDTO;
import lk.ijse.gdse.possystembackendspring.entity.ItemEntity;
import lk.ijse.gdse.possystembackendspring.repository.ItemRepository;
import lk.ijse.gdse.possystembackendspring.util.AppUtil;
import lk.ijse.gdse.possystembackendspring.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ItemServiceIMPL implements ItemService{
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
        if (saveItem != null && saveItem.getItemCode() != null){
            return "Item Saved Successfully";
        }else {
            return "Item Save Failed";
        }
    }
    @Override
    public void updateItem(String itemCode, ItemDTO itemDTO) {
        Optional<ItemEntity> tmpItemEntity = itemRepository.findById(itemCode);
        if (!tmpItemEntity.isPresent()){
            throw new RuntimeException("Item Not Found");
        }else {
            tmpItemEntity.get().setDescription(itemDTO.getDescription());
            tmpItemEntity.get().setQuantity(itemDTO.getQuantity());
            tmpItemEntity.get().setPrice(itemDTO.getPrice());
        }
    }

    @Override
    public void deleteItem(String itemCode) {

    }

    @Override
    public ItemDTO getItem(String itemCode) {
        return null;
    }

    @Override
    public List<ItemDTO> getAllItems() {
        return List.of();
    }
}
