package tcampy.pidev.Entity;

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
    @Column(name ="idCommandLine")
    @EmbeddedId
    private  CommandLineKey  id ;
    private  int idCmdLine ;
    private  int quantityProds ;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "commandLine")
    private Set<Product> products ;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "commandLine")
    private Set<Sales> sales ;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "commandLine")
    private Set<Rental> rentals ;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "commandLine")
    private Set<Order> orders ;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "LoyaltyPoints")
    private LoyaltyPoints LoyaltyPoints ;
}
