package com.zuo.springel;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("Customer2")
public class Customer2 {
    @Value("#{itemBean}")
    private Item item;

    @Value("#{itemBean.name}")
    private String itemName;

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    @Override
    public String toString() {
        return "Customer2{" +
                "item=" + item +
                ", itemName='" + itemName + '\'' +
                '}';
    }
}
