package diplom.ex.dbcrud.dto.order;

import diplom.ex.dbcrud.dto.client.ClientDto;
import diplom.ex.dbcrud.dto.orderitem.OrderItemDto;
import diplom.ex.dbcrud.dto.pickpoint.PickPointDto;
import diplom.ex.dbcrud.models.Client;
import diplom.ex.dbcrud.models.OrderItem;
import diplom.ex.dbcrud.models.PickPoint;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
@Getter
@Setter
@Schema(description = "Сущность заказа")
public class OrderDto {
    @Schema(description = "Идентификатор")
    private Long id;
    @Schema(description = "Пункт выдачи")
    private PickPointDto pickPoint;
    @Schema(description = "Дата")
    private LocalDate date;
    @Schema(description = "Сумма")
    private BigDecimal sum;
    @Schema(description = "Клиент")
    private ClientDto client;
    @Schema(description = "Пункты заказа")
    private List<OrderItemDto> item;
}
