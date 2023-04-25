package tn.esprit.springprojet.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Data
@Builder
@Table (name = "product")
//@Embeddable
public class Product implements  Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="idProduct")
    private long idProduct;
    private String sku ;
    private String name;
    private String description;
    private double priceRental;
    private double priceSale;
    private String imageUrl;
    private boolean active;
    private int quantity;
    @JsonIgnore
    @ManyToOne
    private Product category;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "product")
    private List<CommandLine> commandLines ;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "product")
    private List<Sales> ventes ;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Rental> locations ;


    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Offer> offers ;
    @ManyToOne
    private Promotion promotion;
}
