package diplom.ex.dbcrud.dto.status;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@Schema(description = "Сущность обновления заказа")
public class StatusUpdateDto {
    @Schema(description = "Статус")
    private String name;
}
