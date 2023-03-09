package tcampy.pidev.Services;
import tcampy.pidev.Entity.Payment;

import java.util.Date;
import java.util.List;
public interface IPaymentService {

    Payment addPayment(Payment payment);
    Payment updatePayment(Payment payment);
    void deletePaymentById(Long paymentId);
    Payment getPaymentById(Long paymentId);
    List<Payment> getPaymentsByDate(Date date);
    List<Payment> getAllPayments() ;

}
