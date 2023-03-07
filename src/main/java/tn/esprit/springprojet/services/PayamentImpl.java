package tn.esprit.springprojet.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.springprojet.entities.Payment;
import tn.esprit.springprojet.entities.PaymentType;
import tn.esprit.springprojet.entities.Rental;
import tn.esprit.springprojet.entities.Sales;
import tn.esprit.springprojet.repositories.PaymentRepository;
import tn.esprit.springprojet.repositories.RentalRepository;
import tn.esprit.springprojet.repositories.SalesRepository;

import java.util.Date;
import java.util.List;

@Service
public class PayamentImpl implements  IPaymentService{

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private RentalRepository rentalRepository;
    @Autowired
    private SalesRepository salesRepository;

    @Override
    public Payment addPayment(Payment payment) {
        return paymentRepository.save(payment);}
    @Override
    public Payment updatePayment(Payment payment) {
        return paymentRepository.save(payment);}
    @Override
    public void deletePaymentById(Long paymentId) {
        paymentRepository.deleteById(paymentId);}
    @Override
    public Payment getPaymentById(Long paymentId) {
        return paymentRepository.findById(paymentId).orElse(null);}
    @Override
    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();}
    @Override
    public List<Payment> getPaymentsByRental(Rental rental) {
        return paymentRepository.findByRental(rental);}
    @Override
    public List<Payment> getPaymentsBySales(Sales sales) {
        return paymentRepository.findBySales(sales);}
    @Override
    public double getTotalPaymentsByRental(Rental rental) {
        List<Payment> payments = paymentRepository.findByRental(rental);
        double total = 0;
        for (Payment payment : payments) {
            total += payment.getAmount();
        }return total;}
    @Override
    public double getTotalPaymentsBySales(Sales sale) {
        List<Payment> payments = paymentRepository.findBySales(sale);
        double total = 0.0;
        for (Payment payment : payments) {
            total += payment.getAmount();
        }
        return total;
    }
    @Override
    public double getTotalPaymentsByType(PaymentType paymentType) {
        List<Payment> payments = paymentRepository.getPaymentsByType(paymentType);
        double totalPayments = 0.0;
        for (Payment payment : payments) {
            totalPayments += payment.getAmount();
        }
        return totalPayments;
    }
    @Override
    public List<Payment> getPaymentsByDate(Date date) {
        return paymentRepository.findByPaymentDate(date);
    }


}

