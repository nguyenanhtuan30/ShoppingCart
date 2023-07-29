package vn.iviettech.shoppingcart.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Table(name = "orders")
@Entity

public class OrdersEntity {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String customerName;
    private String customerAddress;
    private LocalDateTime Date;
    @OneToMany
    private List<OrderDetailsEntity> OrderDetailsEntities = new ArrayList<>();

    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public LocalDateTime getDate() {
        return Date;
    }

    public void setDate(LocalDateTime date) {
        Date = date;
    }


    public List<OrderDetailsEntity> getOrderDetailsEntities() {
        return OrderDetailsEntities;
    }

    public void setOrderDetailsEntities(List<OrderDetailsEntity> orderDetailsEntities) {
        OrderDetailsEntities = orderDetailsEntities;
    }
}
