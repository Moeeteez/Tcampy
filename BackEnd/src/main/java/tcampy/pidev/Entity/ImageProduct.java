package tcampy.pidev.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ImageProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idImage;
    private String name;
    private String type;
    @Lob
    @Column(length =5000000 )
    private byte[] picByte;
//    @JsonIgnore
//    @OneToOne(mappedBy = "imageProduct",cascade = CascadeType.ALL)
//    private Product product ;

    public ImageProduct(String name, String type, byte[] picByte) {
        this.name = name;
        this.type = type;
        this.picByte = picByte;
    }
}
