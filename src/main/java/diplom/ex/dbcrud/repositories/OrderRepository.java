package diplom.ex.dbcrud.repositories;

import diplom.ex.dbcrud.models.Order;
import diplom.ex.dbcrud.models.OrderItem;
import jakarta.persistence.Entity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface OrderRepository extends CrudRepository<Order,Long> {
    List<Order> findByDate(LocalDate date);
    @Query(value = "select o from Order o inner join OrderItem oi on o.id=oi.order.id where o.id=:id")
    Order findOrderAndOrderItemByOrderId(@Param("id")long id);
}
