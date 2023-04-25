package tn.esprit.springprojet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.springprojet.entities.Offer;
import tn.esprit.springprojet.entities.Product;
import tn.esprit.springprojet.entities.ProductCategory;

import java.util.Date;
import java.util.List;

@Repository
public interface OfferRepository extends JpaRepository<Offer,Long> {

    List<Offer> findByStartDateLessThanEqualAndEndDateGreaterThanEqual(Date startDate, Date endDate);
    List<Offer> findByDate(Date date);
    List<Offer> findByProduct(Product product);
    List<Offer> findByProductCategory(ProductCategory productCategory);
    List<Offer> findByPriceEquals(double price);

}
