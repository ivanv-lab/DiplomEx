package diplom.ex.dbcrud.repositories;

import diplom.ex.dbcrud.models.Order;
import jakarta.persistence.Entity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import java.time.LocalDate;
import java.util.List;

public interface OrderRepository extends CrudRepository<Order,Long> {
    List<Order> findByDate(LocalDate date);
    Order findById(long id);
}
