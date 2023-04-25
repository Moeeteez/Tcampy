        package tcampy.pidev.Entity;

        import com.fasterxml.jackson.annotation.JsonBackReference;
        import com.fasterxml.jackson.annotation.JsonIdentityInfo;
        import com.fasterxml.jackson.annotation.ObjectIdGenerators;
        import lombok.EqualsAndHashCode;
        import lombok.Getter;
        import lombok.NoArgsConstructor;
        import lombok.Setter;

        import javax.persistence.*;
        import java.io.Serializable;
        @Embeddable
        @NoArgsConstructor
        @EqualsAndHashCode
        @Getter
        @Setter
        public class CommandLineKey implements Serializable {
        //    @Column(name ="idProduct")
        //    private  long idProduct ;
        //    @Column(name ="idOrder")
        //    private  long idOrder ;
        //
        //    public CommandLineKey(long idProduct, int idOrder) {
        //        this.idOrder = idOrder ;
        //        this.idProduct = idProduct ;
        //    }


                //@JsonBackReference
                @ManyToOne(optional = false)
                @JoinColumn(name = "order_id")
                private Order ordre;

                @ManyToOne(optional = false)
                @JoinColumn(name = "product_id")
                private Product product;


        }
