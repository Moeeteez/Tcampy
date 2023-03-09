package tcampy.pidev.Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tcampy.pidev.Entity.Offer;
import tcampy.pidev.Entity.Product;
import tcampy.pidev.Repository.OfferRepository;
import tcampy.pidev.Repository.ProductRepository;

import java.util.Date;
import java.util.List;

@Service
public class OfferImpl implements  IOffreService{
    @Autowired
    private OfferRepository offerRepository;
//    @Autowired
//    private ProductRepository productRepository;

    @Override
    public Offer updateOffer(Offer offer) {return offerRepository.save(offer);}
    @Override
    public Offer addOffer(Offer offer) {return offerRepository.save(offer);}
    @Override
    public void deleteOfferById(Long idOffer) {offerRepository.deleteById(idOffer);}
    @Override
    public Offer getOfferById(Long offerId) {return offerRepository.findById(offerId).orElse(null);}
    @Override
    public List<Offer> getAllOffers() {return offerRepository.findAll();}
    @Override
    public List<Offer> getOffersByDate(Date date) {
        return  null ;}

//    @Override
//    public List<Offer> getOffersByProduct(Product product) {
//        return offerRepository.findByProduct(product);
//    }

}
