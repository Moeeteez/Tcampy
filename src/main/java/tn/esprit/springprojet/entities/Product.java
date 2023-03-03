package tn.esprit.springprojet.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
@Table (name = "product")
//@Embeddable
public class Product implements  Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id")
    private long idProduct;
    private String sku ;
    private String name;
    private String description;
    private BigDecimal price;
    private String imageUrl;
    private boolean active;
    private int quantity;
    @JsonIgnore
    @ManyToOne
    private Product category;
}