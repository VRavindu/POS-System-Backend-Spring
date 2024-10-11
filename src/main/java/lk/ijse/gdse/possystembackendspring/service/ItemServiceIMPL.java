package lk.ijse.gdse.possystembackendspring.service;

import jakarta.transaction.Transactional;
import lk.ijse.gdse.possystembackendspring.dto.ItemDTO;
import lk.ijse.gdse.possystembackendspring.repository.ItemRepository;
import lk.ijse.gdse.possystembackendspring.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

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
        return "";
    }

    @Override
    public void updateItem(String itemCode, ItemDTO itemDTO) {

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
