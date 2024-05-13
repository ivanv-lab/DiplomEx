package diplom.ex.dbcrud.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Getter
@Setter
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int number;
    private BigDecimal price;
    private String status;
    @Transient
    @OneToMany(mappedBy = "product")
    private List<OrderItem> orderItemList=new ArrayList<>();
    public Product(){}
    public Product(String name, int number, BigDecimal price,String status) {
        this.name = name;
        this.number = number;
        this.price = price;
        this.status=status;
    }

    public String toString(){
        return String.format(
                "Product[id="+id+", name="+name+", number="+number+
                        ", price="+price+", deleted="+status+"]"
        );
    }
}
