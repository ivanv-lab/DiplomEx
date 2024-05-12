package diplom.ex.dbcrud.controllers;

import diplom.ex.dbcrud.dto.client.ClientCreateDto;
import diplom.ex.dbcrud.dto.client.ClientDto;
import diplom.ex.dbcrud.dto.client.ClientUpdateDto;
import diplom.ex.dbcrud.dto.order.OrderCreateDto;
import diplom.ex.dbcrud.dto.order.OrderDto;
import diplom.ex.dbcrud.dto.order.OrderUpdateDto;
import diplom.ex.dbcrud.dto.orderitem.OrderItemCreateDto;
import diplom.ex.dbcrud.dto.orderitem.OrderItemDto;
import diplom.ex.dbcrud.dto.orderitem.OrderItemUpdateDto;
import diplom.ex.dbcrud.mapper.OrderItemMapper;
import diplom.ex.dbcrud.mapper.OrderMapper;
import diplom.ex.dbcrud.models.Order;
import diplom.ex.dbcrud.models.OrderItem;
import diplom.ex.dbcrud.models.PickPoint;
import diplom.ex.dbcrud.repositories.OrderItemRepository;
import diplom.ex.dbcrud.repositories.OrderRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name="Order Controller", description = "CRUD Order Controller")
@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderItemMapper itemMapper;
    @Autowired
    private OrderItemRepository itemRepository;
    @Autowired
    private OrderMapper orderMapper;

    @Operation(
            summary = "Создание заказа",
            description = "Позволяет создать новый заказ"
    )
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OrderDto create(@RequestBody OrderCreateDto orderData){
        var order=orderMapper.map(orderData);
        orderRepository.save(order);
        var orderDto=orderMapper.map(order);
        return orderDto;
    }

    @Operation(
            summary = "Поиск заказов по статусу и пункту выдачи",
            description = "Позволяет найти все заказы с определенным статусом и пунктом выдачи"
    )
    @GetMapping("/search/{statusId}/{pickPointId}")
    @ResponseStatus(HttpStatus.OK)
    public List<OrderDto> getAllByStatusAndPickPoint(@PathVariable Long statusId, @PathVariable Long pickPointId){
        var order=orderRepository.findByStatusAndPickPoint(statusId, pickPointId);
        var orderDto=orderMapper.all((List)order);
        return orderDto;
    }

    @Operation(
            summary = "Получение конкретного заказа",
            description = "Позволяет вывести нужный заказ"
    )
    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public OrderDto getById(@PathVariable Long id){
        var order=orderRepository.findOrderAndOrderItemByOrderId(id);
        var orderDto=orderMapper.map(order);
        return orderDto;
    }

    @Operation(
            summary = "Изменение заказа",
            description = "Позволяет изменить детали заказа (место выдачи, сумму заказа)"
    )
    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public OrderDto update(@RequestBody OrderUpdateDto orderData, @PathVariable Long id){
        Order order=orderRepository.findById(id).get();
        orderMapper.update(orderData,order);
        itemRepository.saveAll(orderData.getItem());
        orderRepository.save(order);
        //itemRepository.saveAll(order.getItem());
        var orderDto=orderMapper.map(order);
        return orderDto;
    }

    @Operation(
            summary = "Получение всех заказов",
            description = "Позволяет вывести все заказы"
    )
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<OrderDto> getAll(){
        var orders=orderRepository.findAll();
        var orderDto=orderMapper.all((List)orders);
        return orderDto;
    }

    @Operation(
            summary = "Удаление заказа заказа",
            description = "Позволяет удалить заказ в случае отмены"
    )
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public String delete(@PathVariable Long id){
        orderRepository.deleteById(id);
        return "Order "+id+" success deleted";
    }

//    @Operation(
//            summary = "Добавление пункта заказа в данный заказ",
//            description = "Позволяет добавить новый пункт(number, price, product) в указанный заказ(id)"
//    )
//    @PostMapping("{id}/additem")
//    @ResponseStatus(HttpStatus.OK)
//    public OrderDto createItem(@PathVariable long id, @RequestBody OrderItemCreateDto item){
//        Order order=orderRepository.findById(id).get();
//        if(order!=null){
//            item.setOrder(orderMapper.map(order));
//            var itemDto=itemMapper.map(item);
//            itemRepository.save(itemDto);
//            var orderDto=orderMapper.map(order);
//            return orderDto;
//        }
//        return null;
//    }
//
//    @Operation(
//            summary = "Удаление данного пункта закза из данного заказа",
//            description = "Позволяет удалить указанный пункт заказа(itemId) из указанного заказа(orderId)"
//    )
//    @DeleteMapping("{orderId}/deleteitem/{itemId}")
//    @ResponseStatus(HttpStatus.OK)
//    public OrderDto deleteItem(@PathVariable long orderId, @PathVariable long itemId){
//        Order order=orderRepository.findById(orderId).get();
//        if(order!=null){
//            var item=itemRepository.findById(itemId);
//            if(item!=null){
//                itemRepository.delete(item);
//                return orderMapper.map(order);
//            }
//        }
//        return null;
//    }
}
