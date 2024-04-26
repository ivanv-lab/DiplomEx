package diplom.ex.dbcrud.swagger;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
        info = @Info(
                title = "Internet Shop API",
                description = "Internet Shop", version = "1.0.0",
                contact = @Contact(
                        name="Vozisov I.A.",
                        email = "ivanvozisov33@yandex.ru"
                )
        )
)
public class SwaggerConfig {
}
