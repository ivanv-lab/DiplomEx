package diplom.ex.dbcrud.dto.order;

import diplom.ex.dbcrud.dto.status.StatusDto;
import diplom.ex.dbcrud.models.Client;
import diplom.ex.dbcrud.models.PickPoint;
import diplom.ex.dbcrud.models.Status;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Getter
@Setter
@Schema(description = "Сущность создания заказа")
public class OrderCreateDto {
    @Schema(description = "Пункт выдачи")
    private PickPoint  pickPoint;
    @Schema(description = "Статус заказа")
    private StatusDto status;
    @Schema(description = "Дата создания")
    private LocalDate date;
    @Schema(description = "Сумма")
    private BigDecimal sum;
    @Schema(description = "Клиент")
    private Client client;
}
