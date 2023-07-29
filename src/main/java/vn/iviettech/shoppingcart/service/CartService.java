package vn.iviettech.shoppingcart.service;

import vn.iviettech.shoppingcart.entity.CartEntity;
import vn.iviettech.shoppingcart.entity.ProductEntity;

import java.util.Collection;
import java.util.List;

public interface CartService {

    public void addToCart(CartEntity item);

    void remove(Long id);

    Collection<CartEntity> getAllItems();

    int getCount();

    double getAmount();
}
