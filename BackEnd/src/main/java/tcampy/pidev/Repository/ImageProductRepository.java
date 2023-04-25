package tcampy.pidev.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tcampy.pidev.Entity.ImageProduct;

import java.util.Optional;

public interface ImageProductRepository extends JpaRepository<ImageProduct,Long> {
    Optional<ImageProduct> findByName(String fileName);

}
