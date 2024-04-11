package diplom.ex.dbcrud.repositories;

import diplom.ex.dbcrud.models.OrderItem;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderItemRepository extends CrudRepository<OrderItem, Long> {
    List<OrderItem> findByOrderId(long orderId);
    List<OrderItem> findByProductId(long productId);
    OrderItem findById(long id);
}
