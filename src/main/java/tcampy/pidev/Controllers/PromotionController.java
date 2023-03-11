package tcampy.pidev.Controllers;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tcampy.pidev.Entity.Offer;
import tcampy.pidev.Entity.Promotion;
import tcampy.pidev.Services.IOffreService;
import tcampy.pidev.Services.IPromotionService;
import java.util.List;
@AllArgsConstructor
@RestController
@Slf4j
@RequestMapping("Promotion")
public class PromotionController {

    @Autowired
    IPromotionService iPromotionService ;

    @GetMapping("/getAll")
    List<Promotion> retriveAllOffer() {return iPromotionService.getAllPromotions();}
    @PostMapping("/add")
    @ResponseBody
    public Promotion AddPromotion(@RequestBody Promotion promotion) {
        return iPromotionService.addPromotion(promotion);
    }

    @PutMapping("/update")
    @ResponseBody
    public Promotion updatePromotion(@RequestBody Promotion promotion) {
        return iPromotionService.updatePromotion(promotion);
    }

    @GetMapping("/get/{id}")
    Promotion retriveOffer(@PathVariable long id) {
        return iPromotionService.getPromotionById(id);
    }

    @DeleteMapping("/delete/{id}")
    void deletePromotion(@PathVariable long id) {iPromotionService.deletePromotionById(id);}
}
