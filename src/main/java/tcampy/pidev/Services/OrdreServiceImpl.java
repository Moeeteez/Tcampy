package tcampy.pidev.Services;

import org.springframework.beans.factory.annotation.Autowired;
import tcampy.pidev.Entity.Order;
import tcampy.pidev.Entity.Product;
import tcampy.pidev.Repository.OrdreRepository;

import java.util.List;

public class OrdreServiceImpl  implements  IOrdreService{
    @Autowired
    private OrdreRepository ordreRepository ;
    @Override
    public int calculateTotalAmount(List<Product> products) {
        int totalAmount = 0;
        for (Product product : products) {
            totalAmount += product.getPriceRental() +product.getPriceSale();}
        return totalAmount;

    }

   Order order = new Order() ;

}
