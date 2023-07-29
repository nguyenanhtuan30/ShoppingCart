package vn.iviettech.shoppingcart.service;

import vn.iviettech.shoppingcart.entity.ProductEntity;

import java.util.List;

public interface ProductService {

    List<ProductEntity> getAll();

    public ProductEntity findProductByID(Long id);


}
