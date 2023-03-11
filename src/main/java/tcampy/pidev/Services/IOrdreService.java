package tcampy.pidev.Services;

import tcampy.pidev.Entity.Product;

import java.util.List;

public interface IOrdreService {

    public int calculateTotalAmount(List<Product> products) ;
}
