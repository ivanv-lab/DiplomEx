package diplom.ex.dbcrud.dto.pickpoint;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class PickPointUpdateDto {
    private String name;
    private String address;
}
