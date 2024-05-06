package diplom.ex.dbcrud.controllers;

import diplom.ex.dbcrud.dto.orderitem.OrderItemCreateDto;
import diplom.ex.dbcrud.dto.orderitem.OrderItemDto;
import diplom.ex.dbcrud.dto.orderitem.OrderItemUpdateDto;
import diplom.ex.dbcrud.mapper.OrderItemMapper;
import diplom.ex.dbcrud.models.OrderItem;
import diplom.ex.dbcrud.repositories.OrderItemRepository;
import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Hidden
@Tag(name="OrderItem Controller", description = "CRUD OrderItem Controller")
@RestController
@RequestMapping("/orderitems")
public class OrderItemController {
    @Autowired
    private OrderItemRepository itemRepository;
    @Autowired
    private OrderItemMapper itemMapper;

    @Operation(
            summary = "Создание пункта заказа",
            description = "Позволяет создать новый пункт заказа"
    )
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OrderItemDto create(@RequestBody OrderItemCreateDto itemData){
        var item=itemMapper.map(itemData);
        itemRepository.save(item);
        var itemDto=itemMapper.map(item);
        return itemDto;
    }

//    @GetMapping("/orderid/{id}")
//    @ResponseStatus(HttpStatus.OK)
//    public List<OrderItemDto> getByOrderId(@PathVariable Long id){
//        var items=itemRepository.findByOrderId(id);
//        var itemDto=itemMapper.all((List)items);
//        return itemDto;
//    }

    @Operation(
            summary = "Получение конкретного пункта заказа",
            description = "Позволяет получить нужный пункт заказа"
    )
    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public OrderItemDto getById(@PathVariable Long id){
        var item=itemRepository.findById(id).get();
        var itemDto=itemMapper.map(item);
        return itemDto;
    }

    @Operation(
            summary = "Редактирование пункта заказа",
            description = "Позволяет редактировать пункт заказа(товар, кол-во, цену)"
    )
    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public OrderItemDto update(@RequestBody OrderItemUpdateDto itemData, @PathVariable Long id){
        var item=itemRepository.findById(id).get();
        itemMapper.update(itemData,item);
        itemRepository.save(item);
        var itemDto=itemMapper.map(item);
        return itemDto;
    }

//    @GetMapping
//    @ResponseStatus(HttpStatus.OK)
//    public List<OrderItemDto> getAll(){
//        var items=itemRepository.findAll();
//        var itemDto=itemMapper.all((List)items);
//        return itemDto;
//    }

    @Operation(
            summary = "Удаление пункта заказа",
            description = "Позволяет удалить пункт заказа в случае отмены"
    )
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public String delete(@PathVariable Long id){
        itemRepository.deleteById(id);
        return "OrderItem "+id+" success deleted";
    }
}
