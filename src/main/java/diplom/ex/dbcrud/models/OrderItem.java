package diplom.ex.dbcrud.models;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "order_list")
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private List<Order> order;
    @ManyToOne
    private List<Product> product;
    //Ссылка на product_id
    /**
     * Или лист Product
     * и ссылка от Order
     */
    private int number;
    private BigDecimal price;

    public OrderItem(List<Order> order, List<Product> product, int number, BigDecimal price) {
        this.order = order;
        this.product = product;
        this.number = number;
        this.price = price;
    }

    public String toString(){
        return String.format(
                "OrderItem[id="+id+", order="+order+", product="+
                        product+", number="+number+", price="+price+"]"
        );
    }

    public Long getId() {
        return id;
    }

    public List<Order> getOrder() {
        return order;
    }

    public List<Product> getProduct() {
        return product;
    }

    public int getNumber() {
        return number;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
