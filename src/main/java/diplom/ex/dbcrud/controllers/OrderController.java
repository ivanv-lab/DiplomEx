package diplom.ex.dbcrud.controllers;

import diplom.ex.dbcrud.models.Order;
import diplom.ex.dbcrud.models.PickPoint;
import diplom.ex.dbcrud.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {
    private OrderRepository orderRepository;
    @Autowired
    public OrderController(OrderRepository orderRepository){this.orderRepository=orderRepository;}

    //При ссылке на "client":{"id":5 } или такой же на pickPoint выдает реквест с огромной вложенностью,
    //хотя в БД все хорошо

    @PostMapping(value = "/orders")
    public ResponseEntity<?> create(@RequestBody Order order){
        orderRepository.save(order);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/orders")
    public ResponseEntity<List<Order>> read(){
        final List<Order> orders= (List<Order>) orderRepository.findAll();
        return orders!=null && !orders.isEmpty()
                ? new ResponseEntity<>(orders,HttpStatus.OK)
                :new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/orders/{id}")
    public ResponseEntity<Order> read(@PathVariable(name="id") int id){
        final Order order=orderRepository.findById(id);
        return order!=null
                ? new ResponseEntity<>(order, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/orders/{id}")
    public ResponseEntity<Order> update(@PathVariable(name="id") int id, @RequestBody Order order){
        final Order updatebleOrder=orderRepository.findById(id);
        updatebleOrder.setDate(order.getDate());
        updatebleOrder.setClient(order.getClient());
        updatebleOrder.setPickPoint(order.getPickPoint());
        updatebleOrder.setSum(order.getSum());
        orderRepository.save(updatebleOrder);
        return updatebleOrder!=null
                ? new ResponseEntity<>(updatebleOrder,HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/orders/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable(name="id") long id){
        final Order deletebleOrder=orderRepository.findById(id);
        orderRepository.delete(deletebleOrder);
        return deletebleOrder!=null
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
