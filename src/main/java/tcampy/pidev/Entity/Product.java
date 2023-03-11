package tcampy.pidev.Entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import javax.persistence.*;
import java.io.Serializable;
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
    private String sku;
    private String name;
    private String type ;
    private String description;
    private double priceRental = 0.0;
    private double priceSale = 0.0;
    private String imageUrl;
    private boolean active;
    private int quantity;

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
    @ManyToOne
    private CommandLine commandLine;

}