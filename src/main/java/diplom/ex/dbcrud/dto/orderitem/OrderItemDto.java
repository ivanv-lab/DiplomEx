package diplom.ex.dbcrud.dto.orderitem;

import diplom.ex.dbcrud.dto.order.OrderDto;
import diplom.ex.dbcrud.dto.product.ProductDto;
import diplom.ex.dbcrud.models.Order;
import diplom.ex.dbcrud.models.Product;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Data
@Getter
@Setter
@Schema(description = "Сущность пункта заказа")
public class OrderItemDto {
    @Schema(description = "Идентификатор")
    private Long id;
    @Schema(description = "Количество товара")
    private int number;
    @Schema(description = "Цена товара")
    private BigDecimal price;
    @Schema(description = "Товар")
    private ProductDto product;
    @Schema(description = "Удален")
    private boolean deleted;
}
