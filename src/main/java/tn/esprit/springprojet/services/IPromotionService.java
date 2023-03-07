package tn.esprit.springprojet.services;

import tn.esprit.springprojet.entities.Product;
import tn.esprit.springprojet.entities.ProductCategory;
import tn.esprit.springprojet.entities.Promotion;

import java.util.Date;
import java.util.List;

public interface IPromotionService {
        Promotion addPromotion(Promotion promotion);
        Promotion updatePromotion(Promotion promotion);
        void deletePromotionById(Long idPromotion);
        Promotion getPromotionById(Long idPromotion);
        List<Promotion> getAllPromotions();
        List<Promotion> getPromotionsByDate(Date startDate, Date endDate);
        List<Promotion> getPromotionsByProduct(Product tool);
        List<Promotion> getPromotionsByCategory(ProductCategory productCategorycategory);
        public double applyPromotion(Product product) ;
}
