package tcampy.pidev.Entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "Payement")
public class Payment implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idPayment;
    private double amount;
    @Enumerated(EnumType.STRING)
    private PaymentType paymentType;
    @Temporal(TemporalType.TIMESTAMP)
    private Date paymentDate;
    String customerId;
    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL)
    private User user;
    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL)
    private CommandLine commandLine;

}
