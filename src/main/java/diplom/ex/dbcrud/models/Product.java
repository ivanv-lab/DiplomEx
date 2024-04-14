package diplom.ex.dbcrud.models;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int number;
    private BigDecimal price;
    @Transient
    @OneToMany(mappedBy = "product")
    private List<OrderItem> orderItemList=new ArrayList<>();
    public Product(){}
    public Product(String name, int number, BigDecimal price) {
        this.name = name;
        this.number = number;
        this.price = price;
    }

    public String toString(){
        return String.format(
                "Product[id="+id+", name="+name+", number="+number+
                        ", price="+price+"]"
        );
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public List<OrderItem> getOrderItemList() {
        return orderItemList;
    }

    public void setOrderItemList(List<OrderItem> orderItemList) {
        this.orderItemList = orderItemList;
    }
}
