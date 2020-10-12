package devmalik90.dukaan.dao;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import devmalik90.dukaan.models.Product;

@Repository
public class ProductDao 
{
    @Autowired
    private JdbcTemplate jdbcTemplate;

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
    
    public Optional<Product> insert(Product product)
    {
        KeyHolder   keyHolder   =   new GeneratedKeyHolder();
        String sql      =   "INSERT INTO PRODUCTS(UUID,NAME,MRP) VALUES(?,?,?)";

        int response    = jdbcTemplate.update( con -> {
                                PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                                ps.setString(1,String.valueOf(product.generateUUID()));
                                ps.setString(2,product.getName());
                                ps.setString(3,product.getMRP());

                                return  ps;
                            },keyHolder);


        if(response==0)
            return  null;
        else
        {
            int id =    (Integer) keyHolder.getKey();
            product.setId(id);
            return Optional.ofNullable(product);
        }

    }

    public Optional<Product> update(Product product)
    {
        String sql      =   "UPDATE PRODUCTS SET NAME = ?, MRP = ? WHERE ID = ?";
        int response    =   jdbcTemplate.update(sql,
                                product.getName(),
                                product.getMRP(),
                                product.getId()
                            );

        if(response==0)
            return  null;
        else
        {
            return Optional.ofNullable(product);
        }
    }

    public boolean delete(int id)
    {
        String sql      =   "DELETE FROM PRODUCTS WHERE ID = ?";
        int response    =   jdbcTemplate.update(sql,id);
        return  response>0;
    }
}
