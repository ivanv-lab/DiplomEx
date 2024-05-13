package diplom.ex.dbcrud.dto.order;

import diplom.ex.dbcrud.dto.status.StatusDto;
import diplom.ex.dbcrud.models.OrderItem;
import diplom.ex.dbcrud.models.PickPoint;
import diplom.ex.dbcrud.models.Status;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Data
@Getter
@Setter
@Schema(description = "Сущность изменения заказа")
public class OrderUpdateDto {
    @Schema(description = "Статус заказа (1-Готов, 2-Завершен, 3-Ожидается, 4-Отменен)")
    private Status status;
    @Schema(description = "Пункт выдачи")
    private PickPoint pickPoint;
    //private LocalDate date;
    @Schema(description = "Сумма")
    private BigDecimal sum;
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
