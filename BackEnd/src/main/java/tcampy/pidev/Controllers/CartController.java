package tcampy.pidev.Controllers;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import tcampy.pidev.Entity.Cart;
import tcampy.pidev.Services.CartService;

import java.util.List;

@RestController
public class CartController {

    @Autowired
    private CartService cartService;


    @GetMapping({"/addToCart/{productId}"})
    public Cart addToCart(@PathVariable(name = "productId") Integer productId) {
        return cartService.addToCart(productId);
    }


//    @DeleteMapping({"/deleteCartItem/{cartId}"})
//    public void deleteCartItem(@PathVariable(name = "cartId") Integer cartId) {
//        cartService.deleteCartItem(cartId);
//    }
//
//
    @GetMapping({"/getCartDetails"})
    public List<Cart> getCartDetails() {
        return cartService.getCartDetails();
    }
}
