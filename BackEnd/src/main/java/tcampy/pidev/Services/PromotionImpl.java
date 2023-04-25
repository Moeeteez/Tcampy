package tcampy.pidev.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tcampy.pidev.Entity.Product;
import tcampy.pidev.Entity.Promotion;
import tcampy.pidev.Entity.PromotionType;
import tcampy.pidev.Repository.PromotionRepository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
public class PromotionImpl  implements  IPromotionService {

    @Autowired
    private PromotionRepository promotionRepository;
    @Override
    public Promotion updatePromotion(Promotion promotion) {return promotionRepository.save(promotion);}
    @Override
    public Promotion addPromotion(Promotion promotion) {return promotionRepository.save(promotion);}
    @Override
    public void deletePromotionById(Long idPromotion) {promotionRepository.deleteById(idPromotion);}
    @Override
    public Promotion getPromotionById(Long idPromotion) {
        return promotionRepository.findById(idPromotion).orElse(null);}
    @Override
    public List<Promotion> getAllPromotions() {
        return promotionRepository.findAll();}

//    @Override
//    public List<Promotion> getPromotionsByDate(Date startDate, Date endDate) {
//        if (startDate == null || endDate == null) {
//            throw new IllegalArgumentException("Both startDate and endDate must be provided");
//        }
//        return promotionRepository.findBetwenDates(startDate, endDate);
//    }
//

//    @Override
//    public List<Promotion> getPromotionsByCategory(ProductCategory productCategory) {
//        return null;
//                ///promotionRepository.findByProductCategory(productCategory);
//    }
//
//    @Override
//    public double applyPromotion(Product product) {
//        double discountedPrice = product.getPriceSale();
//        Promotion promotion = product.getPromotion();
//        if (promotion != null) {
//            if (promotion.getPromotionType() == PromotionType.HAPPY_DAYS) {
//                int percentageDiscount = promotion.getPercentageDiscount();
//                discountedPrice *= (100 - percentageDiscount) / 100.0;
//            } else if (promotion.getPromotionType() == PromotionType.BLACK_FRIDAY) {
//                int percentageDiscount = promotion.getPercentageDiscount();
//                discountedPrice *= (100 - percentageDiscount) / 100.0;
//            } else if (promotion.getPromotionType() == PromotionType.HAPPY_HOUR) {
//                LocalDate currentDate = LocalDate.now();
//                if (currentDate.isAfter(promotion.getStartDate()) && currentDate.isBefore(promotion.getEndDate())) {
//                    int percentageDiscount = promotion.getPercentageDiscount();
//                    discountedPrice *= (100 - percentageDiscount) / 100.0;
//                }
//                product.setPriceSale(discountedPrice);
//            }
//        }
//        return discountedPrice;
//    }
}
