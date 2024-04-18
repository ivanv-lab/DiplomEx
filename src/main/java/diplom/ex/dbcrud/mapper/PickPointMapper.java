package diplom.ex.dbcrud.mapper;

import diplom.ex.dbcrud.dto.pickpoint.PickPointCreateDto;
import diplom.ex.dbcrud.dto.pickpoint.PickPointDto;
import diplom.ex.dbcrud.dto.pickpoint.PickPointUpdateDto;
import diplom.ex.dbcrud.models.PickPoint;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PickPointMapper {
    PickPoint map(PickPointCreateDto dto);
    PickPointDto map(PickPoint model);
    void update(PickPointUpdateDto dto, @MappingTarget PickPoint model);
    List<PickPointDto> all(List<PickPoint> model);
}
