package tcampy.pidev.Controllers;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tcampy.pidev.Entity.Rental;
import tcampy.pidev.Entity.Sales;
import tcampy.pidev.Services.IRentalService;
import tcampy.pidev.Services.ISalesService;

import java.util.List;

@AllArgsConstructor

@RestController
@Slf4j
@RequestMapping("Rental")
public class RentalController {
        @Autowired
        IRentalService iRentalService  ;

        @GetMapping("/getAll")
        List<Rental> retriveAllRental() {
            return iRentalService.getAllRental();
        }

        @PostMapping("/add")
        @ResponseBody
        public Rental AddRental(@RequestBody Rental rental) {
            return iRentalService.addRental(rental);
        }

        @PutMapping("/update")
        @ResponseBody
        public Rental updateRental(@RequestBody Rental rental) {
            return iRentalService.updateRental(rental);
        }

        @GetMapping("/get/{id}")
        Rental retriveRental(@PathVariable long id) {
            return iRentalService.getRentalById(id);
        }

        @DeleteMapping("/delete/{id}")
        void deleteRental(@PathVariable long id) {
            iRentalService.deleteRentalById(id);
        }
    }


