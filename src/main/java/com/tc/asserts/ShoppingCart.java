package com.tc.asserts;

import java.util.List;

public class ShoppingCart {

    public double calculateTotalPrice(List<Item> items) {
        return items.stream()
                .mapToDouble(Item::getPrice)
                .sum();

    }
}
