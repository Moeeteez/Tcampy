package tcampy.pidev.Entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "rentals")
    public class Rental implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private int quantity;
    @Column(nullable = false)
    private double price;
    private boolean rentaled = false ;
    @Column(nullable = false)
    private LocalDateTime rentalDate;
    @Column(nullable = false)
    private LocalDateTime returnDate;


//    @OneToMany(mappedBy = "rental", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<Payment> payments ;
//@ManyToOne
//@JoinColumn(name = "iProduct", nullable = false)
//private Product product;
}

