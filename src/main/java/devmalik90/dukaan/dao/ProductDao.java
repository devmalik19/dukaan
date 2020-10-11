package devmalik90.dukaan.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import devmalik90.dukaan.models.Product;

@Repository
public class ProductDao 
{
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public ProductDao(JdbcTemplate jdbcTemplate) 
    {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Product> getAll()
    {
        String sql = "SELECT * FROM PRODUCTS";
        return jdbcTemplate.query(sql, (resultSet,i) -> 
            new Product(
                            Integer.parseInt(resultSet.getString("id")) ,
                            UUID.fromString(resultSet.getString("UUID")), 
                            resultSet.getString("name"), 
                            resultSet.getString("mrp")
                        )
        );
    }

    public Optional<Product> get(int id)
    {
        String sql = "SELECT * FROM PRODUCTS WHERE ID = ?";
        List<Product> product = jdbcTemplate.query(
                sql,
                new Object[]{id},
                (resultSet,i) -> new Product(
                                        Integer.parseInt(resultSet.getString("id")) ,
                                        UUID.fromString(resultSet.getString("UUID")),
                                        resultSet.getString("name"),
                                        resultSet.getString("mrp")
                                )
        );
        return product.stream().findFirst();
    }
    
    public Product insert(Product product)
    {
        String sql      =   "INSERT INTO PRODUCTS(UUID,NAME,MRP) VALUES(?,?,?)";
        int response    =   jdbcTemplate.update(sql,
                            String.valueOf(product.generateUUID()),
                            product.getName(),
                            product.getMRP()
        );

        if(response==0)
            return  null;
        else
        {
            product.setId(response);
            return product;
        }

    }
    
}
