package tn.esprit.springprojet.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.springprojet.entities.Offer;
import tn.esprit.springprojet.entities.Product;
import tn.esprit.springprojet.entities.ProductCategory;
import tn.esprit.springprojet.repositories.OfferRepository;
import tn.esprit.springprojet.repositories.ProductRepository;

import java.util.Date;
import java.util.List;

@Service
public class OfferImpl implements  IOffreService{

    @Autowired
    private OfferRepository offerRepository;
    @Autowired
    private ProductRepository productRepository;

    @Override
    public Offer addOffer(Offer offer) {
        return offerRepository.save(offer);
    }

    @Override
    public Offer updateOffer(Offer offer) {
        return offerRepository.save(offer);
    }

    @Override
    public void deleteOfferById(Long idOffer) {
        offerRepository.deleteById(idOffer);
    }

    @Override
    public Offer getOfferById(Long offerId) {
        return offerRepository.findById(offerId).orElse(null);
    }

    @Override
    public List<Offer> getAllOffers() {
        return offerRepository.findAll();
    }

    @Override
    public List<Offer> getOffersByDate(Date date) {
        return offerRepository.findByStartDateLessThanEqualAndEndDateGreaterThanEqual(date, date);
    }

    @Override
    public List<Offer> getOffersByProduct(Product product) {
        return offerRepository.findByProduct(product);
    }

    @Override
    public List<Offer> getOffersByCategory(ProductCategory productCategory) {
        return offerRepository.findByProductCategory(productCategory);
    }

    @Override
    public List<Offer> getFreeProductOffers() {
        return offerRepository.findByPriceEquals(0.0);
    }

    @Override
    public void updateOfferWithFreeProduct(Offer offer, Long SkuFreeProduct, int minimumQuantity) {
        Product freeProduct = productRepository.findById(SkuFreeProduct)
                .orElse(null);
        offer.setSkufreeProduct(SkuFreeProduct);
        offer.setMinimumQuantity(minimumQuantity);
        offerRepository.save(offer);
    }

}
