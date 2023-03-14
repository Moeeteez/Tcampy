package tcampy.pidev.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import javax.validation.Valid;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "OrderCommand")
public class Order implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idOrder;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dateCreated;

//    @JsonIgnore
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "order")
//    private List<CommandLine> commandLines;
  //  @JsonManagedReference
    @OneToMany(mappedBy = "pk.ordre")
    //@JoinColumn(name = "order_id") // nom de la colonne de clé étrangère dans la table enfant

    @Valid
    private List<CommandLine> CommandLines= new ArrayList<>() ;
    @Transient
    public Double getTotalOrderPrice() {
        double sum = 0D;
        List<CommandLine> CommandLines = getCommandLines();
        for (CommandLine op : CommandLines) {
            sum += op.getTotalPrice();
        }
        return sum;
    }
    @Transient
    public int getNumberOfProducts() {
        return this.CommandLines.size();
    }

}
