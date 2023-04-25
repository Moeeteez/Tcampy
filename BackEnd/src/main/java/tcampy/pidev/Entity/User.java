package tcampy.pidev.Entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.*;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
    @OneToOne
   private LoyaltyPoints loyaltyPoints;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Order> orders ;
}
