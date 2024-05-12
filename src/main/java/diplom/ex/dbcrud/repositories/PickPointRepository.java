package diplom.ex.dbcrud.repositories;

import diplom.ex.dbcrud.models.PickPoint;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PickPointRepository extends CrudRepository<PickPoint, Long> {
    List<PickPoint>  findByAddressContainingIgnoreCase(String address);
    PickPoint findById(long id);
    @Query("select e from PickPoint e where e.deleted=:deleted")
    List<PickPoint> findAllNotDeleted(@Param("deleted") boolean deleted);
}
