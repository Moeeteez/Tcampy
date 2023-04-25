package tn.esprit.springprojet.repositories;

import tn.esprit.springprojet.entities.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ProductCategoryRepository  extends JpaRepository<ProductCategory,Long> {
}
