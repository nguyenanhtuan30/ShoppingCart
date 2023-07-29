package vn.iviettech.shoppingcart.controller;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import vn.iviettech.shoppingcart.entity.CartEntity;
import vn.iviettech.shoppingcart.entity.ProductEntity;
import vn.iviettech.shoppingcart.service.ProductService;

import java.util.List;

@Controller
@RequestMapping("products")

public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CartEntity cartEntity;

    @GetMapping("/product-list")
    public String list(Model model) {
        model.addAttribute("products", productService.getAll());
        model.addAttribute("product", new ProductEntity());

        return "product-list";
    }

    @PostMapping
    public String add(@ModelAttribute ProductEntity product, Model model) {
        System.out.println("requestID" + product.getId());
        cartEntity.addItem(product);

        model.addAttribute("products", productService.getAll());
        model.addAttribute("product", new ProductEntity());
        return "product-list";
    }

    @GetMapping("rest")
    public ResponseEntity<List<ProductEntity>> add(){
        return ResponseEntity.status(200).body(productService.getAll());
    }

}
