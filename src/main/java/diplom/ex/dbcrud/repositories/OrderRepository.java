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
//    @Query(value = "select o from Order o inner join OrderItem oi on o.id=oi.order.id where o.id=:id")
    @Query(value = "select \"order\".id, \"order\".pick_point_id,\"order\".status_id, \"order\".date,\n" +
            "\"order\".sum, \"order\".client_id, order_list.id as \"items\"\n" +
            "from \"order\"\n" +
            "inner join order_list ON order_list.order_id = \"order\".id\n" +
            "where \"order\".id=:id", nativeQuery = true)
    Order findOrderAndOrderItemByOrderId(@Param("id") long id);
}
