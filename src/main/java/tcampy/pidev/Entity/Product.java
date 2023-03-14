package tcampy.pidev.Entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table (name = "product")
public class Product implements  Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idProduct")
    private long idProduct;
    @NotNull(message = "Product name is required.")
    @Basic(optional = false)
    private String name;
    private String type ;
    private String description;
    private double priceRental = 0.0;
    private double priceSale = 0.0;
    @Lob
    private byte[] images;
    private boolean active;
    private int quantity;
    private  int NbDaysForRental ;
    @Enumerated(EnumType.STRING)
    private OrderType  orderType;


    @JsonIgnore
    @ManyToOne
     CategoryProduct category;
    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL)
    @ToString.Exclude
    private Offer offer  ;
    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL)
    @ToString.Exclude
    private Promotion Promotion;
    @JsonIgnore
    @OneToOne
    private ImageProduct imageProduct ;

}