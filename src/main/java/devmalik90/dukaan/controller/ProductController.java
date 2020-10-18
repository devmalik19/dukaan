package devmalik90.dukaan.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import devmalik90.dukaan.exception.ResourceNotFoundException;
import devmalik90.dukaan.model.Product;
import devmalik90.dukaan.service.ProductService;

import javax.validation.Valid;

@RestController
@RequestMapping("/product")
public class ProductController
{
    @Autowired
    private ProductService productService;

    @GetMapping
    public List<Product> getAll()
    {
        return productService.getAll();
    }

    @GetMapping("/{id}")
    public Product get(@PathVariable("id") int id) throws ResourceNotFoundException
    {
        Optional<Product> optionalProduct = productService.get(id);
        return optionalProduct.orElseThrow(()->new ResourceNotFoundException("Product Not Found"));
    }

    @PutMapping
    public Product create(@Valid @RequestBody Product product) throws ResourceNotFoundException
    {
        Optional<Product> optionalProduct =  productService.create(product);
        optionalProduct.ifPresent(p -> p.setMessage("Product Created"));
        return optionalProduct.orElseThrow(()->new ResourceNotFoundException("Product Not Found"));
    }

    @PostMapping("/{id}")
    public Product update(@PathVariable("id") int id, @RequestBody Product product) throws ResourceNotFoundException
    {
        Optional<Product> optionalProduct =   productService.update(id,product);
        optionalProduct.ifPresent(p -> p.setMessage("Product Updated"));
        return  optionalProduct.orElseThrow(()->new ResourceNotFoundException("Product Not Found"));
    }

    @DeleteMapping("/{id}")
    public Product delete(@PathVariable("id") int id) throws ResourceNotFoundException
    {
        Optional<Product> optionalProduct =   productService.delete(id);
        optionalProduct.ifPresent(p -> p.setMessage("Product Deleted"));
        return  optionalProduct.orElseThrow(()->new ResourceNotFoundException("Product Not Found"));
    }

    @GetMapping("/search/{search}")
    public void search(@PathVariable String search)
    {
        // To solr seacrh
    }

}
