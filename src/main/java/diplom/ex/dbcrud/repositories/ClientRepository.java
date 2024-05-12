package diplom.ex.dbcrud.repositories;

import diplom.ex.dbcrud.models.Client;
import java.util.List;

import diplom.ex.dbcrud.models.PickPoint;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ClientRepository extends CrudRepository<Client, Long> {
    List<Client>findByFioContainingIgnoreCase(String fio);
    Client findById(long id);
//    @Query("select e from Client e where e.deleted=:deleted")
//    List<Client> findAllNotDeleted(@Param("deleted") boolean deleted);
}
