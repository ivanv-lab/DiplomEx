package diplom.ex.dbcrud.repositories;

import diplom.ex.dbcrud.models.Client;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface ClientRepository extends CrudRepository<Client, Long> {
    List<Client>findByFio(String fio);
    Client findById(long id);
}
