package tcampy.pidev.Services;
import tcampy.pidev.Entity.Rental;

import java.util.Date;
import java.util.List;
public interface IRentalService {

        Rental addRental (Rental rental);
        Rental updateRental(Rental rental);
        void deleteRentalById(Long idRental);
         Rental getRentalById(Long idRental);
        List<Rental> getAllRental();
       // List<Rental> getRentalByDate(Date date);
       // List<Rental> getRentalByClient(Client client);
      //  double getTotalPrixLocationsByClient(Client client);
      //  int getNombreLocationsByClient(Client client);
       // int getNombreLocationsByProduct(Product product);
       // double getTotalPriceByProduct(Product product);
    }


