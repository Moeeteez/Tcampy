package tcampy.pidev.Services;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.multipart.MultipartFile;
import tcampy.pidev.Entity.Product;

import java.util.List;

public interface IProductService{
    List<Product> retriveAllProduct();
    Product AddProduct(Product product);
    void deleteProduct(Integer id);
    Product updateProduct(Product product);
    Product retrieveProductById(Integer id);
    public void AddProductToCategory(Integer idProduct , Long idCategory) ;
    Product findByName(String Name) ;
    Product findProductByType (String Type) ;
     Product getProductDetailsById( Integer idProduct) ;
   //List<Product> getProductDetails(boolean isSingleProductCheckout, Integer productId);
}
