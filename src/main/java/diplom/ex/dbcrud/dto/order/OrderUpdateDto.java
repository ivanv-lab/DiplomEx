package diplom.ex.dbcrud.dto.order;

import diplom.ex.dbcrud.dto.client.ClientDto;
import diplom.ex.dbcrud.dto.orderitem.OrderItemCreateDto;
import diplom.ex.dbcrud.dto.orderitem.OrderItemDto;
import diplom.ex.dbcrud.dto.orderitem.OrderItemUpdateDto;
import diplom.ex.dbcrud.dto.pickpoint.PickPointDto;
import diplom.ex.dbcrud.models.Client;
import diplom.ex.dbcrud.models.OrderItem;
import diplom.ex.dbcrud.models.OrderStatus;
import diplom.ex.dbcrud.models.PickPoint;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
@Getter
@Setter
@Schema(description = "Сущность изменения заказа")
public class OrderUpdateDto {
    @Schema(description = "Пункт выдачи")
    private PickPoint pickPoint;
    //private LocalDate date;
    @Schema(description = "Сумма")
    private BigDecimal sum;
    @Schema(description = "Статус")
    @Enumerated(EnumType.STRING)
    private OrderStatus status;
    @Schema(description = "Пункты заказа")
    private List<OrderItem> item;
//    @Schema(description = "")
//    private Client client;

    public List<OrderItem> getItem() {
        return item;
    }

    public void setItem(List<OrderItem> item) {
        this.item = item;
    }
}
