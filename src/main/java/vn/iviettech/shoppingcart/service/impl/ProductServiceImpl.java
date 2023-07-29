package vn.iviettech.shoppingcart.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.iviettech.shoppingcart.entity.ProductEntity;
import vn.iviettech.shoppingcart.repository.ProductRepository;
import vn.iviettech.shoppingcart.service.ProductService;

import java.util.List;
@Service

public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository repository;

    @Override
    public List<ProductEntity> getAll(){
        return repository.findAll();
    }


    @Override
    public ProductEntity findProductByID(Long id) {
        return repository.getReferenceById(findProductByID(id).getId());
    }


}
