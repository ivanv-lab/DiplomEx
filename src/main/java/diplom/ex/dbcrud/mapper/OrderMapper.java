package diplom.ex.dbcrud.mapper;

import diplom.ex.dbcrud.dto.order.OrderCreateDto;
import diplom.ex.dbcrud.dto.order.OrderDto;
import diplom.ex.dbcrud.dto.order.OrderUpdateDto;
import diplom.ex.dbcrud.models.Order;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    Order map(OrderCreateDto dto);
    OrderDto map(Order model);
    void update(OrderUpdateDto dto, @MappingTarget Order model);
    List<OrderDto> all(List<Order> model);
}
