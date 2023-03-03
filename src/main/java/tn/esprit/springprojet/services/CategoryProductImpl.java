package tn.esprit.springprojet.services;

import tn.esprit.springprojet.entities.ProductCategory;
import tn.esprit.springprojet.repositories.ProductCategoryRepository;
import tn.esprit.springprojet.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Set;

public class CategoryProductImpl  implements IProductCategoryService {
    @Autowired
    ProductCategoryRepository productCategoryRepository ;
    @Autowired
    ProductRepository productRepository ;

    @Override
    public List<ProductCategory> retriveAllProductCategory() {
        return productCategoryRepository.findAll() ;}

    @Override
    public ProductCategory addProductCategory(ProductCategory D) {
        return productCategoryRepository.save(D);
    }

    @Override
    public void deleteProductCategory(long id) {
    productCategoryRepository.deleteById(id);}

    @Override
    public ProductCategory updateProductCategory(ProductCategory D) {
        return productCategoryRepository.save(D);
    }

    @Override
    public ProductCategory retrieveProductCategory(long id) {
        return productCategoryRepository.findById(id).orElse(null);
    }

    @Override
    public void assignCategoryToProduct(long idProduct, long ProductCategory) {

    }

    @Override
    public Set<ProductCategory> retrieveProductCategoryByProduct(long idProduct) {
        return null;
    }
}
