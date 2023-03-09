package tcampy.pidev.Entity;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
@Embeddable
@NoArgsConstructor
@EqualsAndHashCode
public class CommandLineKey implements Serializable {
    @Column(name ="idProduct")
    private  long idProduct ;
    @Column(name ="idOrder")
    private  long idOrder ;
}
