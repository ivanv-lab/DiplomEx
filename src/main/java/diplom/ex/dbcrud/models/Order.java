package diplom.ex.dbcrud.models;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //Ссылка на PickPoint
    @OneToMany
    private List<PickPoint> pickPoint;
    private LocalDate date;
    private BigDecimal sum;
    //Ссылка на Client
    @OneToOne
    private List<Client> client;
    //Подумать
    @OneToMany
    private List<OrderItem> item;

    public Order(List<PickPoint> pickPoint, LocalDate date, BigDecimal sum, List<Client> client,
                 List<OrderItem> item) {
        this.pickPoint = pickPoint;
        this.date = date;
        this.sum = sum;
        this.client = client;
        this.item = item;
    }

    public String toString(){
        return String.format(
                "Order[id="+id+", location="+pickPoint+
                        ", date="+date+", sum="+sum+", user="+client+", item="+item+"]"
        );
    }

    public List<PickPoint> getPickPoint() {
        return pickPoint;
    }

    public LocalDate getDate() {
        return date;
    }

    public BigDecimal getSum() {
        return sum;
    }

    public List<Client> getClient() {
        return client;
    }

    public List<OrderItem> getItem() {
        return item;
    }
}
