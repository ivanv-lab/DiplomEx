package diplom.ex.dbcrud;

import diplom.ex.dbcrud.models.*;
import diplom.ex.dbcrud.repositories.*;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;
import java.util.logging.Logger;

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
			clientRepository.save(new Client("Sam I.F.","sam123@mail.ru","79458775467"));
			clientRepository.save(new Client("Ann A.H.","ananas@mail.ru","89056783321"));

			log.info("Client found with findAll():");
			log.info("---------------------------");
			clientRepository.findAll().forEach(user -> {
				log.info(user.toString());
			});
			log.info("");

			Client client=clientRepository.findById(1L);
			log.info("Client found with findById(1L):");
			log.info("---------------------------");
			log.info(client.toString());
			log.info("");

			log.info("Client found with findByFio('Ann A.H.'):");
			log.info("--------------------------------------------");
			clientRepository.findByFio("Ann A.H.").forEach(ann -> {
				log.info(ann.toString());
			});
			log.info("");
			//-----------------------------------------------------------------------------------------------
			//PickPoint
			pickPointRepository.save(new PickPoint("SC Meridian","Kuibisheva, 16A"));
			pickPointRepository.save(new PickPoint("SC Raion","Suzdalski prospect, 3"));

			log.info("PickPoints found with findAll():");
			log.info("---------------------------");
			pickPointRepository.findAll().forEach(user -> {
				log.info(user.toString());
			});
			log.info("");

			PickPoint pickPoint=pickPointRepository.findById(1L);
			log.info("PickPoint found with findById(1L):");
			log.info("---------------------------");
			log.info(pickPoint.toString());
			log.info("");

			log.info("PickPoint found with findByAddress('Suzdalski prospect, 3'):");
			log.info("--------------------------------------------");
			PickPoint pickPoint1=pickPointRepository.findByAddress("Suzdalski prospect, 3");
			log.info(pickPoint1.toString());
			log.info("");
			//-----------------------------------------------------------------------------------------------
			//Product
			productRepository.save(new Product("Intel Core I5-12400",23, new BigDecimal(12300)));
			productRepository.save(new Product("Intel Core I7-12700",12,new BigDecimal(24560)));

			log.info("Products found with findAll():");
			log.info("---------------------------");
			productRepository.findAll().forEach(product -> {
				log.info(product.toString());
			});
			log.info("");

			Product product=productRepository.findById(1L);
			log.info("Product found with findById(1L):");
			log.info("---------------------------");
			log.info(product.toString());
			log.info("");

			log.info("Product found with findByName('Intel Core I7-12700'):");
			log.info("--------------------------------------------");
			productRepository.findByName("Intel Core I7-12700").forEach(cpu -> {
				log.info(cpu.toString());
			});
			log.info("");


			//Пробничек
			//----------------------------------------------------------------------------------------------
//			Order order=new Order();
//			orderRepository.save(order);

			//orderItemRepository.save(new OrderItem(new Order(),product,2,new BigDecimal(26600)));
			//orderRepository.save(new Order(pickPoint,LocalDate.now(),new BigDecimal(24560),client,new OrderItem()));
			//orderItemRepository.save(new OrderItem(new Order(),product, 2, new BigDecimal(26600)));
//			Order order=new Order();
//			OrderItem orderItem=new OrderItem();
//			orderItem.setOrder(order);
//			orderItem.setNumber(2);
//			orderItem.setProduct(product.);
//			orderItem.setPrice(product.getPrice());
//			order.setDate(LocalDate.now());
//			order.setItem(orderItem);
//			order.setSum(new BigDecimal(26600));
//			order.setClient(client);
//			order.setPickPoint(pickPoint);


			//orderRepository.save(new Order(pickPoint, LocalDate.now(), new BigDecimal(26600), client,new OrderItem()));

			//-----------------------------------------------------------------------------------------------
			//OrderItem
//			orderItemRepository.save(new OrderItem(order,product,1,product.getPrice()));
//			orderItemRepository.save(new OrderItem(order,product,2,36860));
//
//			log.info("OrderProducts found with findAll():");
//			log.info("---------------------------");
//			orderItemRepository.findAll().forEach(ordP -> {
//				log.info(ordP.toString());
//			});
//			log.info("");
//
//			OrderItem orderItem=orderItemRepository.findById(1L);
//			log.info("OrderProducts found with findById(1L):");
//			log.info("---------------------------");
//			log.info(orderItem.toString());
//			log.info("");
//
//			log.info("OrderProducts found with findByOrderId('1L'):");
//			log.info("--------------------------------------------");
//			orderItemRepository.findByOrderId(1).forEach(ordPr -> {
//				log.info(ordPr.toString());
//			});
//			log.info("");
//			//-----------------------------------------------------------------------------------------------
//			//Order
//			orderRepository.save(new Order(pickPoint, LocalDate.now(), new BigDecimal(12300), client,orderItem));
//			orderRepository.save(new Order());
//
//			log.info("Orders found with findAll():");
//			log.info("---------------------------");
//			orderRepository.findAll().forEach(order -> {
//				log.info(order.toString());
//			});
//			log.info("");
//
//			Order order=orderRepository.findById(1L);
//			log.info("Order found with findById(1L):");
//			log.info("---------------------------");
//			log.info(order.toString());
//			log.info("");
//
//			log.info("Order found with findByDate('new SimpleDateFormat(\"dd.MM.yyyy\").parse(\"04.04.2024\")'):");
//			log.info("--------------------------------------------");
//			orderRepository.findByDate(new SimpleDateFormat("dd.MM.yyyy").parse("04.04.2024")).forEach(ord -> {
//				log.info(ord.toString());
//			});
//			log.info("");
		});
	}
}
