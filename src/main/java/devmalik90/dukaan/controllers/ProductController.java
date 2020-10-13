package devmalik90.dukaan.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import devmalik90.dukaan.exceptions.ResourceNotFoundException;
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
    public Product get(@PathVariable("id") int id)
    {
         Optional<Product> product = productService.get(id);
         if(product.isEmpty())
            throw new ResourceNotFoundException("Product Not Found");
         
         return product.get();
    }

    @PutMapping
    public Optional<Product> create(@RequestBody Product product)
    {
        Optional<Product> optionalProduct =  productService.create(product);
        optionalProduct.ifPresent(p -> p.setMessage("Product Created"));
        return  optionalProduct;
    }

    @PostMapping("/{id}")
    public Optional<Product> update(@PathVariable("id") int id,@RequestBody Product product)
    {
        Optional<Product> optionalProduct =   productService.update(id,product);
        optionalProduct.ifPresent(p -> p.setMessage("Product Updated"));
        return  optionalProduct;
    }

    @DeleteMapping("/{id}")
    public Optional<Product> delete(@PathVariable("id") int id)
    {
        Optional<Product> optionalProduct =   productService.delete(id);
        optionalProduct.ifPresent(p -> p.setMessage("Product Deleted"));
        return  optionalProduct;
    }

    @GetMapping("/search/{search}")
    public void search(@PathVariable String search)
    {
        // To solr seacrh
    }

}
