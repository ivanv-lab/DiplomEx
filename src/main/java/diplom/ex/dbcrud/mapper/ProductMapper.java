package diplom.ex.dbcrud.mapper;

import diplom.ex.dbcrud.dto.product.ProductCreateDto;
import diplom.ex.dbcrud.dto.product.ProductDto;
import diplom.ex.dbcrud.dto.product.ProductUpdateDto;
import diplom.ex.dbcrud.models.Product;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    Product map(ProductCreateDto dto);
    ProductDto map(Product model);
    void update(ProductUpdateDto dto, @MappingTarget Product model);
    List<ProductDto> all(List<Product> model);
}
