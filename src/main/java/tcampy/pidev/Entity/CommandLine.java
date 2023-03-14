package tcampy.pidev.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Table(name = "CommandLine")
public class CommandLine implements Serializable {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Column(name = "idCommandLine")
    @EmbeddedId
    @JsonIgnore
    private CommandLineKey pk;
    @Column(nullable = false)
    private int quantityProds;
//
//
//    public CommandLine(Order order, Product product, Integer quantity) {
//        pk = new CommandLineKey();
//        pk.setOrdre(order);
//        pk.setProduct(product);
//        this.quantityProds = quantity;

    @Transient
    public Product getProduct() {
        return this.pk.getProduct();
    }

    @Transient
    public Double getTotalPrice() {
        return getProduct().getPriceRental() * getQuantityProds() + getProduct().getPriceSale() * getQuantityProds();
    }

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "commandLine")
    private Set<Sales> sales;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "commandLine")
    private Set<Rental> rentals;
}
//    @JsonIgnore
//    @ManyToOne

//    @JoinColumn(name = "idOrder", referencedColumnName = "idOrder", insertable = false, updatable = false)
//    private Order order;
//    @JsonIgnore
//    @ManyToOne
//    @JoinColumn(name = "idProduct", referencedColumnName = "idProduct", insertable = false, updatable = false)
//    private Product product;




