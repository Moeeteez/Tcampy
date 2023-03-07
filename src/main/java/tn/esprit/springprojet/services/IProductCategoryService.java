package tn.esprit.springprojet.services;

import org.springframework.context.annotation.Bean;
import tn.esprit.springprojet.entities.ProductCategory;

import java.util.List;
import java.util.Set;
public interface IProductCategoryService {

    List<ProductCategory> retriveAllProductCategory();

    ProductCategory AddProductCategory(ProductCategory productCategory);

    void deleteProductCategory(long id);

    ProductCategory  updateProductCategory(ProductCategory productCategory);

    ProductCategory retrieveProductCategory(long id);


}
