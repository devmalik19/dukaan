package devmalik90.dukaan.models;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;

@Entity
public class Product 
{
    @Id
    private int id;

    @Column
    private UUID uuid;

    @Column
    private String name;

    @Column
    private String mrp;

    public Product(int id,UUID uuid, String name, String mrp) 
    {
        this.id     =   id;
        this.uuid   =   uuid;
        this.name   =   name;
        this.mrp    =   mrp;
    }

    public UUID generateUUID()
    {
        uuid = UUID.randomUUID();
        return uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMRP() {
        return mrp;
    }

    public void setMRP(String mrp) {
        this.mrp = mrp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public UUID getUUID() {
        return uuid;
    }

    public void setUUID(UUID uuid) {
        this.uuid = uuid;
    }
}
