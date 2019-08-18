package com.miitoya.service;

import com.miitoya.model.Item;
import com.miitoya.repository.ItemRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {
    @Autowired
    ItemRespository itemRespository;

    public void saveItem(Item item){
        itemRespository.save(item);
    }

    public Page<Item> findAll (Pageable pageable){
        return itemRespository.findAll(pageable);
    }
}
