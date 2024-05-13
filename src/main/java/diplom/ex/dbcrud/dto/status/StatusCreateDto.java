package diplom.ex.dbcrud.dto.status;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@Schema(description = "Сущность создания статуса заказа")
public class StatusCreateDto {
    @Schema(description = "Статус")
    private String name;
}
