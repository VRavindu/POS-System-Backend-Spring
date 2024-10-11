package lk.ijse.gdse.possystembackendspring.controller;

import lk.ijse.gdse.possystembackendspring.dto.ItemDTO;
import lk.ijse.gdse.possystembackendspring.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/items")
@RequiredArgsConstructor
public class ItemController {
    @Autowired
    private final ItemService itemService;
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> saveItem(@RequestBody ItemDTO item){
        String isSaved = itemService.saveItem(item);
        if (isSaved.contains("Item Saved Successfully")){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @PatchMapping(value = "/{itemCode}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> updateItem(@PathVariable ("itemCode") String itemCode, @RequestBody ItemDTO item){
        try {
            if (item == null && (itemCode == null || itemCode.equals(""))){
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }else {
                itemService.updateItem(itemCode, item);
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping(value = "/{itemCode}")
    public ResponseEntity<String> deleteItem(@PathVariable ("itemCode") String itemCode){
        try {
            if (itemCode == null || itemCode.equals("")){
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }else {
                itemService.deleteItem(itemCode);
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
