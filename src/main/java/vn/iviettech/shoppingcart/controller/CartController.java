package vn.iviettech.shoppingcart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import vn.iviettech.shoppingcart.entity.CartEntity;
import vn.iviettech.shoppingcart.entity.ProductEntity;
import vn.iviettech.shoppingcart.service.CartService;
import vn.iviettech.shoppingcart.service.ProductService;

@Controller
@RequestMapping("carts")

public class CartController {

    @Autowired
    private CartEntity cartEntity;

    @Autowired
    private ProductService productService;

    @Autowired
    private CartService cartService;



//    @PostMapping
//    public String add(@ModelAttribute ProductEntity product, Model model) {
//        System.out.println("requestID" + product.getId());
//        cartEntity.addItem(product);
//        model.addAttribute("items", productService.getAll());
//        model.addAttribute("item", new ProductEntity());
//
//        return "cart";
//    }
    @GetMapping("listCarts")
    public String viewCarts(Model model){
        model.addAttribute("items", cartService.getAllItems());
        return "cart";
    }

    @GetMapping("add/{id}")
    public String addCart(@PathVariable("id") Long id){
        ProductEntity product = productService.findProductByID(id);
        if (product != null){
            CartEntity item = new CartEntity();
            item.setProductId(Math.toIntExact(product.getId()));
            item.setName(product.getName());
            item.setPrice(product.getPrice());
            item.setQuantity(1);
            cartService.addToCart(item);
        }
        return "redirect:/carts/listCarts";
    }
}
