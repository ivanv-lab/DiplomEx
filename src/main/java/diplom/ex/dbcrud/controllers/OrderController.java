package diplom.ex.dbcrud.controllers;

import diplom.ex.dbcrud.dto.client.ClientCreateDto;
import diplom.ex.dbcrud.dto.client.ClientDto;
import diplom.ex.dbcrud.dto.client.ClientUpdateDto;
import diplom.ex.dbcrud.dto.order.OrderCreateDto;
import diplom.ex.dbcrud.dto.order.OrderDto;
import diplom.ex.dbcrud.dto.order.OrderUpdateDto;
import diplom.ex.dbcrud.mapper.OrderMapper;
import diplom.ex.dbcrud.models.Order;
import diplom.ex.dbcrud.models.PickPoint;
import diplom.ex.dbcrud.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderMapper orderMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OrderDto create(@RequestBody OrderCreateDto orderData){
        var order=orderMapper.map(orderData);
        orderRepository.save(order);
        var orderDto=orderMapper.map(order);
        return orderDto;
    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public OrderDto getById(@PathVariable Long id){
        var order=orderRepository.findOrderAndOrderItemByOrderId(id);
        var orderDto=orderMapper.map(order);
        return orderDto;
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public OrderDto update(@RequestBody OrderUpdateDto orderData, @PathVariable Long id){
        var order=orderRepository.findById(id).get();
        orderMapper.update(orderData,order);
        orderRepository.save(order);
        var orderDto=orderMapper.map(order);
        return orderDto;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<OrderDto> getAll(){
        var orders=orderRepository.findAll();
        var orderDto=orderMapper.all((List)orders);
        return orderDto;
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public String delete(@PathVariable Long id){
        orderRepository.deleteById(id);
        return "Order "+id+" success deleted";
    }
//    private OrderRepository orderRepository;
//    @Autowired
//    public OrderController(OrderRepository orderRepository){this.orderRepository=orderRepository;}
//
//    //При ссылке на "client":{"id":5 } или такой же на pickPoint выдает реквест с огромной вложенностью,
//    //хотя в БД все хорошо
//
//    @PostMapping(value = "/orders")
//    public ResponseEntity<?> create(@RequestBody Order order){
//        orderRepository.save(order);
//        return new ResponseEntity<>(HttpStatus.CREATED);
//    }
//
//    @GetMapping(value = "/orders")
//    public ResponseEntity<List<Order>> read(){
//        final List<Order> orders= (List<Order>) orderRepository.findAll();
//        return orders!=null && !orders.isEmpty()
//                ? new ResponseEntity<>(orders,HttpStatus.OK)
//                :new ResponseEntity<>(HttpStatus.NOT_FOUND);
//    }
//
//    @GetMapping(value = "/orders/{id}")
//    public ResponseEntity<Order> read(@PathVariable(name="id") int id){
//        final Order order=orderRepository.findById(id);
//        return order!=null
//                ? new ResponseEntity<>(order, HttpStatus.OK)
//                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
//    }
//
//    @PutMapping(value = "/orders/{id}")
//    public ResponseEntity<Order> update(@PathVariable(name="id") int id, @RequestBody Order order){
//        final Order updatebleOrder=orderRepository.findById(id);
//        updatebleOrder.setDate(order.getDate());
//        updatebleOrder.setClient(order.getClient());
//        updatebleOrder.setPickPoint(order.getPickPoint());
//        updatebleOrder.setSum(order.getSum());
//        orderRepository.save(updatebleOrder);
//        return updatebleOrder!=null
//                ? new ResponseEntity<>(updatebleOrder,HttpStatus.OK)
//                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
//    }
//
//    @DeleteMapping(value = "/orders/delete/{id}")
//    public ResponseEntity<?> delete(@PathVariable(name="id") long id){
//        final Order deletebleOrder=orderRepository.findById(id);
//        orderRepository.delete(deletebleOrder);
//        return deletebleOrder!=null
//                ? new ResponseEntity<>(HttpStatus.OK)
//                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
//    }
}
