package diplom.ex.dbcrud;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import diplom.ex.dbcrud.models.*;
import diplom.ex.dbcrud.repositories.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.time.LocalDate;

@SpringBootApplication
public class DbcrudApplication {
	public static final Logger log=
			(Logger) LoggerFactory.getLogger(DbcrudApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(DbcrudApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(ClientRepository clientRepository, PickPointRepository pickPointRepository,
								  ProductRepository productRepository, OrderRepository orderRepository, OrderItemRepository orderItemRepository){
		return (args -> {

		});
	}
}
