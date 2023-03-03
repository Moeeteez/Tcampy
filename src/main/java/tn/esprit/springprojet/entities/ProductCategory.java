package tn.esprit.springprojet.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder

public class ProductCategory implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id ;
    private String categoryName ;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "category")
    private Set<Product> products ;

}
