package devmalik90.dukaan.dao;

import java.util.UUID;

import org.springframework.stereotype.Repository;

import devmalik90.dukaan.models.Product;

@Repository
public class ProductDao 
{
    public boolean insert(Product product)
    {
        UUID id = UUID.randomUUID();
        return true;
    }
    
}
