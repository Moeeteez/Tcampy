package tn.esprit.springprojet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.springprojet.entities.*;

import java.util.Date;
import java.util.List;

@Repository

public interface PaymentRepository extends JpaRepository<Payment,Long> {
    List<Payment> findByRental(Rental rental);
    List<Payment> findBySales(Sales sales);
    List<Payment> getPaymentsByType(PaymentType paymentType);
    List<Payment> findByPaymentTypeAndSales(PaymentType paymentType, Sales sales);
    List<Payment> findByPaymentTypeAndRental(PaymentType paymentType, Rental rental);
    List<Payment> findByPaymentDate(Date date);

}
