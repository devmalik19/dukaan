package devmalik90.dukaan.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.UUID;

import javax.persistence.*;

@Entity
@Table(name = "PRODUCTS")
public class Product 
{
    @Id
    @Column(name = "ID")
    @GeneratedValue
    private int id;

    private String name;
    private String mrp;


    @JsonIgnore
    private UUID uuid;

    @Transient
    private String message;

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


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getMrp() {
        return mrp;
    }

    public void setMrp(String mrp) {
        this.mrp = mrp;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
