package diplom.ex.dbcrud.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

@Entity
@Data
@Getter
@Setter
@Table(name = "\""+"order"+"\"")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(targetEntity = PickPoint.class,fetch = FetchType.EAGER)
    @JoinColumn(name = "pickPoint_id")
    private PickPoint pickPoint;
    private LocalDate date;
    private BigDecimal sum;
    @ManyToOne(targetEntity = Client.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "client_id")
    private Client client;
    @OneToMany(mappedBy = "order", fetch = FetchType.EAGER)
    private List<OrderItem> item=new ArrayList<>();
    public Order(){}

    public Order(PickPoint pickPoint, LocalDate date, BigDecimal sum, Client client,
                 OrderItem item) {
        this.pickPoint=pickPoint;
        this.date = date;
        this.sum = sum;
        this.client=client;
        this.item.add(item);
    }

    public String toString(){
        return String.format(
                "Order[id="+id+", location="+pickPoint+
                        ", date="+date+", sum="+sum+", user="+client+", item="+item+"]"
        );
    }

    public List<OrderItem> getItem() {
        return item;
    }

    public void setItem(List<OrderItem> item) {
        this.item = item;
    }

    public Long getId() {
        return id;
    }
}
