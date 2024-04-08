package diplom.ex.dbcrud.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fio;
    private String email;
    private String phone;
@OneToMany(mappedBy = "client")
    private List<Order> order=new ArrayList<>();
    public Client(){}
    public Client(String fio, String email, String phone) {
        this.fio = fio;
        this.email = email;
        this.phone = phone;
    }

    public String toString(){
        return String.format(
                "Client[id="+id+", FIO="+fio+", email="+email+
                        ", phone="+phone+"]"
        );
    }

    public Long getId() {
        return id;
    }

    public String getFio() {
        return fio;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }
}
