package com.zuo.springel;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("itemBean")
public class Item extends Object{
    @Value("Gongyu")
    private String name;

    @Value("10")
    private int qty;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public Item(String name, int qty) {
        this.name = name;
        this.qty = qty;
    }

    public Item() {
    }
}
