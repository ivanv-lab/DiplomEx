package diplom.ex.dbcrud.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Getter
@Setter
@Table(name = "client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fio;
    private String email;
    private String phone;
    private boolean deleted;

    public Client(){}
    public Client(String fio, String email, String phone, boolean deleted) {
        this.fio = fio;
        this.email = email;
        this.phone = phone;
        this.deleted=deleted;
    }

    public String toString(){
        return String.format(
                "Client[id="+id+", FIO="+fio+", email="+email+
                        ", phone="+phone+", deleted="+deleted+"]"
        );
    }
}
