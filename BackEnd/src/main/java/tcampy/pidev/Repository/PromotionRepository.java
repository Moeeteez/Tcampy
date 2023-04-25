package tcampy.pidev.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tcampy.pidev.Entity.Promotion;


import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface PromotionRepository extends JpaRepository<Promotion, Long> {

        //List<Promotion> findBetwenDates(Date startDate, Date endDate);


    //List<Promotion> findByProductCategory(ProductCategory productCategory);


}
