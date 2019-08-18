package com.miitoya.controller;

import com.miitoya.model.Item;
import com.miitoya.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/item")
public class ItemController {
    @Autowired
    ItemService itemService;

    @PostMapping("/create")
    public ResponseEntity<?> login(@RequestBody Item v){
        itemService.saveItem(v);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("")
    public Page<Item> getUserSetting(@RequestParam(value = "page", defaultValue = "0") Integer page,
                                     @RequestParam(value = "size", defaultValue = "15") Integer size) {
        Sort sort = new Sort(Sort.Direction.DESC, "v_id");
        Pageable pageable = new PageRequest(page, size);
        return itemService.findAll(pageable);
    }

}
