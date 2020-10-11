package devmalik90.dukaan.controllers;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import devmalik90.dukaan.models.Product;
import devmalik90.dukaan.services.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController
{
    private ProductService productService;
    
    @Autowired
    public ProductController(ProductService productService) 
    {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getAll()
    {
        return productService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Product> get(@PathVariable("id") int id)
    {
        return productService.get(id);
    }

    @PutMapping
    public Product create(@RequestBody Product product)
    {
        return productService.create(product);
    }

    @PostMapping("/{id}")
    public void update(@PathVariable("id") UUID id,@RequestBody Product product)
    {

    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") UUID id)
    {

    }

    @GetMapping("/search/{search}")
    public void search(@PathVariable String search)
    {
        
    }

}
