package com.miitoya.repository;

import com.miitoya.model.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ItemRespository extends JpaRepository <Item,Long> {;

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO item (v_id,stock, p_price) VALUES (?1,50, ?2); ", nativeQuery = true)
    void inserItem(Long v_id, BigDecimal p_price);

    @Query(value = "select * from Item i where i.v_id = ?1 LIMIT ?2 OFFSET ?3" , nativeQuery =  true)
    List<Item> getItemsByV_id(Long v_id, int offset , int limit);



}
