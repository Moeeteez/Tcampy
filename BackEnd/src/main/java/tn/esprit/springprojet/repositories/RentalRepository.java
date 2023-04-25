package tn.esprit.springprojet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.springprojet.entities.Product;
import tn.esprit.springprojet.entities.Rental;

import java.util.Date;
import java.util.List;

@Repository
public interface RentalRepository extends JpaRepository<Rental, Long> {
    List<Rental> findByStartDateLessThanEqualAndEndDateGreaterThanEqual(Date date1, Date date2);

    List<Rental> findByProduct(Product product);

    List<Rental> findByStartDate(Date date);

    List<Rental> findByDate(Date date);
    int countByProduct(Product product);

    @Query("SELECT SUM(r.price) FROM Rental r WHERE r.product = :product")
    Double getTotalPriceByProduct(@Param("product") Product product);
}
