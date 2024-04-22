package diplom.ex.dbcrud.repositories;

import diplom.ex.dbcrud.models.PickPoint;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PickPointRepository extends CrudRepository<PickPoint, Long> {
    List<PickPoint> findByAddressStartingWithIgnoreCase(String address);
    PickPoint findById(long id);
}
