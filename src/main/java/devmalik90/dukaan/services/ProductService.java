package devmalik90.dukaan.services;

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

    public boolean create(Product product)
    {
        productDao.insert(product);
        return true;
    }
}
