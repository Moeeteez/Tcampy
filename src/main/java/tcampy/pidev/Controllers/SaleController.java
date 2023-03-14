package tcampy.pidev.Controllers;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tcampy.pidev.DTO.ProductSaleDTO;
import tcampy.pidev.Entity.Product;
import tcampy.pidev.Entity.Sales;
import tcampy.pidev.Services.ICategoryService;
import tcampy.pidev.Services.ISalesService;

import java.util.List;

@AllArgsConstructor

@RestController
@Slf4j
@RequestMapping("Sale")
public class SaleController {


    @Autowired
    ISalesService salesService ;

    @GetMapping("/getAll")
    List<Sales> retriveAllSales() {
        return salesService.getAllSales();
    }

    @PostMapping("/add")
    @ResponseBody
    public Sales AddSale(@RequestBody Sales sales) {
        return salesService.addVente(sales);
    }

    @PutMapping("/update")
    @ResponseBody
    public Sales updateSale(@RequestBody Sales sales) {
        return salesService.updateVente(sales);
    }

    @GetMapping("/get/{id}")
    Sales retriveSale(@PathVariable long id) {
        return salesService.getSalesById(id);
    }

    @DeleteMapping("/delete/{id}")
    void deleteSale(@PathVariable long id) {
        salesService.deleteSalesById(id);
    }

    @GetMapping("/top-selling-products/{n}")
    public ResponseEntity<List<ProductSaleDTO>> getTopSellingProducts(@PathVariable("n") int n) {
        List<ProductSaleDTO> topProducts = salesService.getTopSellingProducts(n);
        return ResponseEntity.ok(topProducts);
    }

}
