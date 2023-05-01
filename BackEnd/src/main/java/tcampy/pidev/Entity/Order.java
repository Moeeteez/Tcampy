package tcampy.pidev.Entity;

import lombok.*;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table (name = "order_details")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer orderId;

//    @JsonFormat(pattern = "dd/MM/yyyy")
//    private LocalDate dateCreated;

    private String orderFullName;
    private String orderFullOrder;
    private String orderContactNumber;
    private String orderAlternateContactNumber;
    private String orderStatus;
    private Double orderAmount;
    @OneToOne
    private Product product;
    @OneToOne
    private User user;

//    public Order(String orderFullName, String orderFullOrder, String orderContactNumber, String orderAlternateContactNumber, String status, Double orderAmount, Product product, User user, List<CommandLine> commandLines) {
//        this.orderFullName = orderFullName;
//        this.orderFullOrder = orderFullOrder;
//        this.orderContactNumber = orderContactNumber;
//        this.orderAlternateContactNumber = orderAlternateContactNumber;
//        Status = status;
//        this.orderAmount = orderAmount;
//        this.product = product;
//        this.user = user;
//        CommandLines = commandLines;
//    }
//
//    public Order(String orderFullName, String orderFullOrder, String orderContactNumber, String orderAlternateContactNumber, String status, Double orderAmount) {
//        this.orderFullName = orderFullName;
//        this.orderFullOrder = orderFullOrder;
//        this.orderContactNumber = orderContactNumber;
//        this.orderAlternateContactNumber = orderAlternateContactNumber;
//        orderStatus = orderstatus;
//        this.orderAmount = orderAmount;
//    }

//    public Order(String orderFullName, String orderFullOrder, String orderContactNumber, String orderAlternateContactNumber) {
//        this.orderFullName = orderFullName;
//        this.orderFullOrder = orderFullOrder;
//        this.orderContactNumber = orderContactNumber;
//        this.orderAlternateContactNumber = orderAlternateContactNumber;
//    }
//
//    public OrderDetail(String orderFullName, String orderFullOrder, String orderContactNumber, String orderAlternateContactNumber, String orderStatus, Double orderAmount, Product product, User user) {
//        this.orderFullName = orderFullName;
//        this.orderFullOrder = orderFullOrder;
//        this.orderContactNumber = orderContactNumber;
//        this.orderAlternateContactNumber = orderAlternateContactNumber;
//        this.orderStatus = orderStatus;
//        this.orderAmount = orderAmount;
//        this.product = product;
//        this.user = user;
//
//    }


//    @OneToMany(mappedBy = "pk.ordre")
//    //@JoinColumn(name = "order_id") // nom de la colonne de clé étrangère dans la table enfant
//
//
//
//    @Valid
//    private List<CommandLine> CommandLines= new ArrayList<>() ;
//
//    public Order(String fullName, String fullAddress, String contactNumber, String alternateContactNumber, String orderPlaced, double v, Product product, User user) {
//    }
//
//    //    @Transient
////    public Double getTotalOrderPrice() {
////        double sum = 0D;
////        List<CommandLine> CommandLines = getCommandLines();
////        for (CommandLine op : CommandLines) {
////            sum += op.getTotalPrice();
////        }
////        return sum;
////    }
//    @Transient
//    public Double getTotalOrderPrice() {
//        double sum = 0D;
//        List<CommandLine> commandLines = getCommandLines();
//        for (CommandLine op : commandLines) {
//            sum += op.getTotalPrice();
//        }
//        if (promotion != null) {
//            double discountedPrice = sum;
//            if (promotion.getPromotionType() == PromotionType.HAPPY_DAYS) {
//                int percentageDiscount = promotion.getPercentageDiscount();
//                discountedPrice *= (100 - percentageDiscount) / 100.0;
//            } else if (promotion.getPromotionType() == PromotionType.BLACK_FRIDAY) {
//                int percentageDiscount = promotion.getPercentageDiscount();
//                discountedPrice *= (100 - percentageDiscount) / 100.0;
//            } else if (promotion.getPromotionType() == PromotionType.HAPPY_HOUR) {
//                LocalDate currentDate = LocalDate.now();
//                if (currentDate.isAfter(promotion.getStartDate()) && currentDate.isBefore(promotion.getEndDate())) {
//                    int percentageDiscount = promotion.getPercentageDiscount();
//                    discountedPrice *= (100 - percentageDiscount) / 100.0;
//                }
//            }
//            sum = discountedPrice;
//        }
//        return sum;
//    }
//
//    @Transient
//    public int getNumberOfProducts() {
//        return this.CommandLines.size();
//    }
//
//    @JsonIgnore
//    @OneToOne(cascade = CascadeType.ALL)
//    @ToString.Exclude
//    private Promotion promotion;
//
//}
}