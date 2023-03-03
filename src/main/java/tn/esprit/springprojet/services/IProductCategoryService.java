package tn.esprit.springprojet.services;

import org.springframework.context.annotation.Bean;
import tn.esprit.springprojet.entities.ProductCategory;

import java.util.List;
import java.util.Set;
public interface IProductCategoryService {

    List<ProductCategory> retriveAllProductCategory();

    ProductCategory addProductCategory(ProductCategory D);

    void deleteProductCategory(long id);

    ProductCategory  updateProductCategory (ProductCategory D);

    ProductCategory retrieveProductCategory(long id);

    void assignCategoryToProduct(long idProduct, long ProductCategory);

    Set<ProductCategory> retrieveProductCategoryByProduct(long idProduct);
}
