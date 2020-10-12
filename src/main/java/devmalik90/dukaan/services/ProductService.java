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
    @Autowired
    private ProductDao productDao;

    public List<Product> getAll()
    {
        return productDao.getAll();
    }

    public Optional<Product> get(int id)
    {
        return productDao.get(id);
    }

    public Optional<Product> create(Product product)
    {
        return productDao.insert(product);
    }

    public Optional<Product> update(int id,Product product)
    {
        if(get(id).isPresent())
        {
            product.setId(id);
            return  productDao.update(product);
        }
        else
            return null;

    }

    public Optional<Product> delete(int id)
    {
        Optional<Product>   product = get(id);
        if(product.isPresent() && productDao.delete(id))
        {
            return product;
        }
        else
            return null;

    }
}
