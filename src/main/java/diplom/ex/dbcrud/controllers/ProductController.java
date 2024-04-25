package diplom.ex.dbcrud.controllers;

import diplom.ex.dbcrud.dto.product.ProductCreateDto;
import diplom.ex.dbcrud.dto.product.ProductDto;
import diplom.ex.dbcrud.dto.product.ProductUpdateDto;
import diplom.ex.dbcrud.mapper.ProductMapper;
import diplom.ex.dbcrud.repositories.ProductRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name="Product Controller", description = "CRUD Product Controller")
@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductMapper productMapper;

    @Operation(
            summary = "Создание нового товара",
            description = "Позволяет создать новый товар"
    )
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductDto create(@RequestBody ProductCreateDto productData){
        var product=productMapper.map(productData);
        productRepository.save(product);
        var productDto=productMapper.map(product);
        return productDto;
    }

    @Operation(
            summary = "Поиск товара по наименованию",
            description = "Позволяет найти нужный товар по наименованию"
    )
    @GetMapping("/search/{name}")
    @ResponseStatus(HttpStatus.OK)
    public List<ProductDto> getByName(@PathVariable String name){
        var products=productRepository.findByNameContainingIgnoreCase(name);
        var productsDto =productMapper.all(products);
        return productsDto;
    }

    @Operation(
            summary = "Выбор конкретного товара",
            description = "Позволяет выбрать нужный товар"
    )
    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public ProductDto getById(@PathVariable Long id){
        var product=productRepository.findById(id).get();
        var productDto=productMapper.map(product);
        return productDto;
    }

    @Operation(
            summary = "Изменение конкретного товара",
            description = "Позволяет изменить данные товара (наименование, кол-во, цену)"
    )
    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public ProductDto update(@RequestBody ProductUpdateDto productData, @PathVariable Long id){
        var product=productRepository.findById(id).get();
        productMapper.update(productData,product);
        productRepository.save(product);
        var productDto=productMapper.map(product);
        return productDto;
    }

    @Operation(
            summary = "Вывод всех товаров",
            description = "Позволяет вывести все товары в каталог"
    )
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductDto> getAll(){
        var products=productRepository.findAll();
        var productDto=productMapper.all((List)products);
        return productDto;
    }

    @Operation(
            summary = "Удаление конкретного товара",
            description = "Позволяет удалить нужный товар в случае прекращения торговли им"
    )
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public String delete(@PathVariable Long id){
        productRepository.deleteById(id);
        return "Product "+id+" success deleted";
    }
//    private ProductRepository productRepository;
//    @Autowired
//    public ProductController(ProductRepository productRepository){
//        this.productRepository=productRepository;
//    }
//
//    @PostMapping(value = "/products")
//    public ResponseEntity<?> create(@RequestBody Product product){
//        productRepository.save(product);
//        return new ResponseEntity<>(HttpStatus.CREATED);
//    }
//
//    @GetMapping(value = "/products")
//    public ResponseEntity<List<Product>> read(){
//        final List<Product> products= (List<Product>) productRepository.findAll();
//        return products!=null && !products.isEmpty()
//                ? new ResponseEntity<>(products,HttpStatus.OK)
//                :new ResponseEntity<>(HttpStatus.NOT_FOUND);
//    }
//
//    @GetMapping(value = "/products/{id}")
//    public ResponseEntity<Product> read(@PathVariable(name="id") int id){
//        final Product product=productRepository.findById(id);
//        return product!=null
//                ? new ResponseEntity<>(product,HttpStatus.OK)
//                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
//    }
//
//    @PutMapping(value = "/products/{id}")
//    public ResponseEntity<Product> update(@PathVariable(name="id") int id, @RequestBody Product product){
//        final Product updatebleProduct=productRepository.findById(id);
//        updatebleProduct.setName(product.getName());
//        updatebleProduct.setNumber(product.getNumber());
//        updatebleProduct.setPrice(product.getPrice());
//        productRepository.save(updatebleProduct);
//        return updatebleProduct!=null
//                ? new ResponseEntity<>(updatebleProduct,HttpStatus.OK)
//                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
//    }
//
//    @DeleteMapping(value = "/products/delete/{id}")
//    public ResponseEntity<?> delete(@PathVariable(name="id") long id){
//        final Product deletebleProduct=productRepository.findById(id);
//        productRepository.delete(deletebleProduct);
//        return deletebleProduct!=null
//                ? new ResponseEntity<>(HttpStatus.OK)
//                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
//    }
}
