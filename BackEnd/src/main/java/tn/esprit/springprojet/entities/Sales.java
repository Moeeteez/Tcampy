package tn.esprit.springprojet.entities;

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
@Data
@Builder
@Table(name = "sales")
public class Sales implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private int quantity;

    @Column(nullable = false)
    private double price;

    @Column(nullable = false)
    private LocalDateTime saleDate;

    @ManyToOne
    @JoinColumn(name = "idProduct", nullable = false)
    private Product product;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "client_id")
//    private Client client;

    @OneToMany(mappedBy = "sales", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Payment> payments ;
    @PrePersist
    protected void onCreate() {
        saleDate = LocalDateTime.now();
    }
}
