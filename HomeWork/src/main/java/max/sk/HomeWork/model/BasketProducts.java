package max.sk.HomeWork.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import max.sk.HomeWork.dto.ProductDTO;
import org.hibernate.annotations.CreationTimestamp;
import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "basket")
@Data
@NoArgsConstructor
public class BasketProducts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    //@ManyToMany
    @Column(name = "id_product")
    private Long idProduct;

    @Column(name = "time_add")
    @CreationTimestamp
    private Date timeAdd;



    public BasketProducts(ProductDTO productDTO){
        this.idProduct = productDTO.getId();
        this.timeAdd = new Date();
    }

}
