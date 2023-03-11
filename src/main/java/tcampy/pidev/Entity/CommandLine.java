package tcampy.pidev.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
@Table(name = "CommandLine")
public class CommandLine implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCommandLine")
    @EmbeddedId
    private CommandLineKey id;
    private int idCmdLine;
    private int quantityProds;
    private int loyaltyPointsEarned;
    private Double totalCmd = 0.0;


    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "commandLine")
    private Set<Product> products;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "commandLine")
    private Set<Sales> sales;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "commandLine")
    private Set<Rental> rentals;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "commandLine")
    private Set<Order> orders;
    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "LoyaltyPoints")
    private LoyaltyPoints LoyaltyPoints;

    public Double getPrixTotal() {
        return orders.stream()
                .mapToDouble(Order::getTotalPrice)
                .sum();
    }

    public void ajouterOrder(Order order) {
        orders.add(order);
        totalCmd = getPrixTotal();
    }

    public Double getTotalCmd() {
        return totalCmd;
    }

    @PrePersist
    public void beforePersist() {
        totalCmd = getPrixTotal();
        quantityProds = orders.stream()
                .mapToInt(Order::getTotalquantity)
                .sum();
    }
}


