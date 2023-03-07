package tn.esprit.springprojet.services;
import tn.esprit.springprojet.entities.Payment;
import tn.esprit.springprojet.entities.PaymentType;
import tn.esprit.springprojet.entities.Rental;
import tn.esprit.springprojet.entities.Sales;
import java.util.Date;
import java.util.List;

public interface IPaymentService {

    Payment addPayment(Payment payment);
    Payment updatePayment(Payment payment);
    void deletePaymentById(Long paymentId);
    Payment getPaymentById(Long paymentId);
    List<Payment> getPaymentsByDate(Date date);
    List<Payment> getAllPayments() ;

    List<Payment> getPaymentsByRental(Rental rental);
    List<Payment> getPaymentsBySales(Sales sales);
    double getTotalPaymentsByType(PaymentType paymentType);
    double getTotalPaymentsByRental(Rental rental);
    double getTotalPaymentsBySales(Sales sales);
}
