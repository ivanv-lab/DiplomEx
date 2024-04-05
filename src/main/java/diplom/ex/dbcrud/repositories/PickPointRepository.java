package diplom.ex.dbcrud.repositories;

import diplom.ex.dbcrud.models.PickPoint;
import org.springframework.data.repository.CrudRepository;

public interface PickPointRepository extends CrudRepository<PickPoint, Long> {
    PickPoint findByAddress(String address);
    PickPoint findById(long id);
}
