package tn.esprit.springprojet.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.springprojet.entities.Product;
import tn.esprit.springprojet.entities.ProductCategory;
import tn.esprit.springprojet.entities.Promotion;
import tn.esprit.springprojet.entities.PromotionType;
import tn.esprit.springprojet.repositories.PromotionRepository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
public class PromotionImpl  implements  IPromotionService {

    @Autowired
    private PromotionRepository promotionRepository;

    @Override
    public Promotion addPromotion(Promotion promotion) {
        return promotionRepository.save(promotion);
    }

    @Override
    public Promotion updatePromotion(Promotion promotion) {
        return promotionRepository.save(promotion);
    }

    @Override
    public void deletePromotionById(Long idPromotion) {
        promotionRepository.deleteById(idPromotion);
    }

    @Override
    public Promotion getPromotionById(Long idPromotion) {
        return promotionRepository.findById(idPromotion).orElse(null);
    }

    @Override
    public List<Promotion> getAllPromotions() {
        return promotionRepository.findAll();
    }

    @Override
    public List<Promotion> getPromotionsByDate(Date startDate, Date endDate) {
        if (startDate == null || endDate == null) {
            throw new IllegalArgumentException("Both startDate and endDate must be provided");
        }
        return promotionRepository.findByStartDateLessThanEqualAndEndDateGreaterThanEqual(startDate, endDate);
    }

    @Override
    public List<Promotion> getPromotionsByProduct(Product product) {
        return promotionRepository.findByProduct(product);
    }

    @Override
    public List<Promotion> getPromotionsByCategory(ProductCategory productCategory) {
        return promotionRepository.findByProductCategory(productCategory);
    }

    @Override
    public double applyPromotion(Product product) {
        double discountedPrice = product.getPriceSale();
        Promotion promotion = product.getPromotion();
        if (promotion != null) {
            if (promotion.getPromotionType() == PromotionType.HAPPY_DAYS) {
                int percentageDiscount = promotion.getPercentageDiscount();
                discountedPrice *= (100 - percentageDiscount) / 100.0;
            } else if (promotion.getPromotionType() == PromotionType.BLACK_FRIDAY) {
                int percentageDiscount = promotion.getPercentageDiscount();
                discountedPrice *= (100 - percentageDiscount) / 100.0;
            } else if (promotion.getPromotionType() == PromotionType.HAPPY_HOUR) {
                LocalDate currentDate = LocalDate.now();
                if (currentDate.isAfter(promotion.getStartDate()) && currentDate.isBefore(promotion.getEndDate())) {
                    int percentageDiscount = promotion.getPercentageDiscount();
                    discountedPrice *= (100 - percentageDiscount) / 100.0;
                }
                product.setPriceSale(discountedPrice);
            }
        }
        return discountedPrice;
    }
}
