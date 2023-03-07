package tn.esprit.springprojet.entities;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Data
@Builder
@Table(name = "Order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="idOrder")
    private long idOrder;
    private String orderTrackingNumber;
    private int totalquantity ;
    private BigDecimal totalPrice ;
    private String status ;
    private Date dateCreated ;
    private Date lastUpdated ;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "order")
    private List<CommandLine> commandLines ;

}
