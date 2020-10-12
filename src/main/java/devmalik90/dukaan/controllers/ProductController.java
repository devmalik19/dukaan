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
    @Autowired
    private ProductService productService;

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
    public Optional<Product> create(@RequestBody Product product)
    {
        return productService.create(product);
    }

    @PostMapping("/{id}")
    public Optional<Product> update(@PathVariable("id") int id,@RequestBody Product product)
    {
        return productService.update(id,product);
    }

    @DeleteMapping("/{id}")
    public Optional<Product> delete(@PathVariable("id") int id)
    {
        return productService.delete(id);
    }

    @GetMapping("/search/{search}")
    public void search(@PathVariable String search)
    {
        // To solr seacrh
    }

}
