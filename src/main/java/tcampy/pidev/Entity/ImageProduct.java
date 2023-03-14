package tcampy.pidev.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ImageProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idImage;
    private String name;
    private String type;
    @Lob
    @Column(length =10000 )
    private byte[] imageProduct;
    @JsonIgnore
    @OneToOne(mappedBy = "imageProduct",cascade = CascadeType.ALL)
    private Product product ;
}
