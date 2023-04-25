package tcampy.pidev.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tcampy.pidev.Entity.Rental;
import tcampy.pidev.Repository.RentalRepository;

import java.util.Date;
import java.util.List;

@Service
public class Rentalimpl  implements  IRentalService{

    @Autowired
    private RentalRepository rentalRepository;
    @Override
    public Rental updateRental(Rental rental) {return rentalRepository.save(rental);}
    @Override
    public Rental addRental(Rental rental) {return rentalRepository.save(rental);}
    @Override
    public void deleteRentalById(Long idRental) {rentalRepository.deleteById(idRental);}
    @Override
    public Rental getRentalById(Long idRental) {return rentalRepository.findById(idRental).orElse(null);}
    @Override
    public List<Rental> getAllRental() {return rentalRepository.findAll();}

//    @Override
//    public List<Rental> getRentalByDate(Date date) {return rentalRepository.findByStartDateLessThanEqualAndEndDateGreaterThanEqual(date, date);}
//

//    @Override
//    public double getTotalPriceByProduct(Product product) {
//        List<Rental> rentals = rentalRepository.findByProduct(product);
//        double totalPrice = 0;
//        for (Rental rental : rentals) {
//            totalPrice += rental.getPrice();
//        }
//        return totalPrice;
//    }
}
