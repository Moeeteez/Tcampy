package tcampy.pidev.dao;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tcampy.pidev.Entity.Product;

import java.util.List;

@Repository
public interface ProductDao extends CrudRepository<Product, Integer> {
    public List<Product> findAll(Pageable pageable);
//
//    public List<Product> findByNameContainingIgnoreCaseOrProductDescriptionContainingIgnoreCase(
//            String key1, String key2, Pageable pageable
//    );
}
