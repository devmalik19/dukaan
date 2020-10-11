package devmalik90.dukaan.controllers;

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
    public void getAll()
    {

    }

    @GetMapping("/{id}")
    public void get(@PathVariable("id") UUID id)
    {

    }

    @PutMapping
    public void create(@RequestBody Product product)
    {

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
