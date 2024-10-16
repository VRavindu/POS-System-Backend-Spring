package lk.ijse.gdse.possystembackendspring.service;

import lk.ijse.gdse.possystembackendspring.customObj.ItemResponse;
import lk.ijse.gdse.possystembackendspring.dto.ItemDTO;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface ItemService {
    String saveItem(ItemDTO itemDTO);
    void updateItem(String itemCode ,ItemDTO itemDTO);
    void deleteItem(String itemCode);
    ItemResponse getItem(String itemCode);
    List<ItemDTO> getAllItems();
}
