package com.jmquijano.proyecto_ecommerce.application;

import com.jmquijano.proyecto_ecommerce.domain.ItemCart;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Data
public class CartService {

    private List<ItemCart> itemCarts;

    private HashMap<Integer, ItemCart> itemCartHashMap;

    public CartService() {
        this.itemCarts = new ArrayList<>();
        this.itemCartHashMap = new HashMap<>();
    }

    public void addItemCart(Integer quantity, Integer idProduct, String nameProduct, BigDecimal price) {
        ItemCart itemCart = new ItemCart(idProduct, nameProduct, quantity, price);
        itemCartHashMap.put(itemCart.getIdProduct(), itemCart);
        fillList();
    }

    public BigDecimal getTotalCart() {
        BigDecimal total = BigDecimal.ZERO;
        for (ItemCart itemCart : itemCarts) {
            total = total.add(itemCart.getItemTotalPrice());
        }
        return total;
    }

    public void removeItemCart(Integer idProduct) {
        itemCartHashMap.remove(idProduct);
        fillList();
    }

    public void removeAllItemsCart() {
        itemCartHashMap.clear();
        itemCarts.clear();
    }

    private void fillList() {
        itemCarts.clear();
        itemCartHashMap.forEach((integer, itemCart) -> {
            itemCarts.add(itemCart);
        });
    }
}
