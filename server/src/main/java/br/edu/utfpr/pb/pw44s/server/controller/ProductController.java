package br.edu.utfpr.pb.pw44s.server.controller;

import br.edu.utfpr.pb.pw44s.server.dto.ProductDTO;
import br.edu.utfpr.pb.pw44s.server.mapper.ProductMapper;
import br.edu.utfpr.pb.pw44s.server.model.Product;
import br.edu.utfpr.pb.pw44s.server.service.ICrudService;
import br.edu.utfpr.pb.pw44s.server.service.IProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("products")
public class ProductController extends CrudController<Product, ProductDTO, Long> {

    private final ProductMapper productMapper;

    public ProductController(IProductService productService, ProductMapper productMapper) {
        this.productMapper = productMapper;
        ProductController.productService = productService;
    }

    private static IProductService productService;

    @Override
    protected ICrudService<Product, Long> getService() {
        return productService;
    }

    @Override
    protected ProductDTO toDto(Product entity) {
        return productMapper.toDto(entity);
    }

    @Override
    protected Product toEntity(ProductDTO dto) {
        return productMapper.toEntity(dto);
    }

//    @GetMapping("/categories/{id}")
//    public ResponseEntity<ProductDTO> findOne(@PathVariable Long id) {
//        Product entity = getService().findById(id);
//        if (entity != null) {
//            return ResponseEntity.ok(convertToDto(entity));
//        } else {
//            return ResponseEntity.noContent().build();
//        }
//    }

}