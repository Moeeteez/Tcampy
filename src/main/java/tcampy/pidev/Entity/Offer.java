package tcampy.pidev.Entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import javax.persistence.*;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
    public class Offer implements Serializable {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String name;
        private String description;
        @Column(name = "minimum_quantity")
        private Integer minimumQuantity;
        private long freeProduct ;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idProduct")
    private Product product;

    @OneToOne(mappedBy="offer")
    @ToString.Exclude
    private Product Product ;

}
