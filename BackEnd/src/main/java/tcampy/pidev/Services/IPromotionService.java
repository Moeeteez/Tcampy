package tcampy.pidev.Services;

import tcampy.pidev.Entity.Promotion;

import java.util.Date;
import java.util.List;
public interface IPromotionService {
        Promotion addPromotion(Promotion promotion);
        Promotion updatePromotion(Promotion promotion);
        void deletePromotionById(Long idPromotion);
        Promotion getPromotionById(Long idPromotion);
        List<Promotion> getAllPromotions();
        //public double applyPromotion(Product product) ;
}
