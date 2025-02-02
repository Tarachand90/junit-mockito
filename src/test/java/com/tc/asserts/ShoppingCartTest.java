package com.tc.asserts;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class ShoppingCartTest {
    @Test
    public void testCalculateTotalPrice() {
        // Given
        Item item1 = new Item("Laptop", 1000);
        Item item2 = new Item("Phone", 500);
        ShoppingCart cart = new ShoppingCart();

        // When
        double totalPrice = cart.calculateTotalPrice(Arrays.asList(item1, item2));

        // Then
        assertThat(totalPrice).isEqualTo(1500.0);
    }
}
