package lk.ijse.gdse.possystembackendspring.controller;

import lk.ijse.gdse.possystembackendspring.customObj.ItemResponse;
import lk.ijse.gdse.possystembackendspring.dto.ItemDTO;
import lk.ijse.gdse.possystembackendspring.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/items")
@RequiredArgsConstructor
@CrossOrigin("*")
public class ItemController {
    private static final Logger logger = LoggerFactory.getLogger(ItemController.class);
    @Autowired
    private final ItemService itemService;
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> saveItem(@RequestBody ItemDTO item){
        String isSaved = itemService.saveItem(item);
        if (isSaved.contains("Item Saved Successfully")){
            logger.info("Item saved Successfully", item.getItemCode());
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            logger.error("Item saved Failed", item.getItemCode());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @PatchMapping(value = "/{itemCode}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> updateItem(@PathVariable ("itemCode") String itemCode, @RequestBody ItemDTO item){
        try {
            if (item == null && (itemCode == null || itemCode.isEmpty())){
                logger.error("ItemCode is null or empty", itemCode);
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }else {
                logger.info("Item Updated Successfully", item.getItemCode());
                itemService.updateItem(itemCode, item);
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        }catch (Exception e){
            logger.error("Item Update Failed", item.getItemCode(), e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping(value = "/{itemCode}")
    public ResponseEntity<String> deleteItem(@PathVariable ("itemCode") String itemCode){
        try {
            if (itemCode == null || itemCode.isEmpty()){
                logger.error("ItemCode is null or empty", itemCode);
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }else {
                logger.info("Item Deleted Successfully", itemCode);
                itemService.deleteItem(itemCode);
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        }catch (Exception e){
            logger.error("Item Delete Failed", itemCode, e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping(value = "/{itemCode}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ItemResponse getItem(@PathVariable ("itemCode") String itemCode){
        return itemService.getItem(itemCode);
    }
    @GetMapping(value = "allitems", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<ItemDTO> getAllItems(){
        List<ItemDTO> allItems = itemService.getAllItems();
        logger.info("All items found", allItems.size());
        return allItems;
    }
}
