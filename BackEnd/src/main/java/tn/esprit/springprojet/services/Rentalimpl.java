package tn.esprit.springprojet.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.springprojet.entities.Product;
import tn.esprit.springprojet.entities.Rental;
import tn.esprit.springprojet.repositories.RentalRepository;

import java.util.Date;
import java.util.List;

@Service
public class Rentalimpl  implements  IRentalService{

    @Autowired
    private RentalRepository rentalRepository;

    @Override
    public Rental addRental(Rental rental) {
        return rentalRepository.save(rental);
    }

    @Override
    public Rental updateRental(Rental rental) {
        return rentalRepository.save(rental);
    }

    @Override
    public void deleteRentalById(Long idRental) {
        rentalRepository.deleteById(idRental);
    }

    @Override
    public Rental getRentalById(Long idRental) {
        return rentalRepository.findById(idRental).orElse(null);
    }

    @Override
    public List<Rental> getAllRental() {
        return rentalRepository.findAll();
    }

    @Override
    public List<Rental> getRentalByProduct(Product product) {
        return rentalRepository.findByProduct(product);
    }

    @Override
    public List<Rental> getRentalByDate(Date date) {
        return rentalRepository.findByStartDateLessThanEqualAndEndDateGreaterThanEqual(date, date);
    }


    @Override
    public int getNombreLocationsByProduct(Product product) {
        return rentalRepository.countByProduct(product);
    }

    @Override
    public double getTotalPriceByProduct(Product product) {
        List<Rental> rentals = rentalRepository.findByProduct(product);
        double totalPrice = 0;
        for (Rental rental : rentals) {
            totalPrice += rental.getPrice();
        }
        return totalPrice;
    }


}
