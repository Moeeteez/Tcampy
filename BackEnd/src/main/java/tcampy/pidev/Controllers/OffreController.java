package tcampy.pidev.Controllers;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tcampy.pidev.Entity.Offer;
import tcampy.pidev.Services.IOffreService;

import java.util.List;
@AllArgsConstructor

@RestController
@Slf4j
@RequestMapping("Offer")
public class OffreController {

    @Autowired
    IOffreService iOffreService;

    @GetMapping("/getAll")
    List<Offer> retriveAllOffer() {return iOffreService.getAllOffers();}
    @PostMapping("/add")
    @ResponseBody
    public Offer AddRental(@RequestBody Offer offer) {
        return iOffreService.addOffer(offer);
    }

    @PutMapping("/update")
    @ResponseBody
    public Offer updateOffer(@RequestBody Offer offer) {
        return iOffreService.updateOffer(offer);
    }

    @GetMapping("/get/{id}")
    Offer retriveOffer(@PathVariable long id) {
        return iOffreService.getOfferById(id);
    }

    @DeleteMapping("/delete/{id}")
    void deleteOffer(@PathVariable long id) {iOffreService.deleteOfferById(id);}
}