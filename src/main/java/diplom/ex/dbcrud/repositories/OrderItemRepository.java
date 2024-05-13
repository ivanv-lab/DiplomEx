package diplom.ex.dbcrud.repositories;

import diplom.ex.dbcrud.models.OrderItem;
import diplom.ex.dbcrud.models.PickPoint;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderItemRepository extends CrudRepository<OrderItem, Long> {
    //List<OrderItem> findByOrderId(long orderId);
    OrderItem findById(long id);
    @Query("select e from OrderItem e where e.status=:status")
    List<OrderItem> findAllNotDeleted(@Param("status") String status);
}
