package tcampy.pidev.Entity;


import lombok.*;
import tcampy.pidev.Entity.PromotionType;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
@Entity
    @Table(name = "promotions")
    public class Promotion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private LocalDate StartDate ;
    @Column(nullable = false)
    private LocalDate EndDate ;
    @Enumerated(EnumType.STRING)
    private PromotionType promotionType;

//    @OneToMany(mappedBy = "promotion", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<Product> products = new ArrayList<>();
//    @Column(nullable = false)
//    private int percentageDiscount;

}
