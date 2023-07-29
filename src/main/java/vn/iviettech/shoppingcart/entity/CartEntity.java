package vn.iviettech.shoppingcart.entity;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Optional;

@Component
@Data

public class CartEntity {
    private OrdersEntity ordersEntity = new OrdersEntity();

    public void addItem(ProductEntity productEntity){
        OrderDetailsEntity orderDetailsEntity = new OrderDetailsEntity();
        orderDetailsEntity.setProductEntity(productEntity);
        orderDetailsEntity.setQuantity(1);
        ordersEntity.getOrderDetailsEntities().add(orderDetailsEntity);

        print();

    }

    private void print(){
        Optional.ofNullable(ordersEntity.getOrderDetailsEntities())
                .orElse(new ArrayList<>())
                .forEach(item -> {
                    System.out.println("ProductId: "+item.getProductEntity().getId());
                    System.out.println("Quanlity: "+item.getQuantity());
                    System.out.println("===========");
                });
    }

    private Integer productId;
    private String name;
    private double price;
    private int quantity;



}
