package diplom.ex.dbcrud;

import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.logging.Logger;

@SpringBootApplication
public class DbcrudApplication {
	public static final Logger log=
			(Logger) LoggerFactory.getLogger(DbcrudApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(DbcrudApplication.class, args);
	}

}
