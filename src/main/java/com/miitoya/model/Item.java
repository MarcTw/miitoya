package com.miitoya.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long i_id;
    @NotNull
    private Long v_id;
    @NotNull
    private Integer stock;
    private Boolean is_subitem;
    private Long model;
    @NotNull
    private BigDecimal p_price;
    private String description;
    private Integer has_sold;
    private Boolean status;
    public Item(){

    }

    public Item(@NotEmpty long v_id, @NotEmpty int stock, @NotEmpty boolean is_subitem, long model, BigDecimal p_price, String description, int has_sold, boolean status) {
        this.v_id = v_id;
        this.stock = stock;
        this.is_subitem = is_subitem;
        this.model = model;
        this.p_price = p_price;
        this.description = description;
        this.has_sold = has_sold;
        this.status = status;
    }

    public long getI_id() {
        return i_id;
    }

    public void setI_id(long i_id) {
        this.i_id = i_id;
    }

    public long getV_id() {
        return v_id;
    }

    public void setV_id(long v_id) {
        this.v_id = v_id;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public boolean isIs_subitem() {
        return is_subitem;
    }

    public void setIs_subitem(boolean is_subitem) {
        this.is_subitem = is_subitem;
    }

    public long getModel() {
        return model;
    }

    public void setModel(long model) {
        this.model = model;
    }

    public BigDecimal getP_price() {
        return p_price;
    }

    public void setP_price(BigDecimal p_price) {
        this.p_price = p_price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getHas_sold() {
        return has_sold;
    }

    public void setHas_sold(int has_sold) {
        this.has_sold = has_sold;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
