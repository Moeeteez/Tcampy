package tn.esprit.springprojet.services;

import tn.esprit.springprojet.entities.Product;

import java.util.List;
import java.util.Set;

public interface IProductService {
    List<Product> retriveAllProduct();
    Product AddProduct(Product product);
    void deleteProduct(Long id);
    Product updateProduct(Product product);

    Product retrieveProduct(Long id);
    void assigneProductToCategory(String sku, long  id);

    Set<Product> retrieveProductsByCategory(Long id);
}

