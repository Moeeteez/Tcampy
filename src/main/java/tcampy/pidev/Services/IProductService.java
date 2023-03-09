package tcampy.pidev.Services;

import org.springframework.data.jpa.repository.JpaRepository;
import tcampy.pidev.Entity.Product;

import java.util.List;

public interface IProductService{
    List<Product> retriveAllProduct();
    Product AddProduct(Product product);
    void deleteProduct(Long id);
    Product updateProduct(Product product);
    Product retrieveProductById(Long id);
    public void AddProductToCategory(Long idProduct , Long idCategory) ;
}
