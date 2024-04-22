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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pickpoints")
public class PickPointController {
    @Autowired
    private PickPointRepository pointRepository;
    @Autowired
    private PickPointMapper pointMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PickPointDto create(@RequestBody PickPointCreateDto pointData){
        var point=pointMapper.map(pointData);
        pointRepository.save(point);
        var pointDto=pointMapper.map(point);
        return pointDto;
    }

    @GetMapping("/search/{address}")
    @ResponseStatus(HttpStatus.OK)
    public List<PickPointDto>  getByAddress(@PathVariable String address) {
        var points = pointRepository.findByAddressContainingIgnoreCase(address);
        var pointsDto =pointMapper.all((List)points);
        return pointsDto;
    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public PickPointDto getById(@PathVariable Long id){
        var point=pointRepository.findById(id).get();
        var pointDto=pointMapper.map(point);
        return pointDto;
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public PickPointDto update(@RequestBody PickPointUpdateDto pointData, @PathVariable Long id){
        var point=pointRepository.findById(id).get();
        pointMapper.update(pointData,point);
        pointRepository.save(point);
        var pointDto=pointMapper.map(point);
        return pointDto;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<PickPointDto> getAll(){
        var points=pointRepository.findAll();
        var pointDto=pointMapper.all((List)points);
        return pointDto;
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public String delete(@PathVariable Long id){
        pointRepository.deleteById(id);
        return "Pick point "+id+" success deleted";
    }

//    private PickPointRepository pickPointRepository;
//    @Autowired
//    public PickPointController(PickPointRepository pickPointRepository){this.pickPointRepository=pickPointRepository;}
//
//    @PostMapping (value = "/pickpoints")
//    public ResponseEntity<?> create(@RequestBody PickPoint pickPoint){
//        pickPointRepository.save(pickPoint);
//        return new ResponseEntity<>(HttpStatus.CREATED);
//    }
//
//    @GetMapping(value = "/pickpoints")
//    public ResponseEntity<List<PickPoint>> read(){
//        final List<PickPoint> pickPoints= (List<PickPoint>) pickPointRepository.findAll();
//        return pickPoints!=null && !pickPoints.isEmpty()
//                ? new ResponseEntity<>(pickPoints,HttpStatus.OK)
//                :new ResponseEntity<>(HttpStatus.NOT_FOUND);
//    }
//
//    @GetMapping(value = "/pickpoints/{id}")
//    public ResponseEntity<PickPoint> read(@PathVariable(name="id") int id){
//        final PickPoint pickPoint=pickPointRepository.findById(id);
//        return pickPoint!=null
//                ? new ResponseEntity<>(pickPoint, HttpStatus.OK)
//                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
//    }
//
//    @PutMapping(value = "/pickpoints/{id}")
//    public ResponseEntity<PickPoint> update(@PathVariable(name="id") int id, @RequestBody PickPoint pickPoint){
//        final PickPoint updateblePickPoint=pickPointRepository.findById(id);
//        updateblePickPoint.setName(pickPoint.getName());
//        updateblePickPoint.setAddress(pickPoint.getAddress());
//        pickPointRepository.save(updateblePickPoint);
//        return updateblePickPoint!=null
//                ? new ResponseEntity<>(updateblePickPoint,HttpStatus.OK)
//                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
//    }
//
//    @DeleteMapping(value = "/pickpoints/delete/{id}")
//    public ResponseEntity<?> delete(@PathVariable(name="id") long id){
//        final PickPoint deleteblePickPoint=pickPointRepository.findById(id);
//        pickPointRepository.delete(deleteblePickPoint);
//        return deleteblePickPoint!=null
//                ? new ResponseEntity<>(HttpStatus.OK)
//                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
//    }
}
