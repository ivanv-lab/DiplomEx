package diplom.ex.dbcrud.repositories;

import diplom.ex.dbcrud.models.Product;
import org.springframework.data.repository.CrudRepository;
import java.util.List;
import java.math.BigDecimal;

public interface ProductRepository extends CrudRepository<Product, Long> {
    List<Product> findByPrice(BigDecimal price);
    Product findById(long id);
}
