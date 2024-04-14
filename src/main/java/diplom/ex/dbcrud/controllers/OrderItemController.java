package diplom.ex.dbcrud.controllers;

import diplom.ex.dbcrud.models.OrderItem;
import diplom.ex.dbcrud.repositories.OrderItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderItemController {
    private OrderItemRepository orderItemRepository;
    @Autowired
    public OrderItemController(OrderItemRepository orderItemRepository){this.orderItemRepository=orderItemRepository;}

    @PostMapping(value = "/orderitems")
    public ResponseEntity<?> create(@RequestBody OrderItem orderItem){
        orderItemRepository.save(orderItem);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/orderitems")
    public ResponseEntity<List<OrderItem>> read(){
        final List<OrderItem> orderItems= (List<OrderItem>) orderItemRepository.findAll();
        return orderItems!=null && !orderItems.isEmpty()
                ? new ResponseEntity<>(orderItems,HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/orderitems/{id}")
    public ResponseEntity<OrderItem> read(@PathVariable(name="id") int id){
        final OrderItem orderItem=orderItemRepository.findById(id);
        return orderItem!=null
                ? new ResponseEntity<>(orderItem, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/orderitems/{id}")
    public ResponseEntity<OrderItem> update(@PathVariable(name="id") int id, @RequestBody OrderItem orderItem){
        final OrderItem updatebleOrderItem=orderItemRepository.findById(id);
        updatebleOrderItem.setOrder(orderItem.getOrder());
        updatebleOrderItem.setProduct(orderItem.getProduct());
        updatebleOrderItem.setNumber(orderItem.getNumber());
        updatebleOrderItem.setPrice(orderItem.getPrice());
        orderItemRepository.save(updatebleOrderItem);
        return updatebleOrderItem!=null
                ? new ResponseEntity<>(updatebleOrderItem,HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/orderitems/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable(name="id") long id){
        final OrderItem deletebleOrderItem=orderItemRepository.findById(id);
        orderItemRepository.delete(deletebleOrderItem);
        return deletebleOrderItem!=null
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
