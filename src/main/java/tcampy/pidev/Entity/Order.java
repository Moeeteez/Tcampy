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
//    @Transient
//    public Double getTotalOrderPrice() {
//        double sum = 0D;
//        List<CommandLine> CommandLines = getCommandLines();
//        for (CommandLine op : CommandLines) {
//            sum += op.getTotalPrice();
//        }
//        return sum;
//    }

    @Transient
    public Double getTotalOrderPrice() {
        double sum = 0D;
        List<CommandLine> commandLines = getCommandLines();
        for (CommandLine op : commandLines) {
            sum += op.getTotalPrice();
        }

        if (promotion != null) {
            double discountedPrice = sum;
            if (promotion.getPromotionType() == PromotionType.HAPPY_DAYS) {
                int percentageDiscount = promotion.getPercentageDiscount();
                discountedPrice *= (100 - percentageDiscount) / 100.0;
            } else if (promotion.getPromotionType() == PromotionType.BLACK_FRIDAY) {
                int percentageDiscount = promotion.getPercentageDiscount();
                discountedPrice *= (100 - percentageDiscount) / 100.0;
            } else if (promotion.getPromotionType() == PromotionType.HAPPY_HOUR) {
                LocalDate currentDate = LocalDate.now();
                if (currentDate.isAfter(promotion.getStartDate()) && currentDate.isBefore(promotion.getEndDate())) {
                    int percentageDiscount = promotion.getPercentageDiscount();
                    discountedPrice *= (100 - percentageDiscount) / 100.0;
                }

            }
            sum = discountedPrice;
        }

        return sum;
    }

    @Transient
    public int getNumberOfProducts() {
        return this.CommandLines.size();
    }

    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL)
    @ToString.Exclude
    private Promotion promotion;

}
