package tcampy.pidev.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tcampy.pidev.Entity.Payment;

import java.util.Date;
import java.util.List;

@Repository
public interface PaymentRepository extends JpaRepository<Payment,Long> {

    List<Payment> findByPaymentDate(Date date);

}
