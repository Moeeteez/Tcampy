package tn.esprit.springprojet.Controller;

import com.stripe.exception.StripeException;
import com.sun.xml.internal.messaging.saaj.packaging.mime.MessagingException;
import org.springframework.http.ResponseEntity;
import tn.esprit.springprojet.DTO.ProductDTO;
import tn.esprit.springprojet.entities.Product;
import tn.esprit.springprojet.entities.ProductCategory;
import tn.esprit.springprojet.entities.Sales;
import tn.esprit.springprojet.services.IProductCategoryService;
import tn.esprit.springprojet.services.IProductService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.springprojet.services.IPromotionService;
import tn.esprit.springprojet.services.StripeService;

import java.util.List;
import java.util.Set;

@AllArgsConstructor

@RestController
@Slf4j
public class Controller {
    @Autowired
    IProductService list;
    @Autowired
    IProductCategoryService listC;

    @Autowired
    IPromotionService PromoS;
    @Autowired
    StripeService stripeService;

    @PostMapping("/addProduct")
    @ResponseBody
    public Product AddProduct(@RequestBody Product product) {
        return list.AddProduct(product);
    }

    @PutMapping("/updateProduct")
    @ResponseBody
    public Product updateProduct(@RequestBody Product product) {
        return list.updateProduct(product);
    }

    @GetMapping("/getAllProduct")
    List<Product> retriveAllProduct() {
        return list.retriveAllProduct();
    }

    @GetMapping("/getProduct/{id}")
    Product retriveProduct(@PathVariable long id) {
        return list.retrieveProduct(id);
    }

    @DeleteMapping("/deleteProduct{id}")
    void deleteProduct(@PathVariable long id) {
        list.deleteProduct(id);
    }

    @PutMapping("/assigneProductToCategory/{sku}/{idProduct}")
    void assigneProductToCategory(@PathVariable String sku, @PathVariable long idProduct) {
        list.assigneProductToCategory(sku, idProduct);
    }

    @GetMapping("/retrieveProductsByCategory/{idCategory}")
    Set<Product> retrieveProductsByCategory(@PathVariable long idCategory) {
        return list.retrieveProductsByCategory(idCategory);
    }


    ///////////////////Category///
    @PostMapping("/addProductCategory")
    @ResponseBody
    public ProductCategory AddProductCategory(@RequestBody ProductCategory productCategory) {
        return listC.AddProductCategory(productCategory);
    }

    @PutMapping("/updateProductCategory")
    @ResponseBody
    public ProductCategory updateProductCategory(@RequestBody ProductCategory productCategory) {
        return listC.updateProductCategory(productCategory);
    }

    @GetMapping("/getAllProductCategory")
    List<ProductCategory> retriveAllProductCategory() {
        return listC.retriveAllProductCategory();
    }

    @GetMapping("/getProductCategory/{id}")
    ProductCategory retriveProductCategory(@PathVariable long id) {
        return listC.retrieveProductCategory(id);
    }

    @DeleteMapping("/deleteProductCategory{id}")
    void deleteProductCategory(@PathVariable long id) {
        listC.deleteProductCategory(id);
    }

    @GetMapping("/promotion/{id}")
    public ResponseEntity<Product> getProductByIdAfterPromotion(@PathVariable long id) {
        Product product = list.retrieveProduct(id);
        double discountedPrice = PromoS.applyPromotion(product);
        product.setPriceSale(discountedPrice);
        return ResponseEntity.ok(product);
    }

    @PostMapping("/stripe/{email}/{token}/{idUser}/{idProduct}/{idOffer}")
    @ResponseBody
    public Sales createCharge(@PathVariable String email, @PathVariable String token, @PathVariable Long idUser, @PathVariable Long idProduct, @RequestBody Sales s) throws StripeException, MessagingException {
        return stripeService.createCharge( email,  token,  idUser,  idProduct, s);
    }

}
