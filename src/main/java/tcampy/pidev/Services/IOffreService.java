package tcampy.pidev.Services;
import tcampy.pidev.Entity.Offer;
import tcampy.pidev.Entity.Product;

import java.util.Date;
import java.util.List;

public interface IOffreService {
        Offer addOffer(Offer offer);
        Offer updateOffer(Offer offer);
        void deleteOfferById(Long idOffer);
        Offer getOfferById(Long offerId);
        List<Offer> getAllOffers();
        List<Offer> getOffersByDate(Date date);
      //  List<Offer> getOffersByProduct(Product product);

}
