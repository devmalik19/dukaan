package devmalik90.dukaan.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import devmalik90.dukaan.dao.ProductDao;
import devmalik90.dukaan.models.Product;

@Service
public class ProductService 
{
    private ProductDao productDao;

    @Autowired
    public ProductService(ProductDao productDao) 
    {
        this.productDao = productDao;
    }

    public List<Product> getAll()
    {
        return productDao.getAll();
    }

    public Optional<Product> get(int id)
    {
        return productDao.get(id);
    }

    public Product create(Product product)
    {
        return productDao.insert(product);
    }
}
