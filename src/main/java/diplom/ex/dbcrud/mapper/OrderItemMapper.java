package diplom.ex.dbcrud.mapper;

import diplom.ex.dbcrud.dto.orderitem.OrderItemCreateDto;
import diplom.ex.dbcrud.dto.orderitem.OrderItemDto;
import diplom.ex.dbcrud.dto.orderitem.OrderItemUpdateDto;
import diplom.ex.dbcrud.models.OrderItem;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderItemMapper {
    OrderItem map(OrderItemCreateDto dto);
    OrderItemDto map(OrderItem model);
    void update(OrderItemUpdateDto dto, @MappingTarget OrderItem model);
    List<OrderItemDto> all(List<OrderItem> model);
}
