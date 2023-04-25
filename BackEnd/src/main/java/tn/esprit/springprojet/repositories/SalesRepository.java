package tn.esprit.springprojet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.springprojet.entities.Product;
import tn.esprit.springprojet.entities.ProductCategory;
import tn.esprit.springprojet.entities.Sales;

import java.util.Date;
import java.util.List;
@Repository
public interface SalesRepository extends JpaRepository<Sales,Long> {


    List<Sales> findByProduct(Product product);

    List<Sales> findBySaleDate(Date date);

    int countByProduct(Product product);

    @Query("SELECT SUM(s.price) FROM Sales s WHERE s.product = :product")
    double sumPrixByProduct(@Param("product") Product product);
}
