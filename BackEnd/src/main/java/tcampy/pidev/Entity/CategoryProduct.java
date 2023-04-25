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
@Builder

public class CategoryProduct implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id ;
    private String categoryName ;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "category" ,orphanRemoval =false)
    private Set<Product> products ;

}

