package vn.iviettech.shoppingcart.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;
import vn.iviettech.shoppingcart.entity.CartEntity;
import vn.iviettech.shoppingcart.service.CartService;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
@SessionScope
public class CartServiceImpl implements CartService {
    Map<Integer, CartEntity> maps = new HashMap<>();

    @Override
    public void addToCart(CartEntity item){
        CartEntity cartEntity = maps.get(item.getProductId());
        if(cartEntity == null){
            maps.put(item.getProductId(), item);
        }else {
            cartEntity.setQuantity(cartEntity.getQuantity()+1);
        }
    }

    @Override
    public void remove(Long id){
        maps.remove(id);
    }

    @Override
    public Collection<CartEntity> getAllItems(){
        return maps.values();
    }

    @Override
    public int getCount() {
        return maps.values().size();
    }

    @Override
    public double getAmount(){
        return maps.values().stream()
                .mapToDouble(item -> item.getQuantity() * item.getPrice() )
                .sum();
    }
}
