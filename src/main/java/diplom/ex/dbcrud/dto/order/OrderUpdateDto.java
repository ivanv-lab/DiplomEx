package diplom.ex.dbcrud.dto.order;

import diplom.ex.dbcrud.dto.client.ClientDto;
import diplom.ex.dbcrud.dto.pickpoint.PickPointDto;
import diplom.ex.dbcrud.models.Client;
import diplom.ex.dbcrud.models.PickPoint;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

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
//    @Schema(description = "")
//    private Client client;
}
