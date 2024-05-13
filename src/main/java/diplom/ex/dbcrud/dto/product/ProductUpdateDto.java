package diplom.ex.dbcrud.dto.product;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Data
@Getter
@Setter
@Schema(description = "Сущность изменения товара")
public class ProductUpdateDto {
    @Schema(description = "Наименование")
    private String name;
    @Schema(description = "Количество")
    private int number;
    @Schema(description = "Цена")
    private BigDecimal price;
    @Schema(description = "Статус (Deleted, No status, Active)")
    private String status;
}
