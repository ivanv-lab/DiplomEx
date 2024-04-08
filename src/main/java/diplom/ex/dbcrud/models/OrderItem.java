package diplom.ex.dbcrud.models;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "order_list")
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int number;
    private BigDecimal price;
    @ManyToOne
    @JoinColumn(name = "order_id")
    private List<Order> order=new ArrayList<>();
    @ManyToOne
    @JoinColumn(name = "product_id")
    private List<Product> product=new ArrayList<>();
    public OrderItem(){}

    public OrderItem(Order order,Product product, int number, BigDecimal price) {
        //this.order = order;
        //this.product = product;
        this.order.add(order);
        this.product.add(product);
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
    //Пробничек

    public void setId(Long id) {
        this.id = id;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setOrder(Order order) {
        this.order.add(order);
    }

    public void setProduct(Product product) {
        this.product.add(product);
    }
}
