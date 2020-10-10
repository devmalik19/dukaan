package devmalik90.dukaan.models;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Product 
{
    @Id
    private UUID id;

    @Column
    private String name;

    @Column
    private String mrp;

    public Product(UUID id, String name, String mrp) 
    {
        this.id     =   UUID.randomUUID();
        this.name   =   name;
        this.mrp    =   mrp;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMrp() {
        return mrp;
    }

    public void setMrp(String mrp) {
        this.mrp = mrp;
    }
}
