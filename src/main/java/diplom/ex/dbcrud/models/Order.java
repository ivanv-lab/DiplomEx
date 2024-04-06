package diplom.ex.dbcrud.models;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //Ссылка на PickPoint
    @OneToMany
    private List<PickPoint> pickPoint=new ArrayList<>();
    private LocalDate date;
    private BigDecimal sum;
    //Ссылка на Client
    @ManyToOne
    private List<Client> client=new ArrayList<>();
    //Подумать
    @OneToMany
    private List<OrderItem> item=new ArrayList<>();
    //Пробничек
    public Order(){}

    public Order(PickPoint pickPoint, LocalDate date, BigDecimal sum, Client client,
                 OrderItem item) {
        //this.pickPoint = pickPoint;
        this.pickPoint.add(pickPoint);
        this.date = date;
        this.sum = sum;
        //this.client = client;
        //this.item = item;
        this.client.add(client);
        this.item.add(item);
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

    //Пробничек

    public void setId(Long id) {
        this.id = id;
    }

    public void setPickPoint(PickPoint pickPoint) {
        this.pickPoint.add(pickPoint);
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setSum(BigDecimal sum) {
        this.sum = sum;
    }

    public void setClient(Client client) {
        this.client.add(client);
    }

    public void setItem(OrderItem item) {
        this.item.add(item);
    }
}
