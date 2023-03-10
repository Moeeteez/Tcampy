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
    private String description;
    private double priceRental;
    private double priceSale;
    private String imageUrl;
    private boolean active;
    private int quantity;
    @ManyToOne
    private CategoryProduct category;

    @OneToOne(cascade = CascadeType.ALL)
    @ToString.Exclude
    private Offer offer  ;

    @OneToOne(cascade = CascadeType.ALL)
    @ToString.Exclude
    private Promotion Promotion;

    @ManyToOne
    private CommandLine commandLine;

}