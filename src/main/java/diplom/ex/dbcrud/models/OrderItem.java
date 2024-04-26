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
@Table(name = "order_list")
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int number;
    private BigDecimal price;
    @ManyToOne(targetEntity = Order.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "order_id")
    private Order order;
    @ManyToOne(targetEntity = Product.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id")
    private Product product;
    public OrderItem(){}

    public OrderItem(Order order,Product product, int number, BigDecimal price) {
        this.order=order;
        this.product=product;
        this.number = number;
        this.price = price;
    }
    public String toString(){
        return String.format(
                "OrderItem[id="+id+", order="+order+", product="+
                        product+", number="+number+", price="+price+"]"
        );
    }
}
