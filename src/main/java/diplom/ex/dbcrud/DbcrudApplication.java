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

	/**
	 * Комменты что бы не создавались новые записи
	 */

	@Bean
	public CommandLineRunner demo(ClientRepository clientRepository, PickPointRepository pickPointRepository,
								  ProductRepository productRepository, OrderRepository orderRepository, OrderItemRepository orderItemRepository){
		return (args -> {
			//Client
//			clientRepository.save(new Client("Sam I.F.","sam123@mail.ru","79458775467"));
//			clientRepository.save(new Client("Ann A.H.","ananas@mail.ru","89056783321"));
//
//			log.info("Client found with findAll():");
//			log.info("---------------------------");
//			clientRepository.findAll().forEach(client -> {
//				log.info(client.toString());
//			});
//			log.info("");
//
//			Client client=clientRepository.findById(1L);
//			log.info("Client found with findById(1L):");
//			log.info("---------------------------");
//			log.info(client.toString());
//			log.info("");
//
//			log.info("Client found with findByFio('Ann A.H.'):");
//			log.info("--------------------------------------------");
//			clientRepository.findByFio("Ann A.H.").forEach(ann -> {
//				log.info(ann.toString());
//			});
//			log.info("");
//			//-----------------------------------------------------------------------------------------------
			//PickPoint
//			pickPointRepository.save(new PickPoint("SC Meridian","Kuibisheva, 16A"));
//			pickPointRepository.save(new PickPoint("SC Raion","Suzdalski prospect, 3"));
//
//			log.info("PickPoints found with findAll():");
//			log.info("---------------------------");
//			pickPointRepository.findAll().forEach(user -> {
//				log.info(user.toString());
//			});
//			log.info("");
//
//			PickPoint pickPoint=pickPointRepository.findById(1L);
//			log.info("PickPoint found with findById(1L):");
//			log.info("---------------------------");
//			log.info(pickPoint.toString());
//			log.info("");
//
//			log.info("PickPoint found with findByAddress('Suzdalski prospect, 3'):");
//			log.info("--------------------------------------------");
//			PickPoint pickPoint1=pickPointRepository.findByAddress("Suzdalski prospect, 3");
//			log.info(pickPoint1.toString());
//			log.info("");
			//-----------------------------------------------------------------------------------------------
			//Product
//			productRepository.save(new Product("Intel Core I5-12400",23, new BigDecimal(12300)));
//			productRepository.save(new Product("Intel Core I7-12700",12,new BigDecimal(24560)));
//
//			log.info("Products found with findAll():");
//			log.info("---------------------------");
//			productRepository.findAll().forEach(product -> {
//				log.info(product.toString());
//			});
//			log.info("");
//
//			Product product=productRepository.findById(1L);
//			log.info("Product found with findById(1L):");
//			log.info("---------------------------");
//			log.info(product.toString());
//			log.info("");
//
//			log.info("Product found with findByName('Intel Core I7-12700'):");
//			log.info("--------------------------------------------");
//			productRepository.findByName("Intel Core I7-12700").forEach(cpu -> {
//				log.info(cpu.toString());
//			});
//			log.info("");
			//--------------------------------------------------------------------------------------------------


//			orderRepository.save(new Order());
//			log.info("Order saved");
//			orderItemRepository.save(new OrderItem(orderRepository.findById(1), productRepository.findById(1), 2, new BigDecimal(26600)));
//			log.info("OrderList saved");

//			Order order=orderRepository.findById(1);
//			order.setClient(clientRepository.findById(1));
//			order.setSum(new BigDecimal(26600));
//			order.setDate(LocalDate.now());
//			order.setPickPoint(pickPointRepository.findById(1));
//			order.setItem(orderItemRepository.findById(1));
//			log.info("Order setted");
//			orderRepository.save(order);
//			log.info("Order saved");
		});
	}
}
