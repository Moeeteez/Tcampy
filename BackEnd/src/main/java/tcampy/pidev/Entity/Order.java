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
    private long idOrder;

//    @JsonFormat(pattern = "dd/MM/yyyy")
//    private LocalDate dateCreated;

    private String orderFullName ;
    private String orderFullOrder ;
    private String orderContactNumber ;
    private String orderAlternateContactNumber ;
    private  String Status ;
    private Double orderAmount ;
    @OneToOne
    private  Product product ;
    @OneToOne
    private User user ;

    public Order(String orderFullName, String orderFullOrder, String orderContactNumber, String orderAlternateContactNumber, String status, Double orderAmount, Product product, User user, List<CommandLine> commandLines) {
        this.orderFullName = orderFullName;
        this.orderFullOrder = orderFullOrder;
        this.orderContactNumber = orderContactNumber;
        this.orderAlternateContactNumber = orderAlternateContactNumber;
        Status = status;
        this.orderAmount = orderAmount;
        this.product = product;
        this.user = user;
        CommandLines = commandLines;
    }

    public Order(String orderFullName, String orderFullOrder, String orderContactNumber, String orderAlternateContactNumber, String status, Double orderAmount) {
        this.orderFullName = orderFullName;
        this.orderFullOrder = orderFullOrder;
        this.orderContactNumber = orderContactNumber;
        this.orderAlternateContactNumber = orderAlternateContactNumber;
        Status = status;
        this.orderAmount = orderAmount;
    }

    public Order(String orderFullName, String orderFullOrder, String orderContactNumber, String orderAlternateContactNumber) {
        this.orderFullName = orderFullName;
        this.orderFullOrder = orderFullOrder;
        this.orderContactNumber = orderContactNumber;
        this.orderAlternateContactNumber = orderAlternateContactNumber;
    }

    @OneToMany(mappedBy = "pk.ordre")
    //@JoinColumn(name = "order_id") // nom de la colonne de clé étrangère dans la table enfant



    @Valid
    private List<CommandLine> CommandLines= new ArrayList<>() ;

    public Order(String fullName, String fullAddress, String contactNumber, String alternateContactNumber, String orderPlaced, double v, Product product, User user) {
    }

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
