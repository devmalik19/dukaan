package devmalik90.dukaan.controllers;

import java.util.UUID;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController
{
    @GetMapping("/")
    public void getAll()
    {

    }

    @GetMapping("/{id}")
    public void get(@PathVariable UUID id)
    {

    }

    @PutMapping("/")
    public void create(@RequestBody ProductController product)
    {

    }

    @PostMapping("/{id}")
    public void update(@PathVariable UUID id,@RequestBody ProductController product)
    {

    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id)
    {

    }

    @GetMapping("/search/{search}")
    public void search(@PathVariable String search)
    {
        
    }
}
