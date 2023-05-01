//package tcampy.pidev.Services;
//
//import com.stripe.Stripe;
//import com.stripe.exception.StripeException;
//import com.stripe.model.Charge;
//import com.stripe.model.Customer;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Service;
//import tcampy.pidev.Entity.Order;
//import tcampy.pidev.Entity.Payment;
//import tcampy.pidev.Entity.User;
//import tcampy.pidev.Repository.OrdreRepository;
//
//import java.util.HashMap;
//import java.util.Map;
//
//@Service
//public class StripeService {
//
//@Autowired
//    OrdreRepository orderRepository ;
//    @Value("sk_test_51MlWnABjVr8vMAE0Bj4Mu6DSc3u4VOeze7NY8tQeMiXJx5KyMKX8LvaWwW1u2fYQnEUZXbpGerBQubQujyjt8Mgt00LTsN8bZJ")
//    String stripeKey;
//        private String apiKey;
//
//        public Charge chargeCreditCard(String token,int idOrder) throws StripeException {
//
//           Order order =orderRepository.findById(idOrder).get() ;
//            Stripe.apiKey = apiKey;
//            Map<String, Object> params = new HashMap<>();
//            params.put("amount",Math.round(order.getTotalOrderPrice() * 100));
//            params.put("currency", "eur");
//            params.put("source", token);
//            Charge charge = Charge.create(params);
//            return charge;
//        }
//    }
//
