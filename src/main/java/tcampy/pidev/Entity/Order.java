package tcampy.pidev.Entity;

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
    private LocalDate dateCreated ;
    private LocalDate lastUpdated ;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "order")
    private List<CommandLine> commandLines ;

}
