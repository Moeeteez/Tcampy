package tn.esprit.springprojet.services;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;
import com.stripe.model.Customer;
import com.sun.xml.internal.messaging.saaj.packaging.mime.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import tn.esprit.springprojet.entities.Payment;
import tn.esprit.springprojet.entities.Product;
import tn.esprit.springprojet.entities.Sales;
import tn.esprit.springprojet.repositories.SalesRepository;

import java.util.HashMap;
import java.util.Map;
@Service
public class StripeService {

    //    @Autowired
//    UserRepository userRepository;
    @Autowired
    IProductService productRepo;
    @Autowired
    ISalesService salesService;

    @Value("sk_test_51KhM0dLVKNxUp7QKaSYm5RgoKdyz63FcA8J4yGCR5QpO6nrroYsbsITZu5YEcURxo5erVDTmGG25XWAC6cvfqztK00TbzVhB6d")
    String stripeKey;

    public Payment payment(long idUser, long idProduct, Payment p) throws StripeException {
        Stripe.apiKey = stripeKey;
        //   User user = userRepository.findById(idUser).get();
        Product product = productRepo.retrieveProduct(idProduct);
        Map<String, Object> params = new HashMap<>();
//        params.put("name", user.getName());
//        params.put("email", user.getEmail());
        // params.put("amount", reservation.getPriceTotal());
        //params.put("created",p.getCreated());
        Customer customer = Customer.create(params);
        p.setCustomerId(customer.getId());
        return p;
    }

    public Sales createCharge(String email, String token, Long idUser, Long idProduct, Sales s) throws StripeException, MessagingException {
        // User user = userRepository.findById(idUser).get();
        Product product = productRepo.retrieveProduct(idProduct);
        String id;
        Stripe.apiKey = stripeKey;
        Map<String, Object> chargeParams = new HashMap<>();
        chargeParams.put("amount", Math.round(product.getPriceSale() * 100));
        chargeParams.put("currency", "usd");
        chargeParams.put("receipt_email", email);
        chargeParams.put("description", "Charge for " + email);
        chargeParams.put("source", token); // ^ obtained with Stripe.js
        //create a charge
        Charge charge = Charge.create(chargeParams);
        id = charge.getId();
        if (id == null) {
            throw new RuntimeException("Something went wrong!");
        }

        // payment successfully
        Sales sale = salesService.sale(idUser,idProduct,s);
        return sale ;

    }
}
