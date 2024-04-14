package diplom.ex.dbcrud.controllers;

import diplom.ex.dbcrud.models.Client;
import diplom.ex.dbcrud.models.Product;
import diplom.ex.dbcrud.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    private ProductRepository productRepository;
    @Autowired
    public ProductController(ProductRepository productRepository){
        this.productRepository=productRepository;
    }

    @PostMapping(value = "/products")
    public ResponseEntity<?> create(@RequestBody Product product){
        productRepository.save(product);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/products")
    public ResponseEntity<List<Product>> read(){
        final List<Product> products= (List<Product>) productRepository.findAll();
        return products!=null && !products.isEmpty()
                ? new ResponseEntity<>(products,HttpStatus.OK)
                :new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/products/{id}")
    public ResponseEntity<Product> read(@PathVariable(name="id") int id){
        final Product product=productRepository.findById(id);
        return product!=null
                ? new ResponseEntity<>(product,HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/products/{id}")
    public ResponseEntity<Product> update(@PathVariable(name="id") int id, @RequestBody Product product){
        final Product updatebleProduct=productRepository.findById(id);
        updatebleProduct.setName(product.getName());
        updatebleProduct.setNumber(product.getNumber());
        updatebleProduct.setPrice(product.getPrice());
        productRepository.save(updatebleProduct);
        return updatebleProduct!=null
                ? new ResponseEntity<>(updatebleProduct,HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/products/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable(name="id") long id){
        final Product deletebleProduct=productRepository.findById(id);
        productRepository.delete(deletebleProduct);
        return deletebleProduct!=null
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
