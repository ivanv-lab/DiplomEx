package diplom.ex.dbcrud.mapper;

import diplom.ex.dbcrud.dto.client.ClientCreateDto;
import diplom.ex.dbcrud.dto.client.ClientDto;
import diplom.ex.dbcrud.dto.client.ClientUpdateDto;
import diplom.ex.dbcrud.models.Client;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClientMapper {
    Client map(ClientCreateDto dto);
    ClientDto map(Client model);
    void update(ClientUpdateDto dto, @MappingTarget Client model);
    List<ClientDto> all(List<Client> model);
}
