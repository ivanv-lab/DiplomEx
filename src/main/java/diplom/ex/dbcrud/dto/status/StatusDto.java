package diplom.ex.dbcrud.dto.status;

import io.swagger.v3.oas.annotations.media.Schema;
import jdk.jfr.Description;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@Schema(description = "Сущность статуса заказа")
public class StatusDto {
    @Schema(description = "Идентификатор")
    private int id;
    @Schema(description = "Статус")
    private String name;
}
