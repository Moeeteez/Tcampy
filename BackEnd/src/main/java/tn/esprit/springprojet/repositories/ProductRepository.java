package tn.esprit.springprojet.repositories ;

import oracle.jrockit.jfr.openmbean.ProducerDescriptorType;
import tn.esprit.springprojet.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository  extends JpaRepository<Product,Long> {

Product findBySku(String sku) ;
}