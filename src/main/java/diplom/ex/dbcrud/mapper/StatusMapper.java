package diplom.ex.dbcrud.mapper;

import diplom.ex.dbcrud.dto.client.ClientDto;
import diplom.ex.dbcrud.dto.status.StatusDto;
import diplom.ex.dbcrud.models.Client;
import diplom.ex.dbcrud.models.Status;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StatusMapper {
    StatusDto map(Status model);
    Status map(StatusDto dto);
}
