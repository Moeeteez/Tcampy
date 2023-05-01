//package tcampy.pidev.Controllers;
//
//import com.stripe.exception.StripeException;
//import com.stripe.model.Charge;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//import tcampy.pidev.Services.StripeService;
//
//@RestController
//@RequestMapping("/payment")
//public class PaymentController {
//
//    @Autowired
//    private StripeService stripeService;
//
//    @PostMapping("/charge")
//    public ResponseEntity<String> chargeCreditCard(@RequestParam("token") String token, @RequestParam("idOrder") int idOrder) {
//        try {
//            Charge charge = stripeService.chargeCreditCard(token, idOrder);
//            return ResponseEntity.ok("Payment successful. Charge ID: " + charge.getId());
//        } catch (StripeException e) {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
//        }
//    }
//}
//
