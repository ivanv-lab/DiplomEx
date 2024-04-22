package diplom.ex.dbcrud.dto.order;

import diplom.ex.dbcrud.dto.client.ClientDto;
import diplom.ex.dbcrud.dto.orderitem.OrderItemDto;
import diplom.ex.dbcrud.dto.pickpoint.PickPointDto;
import diplom.ex.dbcrud.models.Client;
import diplom.ex.dbcrud.models.PickPoint;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
@Getter
@Setter
public class OrderDto {
    private Long id;
    private PickPointDto pickPoint;
    private LocalDate date;
    private BigDecimal sum;
    private ClientDto client;
    private List<OrderItemDto> items;
}
