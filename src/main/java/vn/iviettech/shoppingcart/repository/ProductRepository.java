package vn.iviettech.shoppingcart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.iviettech.shoppingcart.entity.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
}
