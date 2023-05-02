package tcampy.pidev.Services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tcampy.pidev.Entity.Cart;
import tcampy.pidev.Entity.Product;
import tcampy.pidev.Entity.User;
import tcampy.pidev.Repository.CardRepository;
import tcampy.pidev.Repository.ProductRepository;
import tcampy.pidev.Repository.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CartService {

    @Autowired
    private CardRepository cardRepository ;

    @Autowired
    private ProductRepository productRepository ;

    @Autowired
    private UserRepository userRepository ;

    public void deleteCartItem(Integer cartId) {
        cardRepository.deleteById(cartId);
    }

    public Cart addToCart(Integer productId) {
        Product product = productRepository.findById(productId).get();



        User user = new User("moeeteez", "moetez", "hammadi", "moet1544");
//        if(user.getUserFirstName() != null) {
//            user = userRepository.findById(user.getUserFirstName()).get();
//        }

//        List<Cart> cartList = cardRepository.findByUser(user);
//        List<Cart> filteredList = cartList.stream().filter(x -> x.getProduct().getProductId() == productId).collect(Collectors.toList());

//        if(filteredList.size() > 0) {
//            return null;
//        }

        if(product != null && user != null) {
            Cart cart = new Cart(product, user);
            return cardRepository.save(cart);
        }

        return null;
    }

//    public List<Cart> getCartDetails() {
//        String username = JwtRequestFilter.CURRENT_USER;
//        User user = userDao.findById(username).get();
//        return cartDao.findByUser(user);
//    }
}
