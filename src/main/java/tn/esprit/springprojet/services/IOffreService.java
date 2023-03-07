package tn.esprit.springprojet.services;

import tn.esprit.springprojet.entities.Offer;
import tn.esprit.springprojet.entities.Product;
import tn.esprit.springprojet.entities.ProductCategory;

import java.util.Date;
import java.util.List;

public interface IOffreService {
        Offer addOffer(Offer offer);
        Offer updateOffer(Offer offer);
        void deleteOfferById(Long idOffer);
        Offer getOfferById(Long offerId);
        List<Offer> getAllOffers();
        List<Offer> getOffersByDate(Date date);
        List<Offer> getOffersByProduct(Product product);
        List<Offer> getOffersByCategory(ProductCategory productCategory);
        List<Offer> getFreeProductOffers();
        void updateOfferWithFreeProduct(Offer offer, Long idFreeProduct, int minimumPurchaseQuantity);


}
