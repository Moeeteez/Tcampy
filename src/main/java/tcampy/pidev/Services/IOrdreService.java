package tcampy.pidev.Services;

import org.springframework.validation.annotation.Validated;
import tcampy.pidev.Entity.Order ;
import tcampy.pidev.Entity.Product;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@Validated

public interface IOrdreService {

    @NotNull List<Order> getAllOrders();
    //Order create(@NotNull(message = "The order cannot be null.") @Valid Order order);
    //void update(@NotNull(message = "The order cannot be null.") @Valid Order order);


   public void update(Order order);
   public Order getOrderById(int id);
     public Order create(Order order);
 void deleteOrderById(int Id);
    public void assignProductToOrder(int orderId, long productId,int quantity) ;
//
//    public Iterable<Order> getAllOrders() ;
//    // public Order createOrder(List<CommandLineDTO> commandLineDtos) ;
//public Order createOrder(List<Product> products) ;
}
