package diplom.ex.dbcrud.dto.pickpoint;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@Schema(description = "Сущность создания пункта выдачи")
public class PickPointCreateDto {
    @Schema(description = "Наименование")
    private String name;
    @Schema(description = "Адрес")
    private String address;
    @Schema(description = "Удален")
    private boolean deleted;
}
