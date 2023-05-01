package tcampy.pidev.dao;


import org.springframework.data.repository.CrudRepository;
import tcampy.pidev.Entity.OrderDetail;
import tcampy.pidev.Entity.User;

import java.util.List;

public interface OrderDetailDao extends CrudRepository<OrderDetail, Integer> {
    public List<OrderDetail> findByUser(User user);

    public List<OrderDetail> findByOrderStatus(String status);
}
