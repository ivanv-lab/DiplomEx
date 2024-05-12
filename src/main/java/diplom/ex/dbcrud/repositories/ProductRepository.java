package diplom.ex.dbcrud.repositories;

import diplom.ex.dbcrud.models.PickPoint;
import diplom.ex.dbcrud.models.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.math.BigDecimal;

public interface ProductRepository extends CrudRepository<Product, Long> {
    List<Product> findByNameContainingIgnoreCase(String name);
    Product findById(long id);
    @Query("select e from Product e where e.deleted=:deleted")
    List<Product> findAllNotDeleted(@Param("deleted") boolean deleted);
}
