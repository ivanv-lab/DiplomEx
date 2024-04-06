package diplom.ex.dbcrud.models;

import jakarta.persistence.*;
import jdk.jfr.Enabled;

import java.math.BigDecimal;
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
}
