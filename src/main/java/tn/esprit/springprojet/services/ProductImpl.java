package tn.esprit.springprojet.services;

import tn.esprit.springprojet.entities.Product ;
import tn.esprit.springprojet.entities.ProductCategory;
import tn.esprit.springprojet.repositories.ProductCategoryRepository;
import tn.esprit.springprojet.repositories.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Slf4j
@AllArgsConstructor
public class ProductImpl implements IProductService{
    @Autowired
ProductRepository productRepository ;
    @Autowired
ProductCategoryRepository productCategoryRepository ;

    @Override
    public List<Product> retriveAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public Product AddProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(Long idProduct) {
        productRepository.deleteById(idProduct);
    }

    @Override
    public Product updateProduct(Product P) {
        return productRepository.save(P);
    }

    @Override
    public Product retrieveProduct(Long idProduct) {
        return productRepository.findById(idProduct).orElse(null) ;
    }

    @Override
    public void assigneProductToCategory(String sku, long idProduct) {
    Product product =productRepository.findBySku(sku);
    ProductCategory productCategory =productCategoryRepository.findById(idProduct).orElse(null);
   productCategory.getProducts().add(product) ;

    }
}
