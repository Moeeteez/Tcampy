package tn.esprit.springprojet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.springprojet.entities.Product;
import tn.esprit.springprojet.entities.ProductCategory;
import tn.esprit.springprojet.entities.Promotion;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface PromotionRepository extends JpaRepository<Promotion, Long> {

        List<Promotion> findByStartDateLessThanEqualAndEndDateGreaterThanEqual(Date startDate, Date endDate);

    List<Promotion> findByProduct(Product product);

    List<Promotion> findByProductCategory(ProductCategory productCategory);


}
