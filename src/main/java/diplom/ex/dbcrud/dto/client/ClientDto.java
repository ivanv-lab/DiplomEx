package diplom.ex.dbcrud.dto.client;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@Schema(description = "Сущность клиента")
public class ClientDto {
    @Schema(description = "Идентификатор")
    private Long id;
    @Schema(description = "ФИО")
    private String fio;
    @Schema(description = "E-mail")
    private String email;
    @Schema(description = "Номер телефона")
    private String phone;
    @Schema(description = "Удален")
    private boolean deleted;
}
