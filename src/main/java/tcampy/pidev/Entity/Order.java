package tcampy.pidev.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "OrderCommand")
public class Order implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idOrder;
    private String orderTrackingNumber;
    private int totalquantity ;
    private double totalPrice ;
    private String status ;

    @PrePersist
    public void calculateTotalPrice() {
        double totalPrice = 0;
        for (Product product : commandLine.getProducts()) {
            totalPrice += product.getPriceSale() * product.getQuantity() +product.getPriceRental() * product.getQuantity();
        }
        setTotalPrice(totalPrice);
    }
    @JsonIgnore
    @ManyToOne
    private CommandLine commandLine;
}
