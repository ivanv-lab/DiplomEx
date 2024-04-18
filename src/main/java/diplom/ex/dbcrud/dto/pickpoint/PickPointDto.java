package diplom.ex.dbcrud.dto.pickpoint;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class PickPointDto {
    private Long id;
    private String name;
    private String address;
}
