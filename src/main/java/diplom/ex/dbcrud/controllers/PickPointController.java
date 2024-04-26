package diplom.ex.dbcrud.controllers;

import diplom.ex.dbcrud.dto.pickpoint.PickPointCreateDto;
import diplom.ex.dbcrud.dto.pickpoint.PickPointDto;
import diplom.ex.dbcrud.dto.pickpoint.PickPointUpdateDto;
import diplom.ex.dbcrud.dto.product.ProductCreateDto;
import diplom.ex.dbcrud.dto.product.ProductDto;
import diplom.ex.dbcrud.dto.product.ProductUpdateDto;
import diplom.ex.dbcrud.mapper.PickPointMapper;
import diplom.ex.dbcrud.models.PickPoint;
import diplom.ex.dbcrud.models.Product;
import diplom.ex.dbcrud.repositories.PickPointRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name="PickPoint Controller", description = "CRUD PickPoint Controller")
@RestController
@RequestMapping("/pickpoints")
public class PickPointController {
    @Autowired
    private PickPointRepository pointRepository;
    @Autowired
    private PickPointMapper pointMapper;

    @Operation(
            summary = "Создание пункта выдачи",
            description = "Позволяет создать новый пункт выдачи"
    )
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PickPointDto create(@RequestBody PickPointCreateDto pointData){
        var point=pointMapper.map(pointData);
        pointRepository.save(point);
        var pointDto=pointMapper.map(point);
        return pointDto;
    }

    @Operation(
            summary = "Поиск пункта выдачи по адресу",
            description = "Позволяет найти нужный пункт выдачи по его адресу"
    )
    @GetMapping("/search/{address}")
    @ResponseStatus(HttpStatus.OK)
    public List<PickPointDto>  getByAddress(@PathVariable String address) {
        var points = pointRepository.findByAddressContainingIgnoreCase(address);
        var pointsDto =pointMapper.all((List)points);
        return pointsDto;
    }

    @Operation(
            summary = "Выбор конкретного пункта выдачи",
            description = "Позволяет выбрать нужный пункт выдачи"
    )
    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public PickPointDto getById(@PathVariable Long id){
        var point=pointRepository.findById(id).get();
        var pointDto=pointMapper.map(point);
        return pointDto;
    }

    //Ненужный метод
//    @PutMapping("{id}")
//    @ResponseStatus(HttpStatus.OK)
//    public PickPointDto update(@RequestBody PickPointUpdateDto pointData, @PathVariable Long id){
//        var point=pointRepository.findById(id).get();
//        pointMapper.update(pointData,point);
//        pointRepository.save(point);
//        var pointDto=pointMapper.map(point);
//        return pointDto;
//    }

    @Operation(
            summary = "Вывод всех пунктов выдачи",
            description = "Позволяет вывести все пункты выдачи"
    )
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<PickPointDto> getAll(){
        var points=pointRepository.findAll();
        var pointDto=pointMapper.all((List)points);
        return pointDto;
    }

    @Operation(
            summary = "Удаление конкретного пункта выдачи",
            description = "Позволяет удалить нужный пункт выдачи в случае закрытия/переезда"
    )
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public String delete(@PathVariable Long id){
        pointRepository.deleteById(id);
        return "Pick point "+id+" success deleted";
    }
}
