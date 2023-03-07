package tn.esprit.springprojet.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Data
@Builder
@Table(name = "CommandLine")
public class CommandLine implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="idCommandLine")
    @EmbeddedId
    private  CommandLineKey  id ;
    private  int quantityProds ;


    @ManyToOne
    @MapsId("idProduct")
    @JoinColumn(name = "idProduct",referencedColumnName = "idProduct",insertable = false,updatable = false)
    private  Product product;
    @ManyToOne
    @MapsId("idOrder")
    @JoinColumn(name = "idOrder",referencedColumnName = "idOrder",insertable = false,updatable = false)
    private  Order  order;
}
