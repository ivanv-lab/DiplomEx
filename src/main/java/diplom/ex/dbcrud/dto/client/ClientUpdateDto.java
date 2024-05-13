package diplom.ex.dbcrud.dto.client;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@Schema(description = "Сущность обновления клиента")
public class ClientUpdateDto {
    @Schema(description = "ФИО")
    private String fio;
    @Schema(description = "E-mail")
    private String email;
    @Schema(description = "Номер телефона")
    private String phone;
    @Schema(description = "Статус (Deleted, No status, Active)")
    private String status;
}
