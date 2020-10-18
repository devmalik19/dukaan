package devmalik90.dukaan.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.UUID;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class Product
{
    @Id
    @Column(name = "ID")
    @GeneratedValue
    private Integer id;

    @NotBlank(message = "Name can not be blank")
    private String name;

    @NotBlank(message = "MRP can not be blank")
    private String mrp;

    @JsonIgnore
    private UUID uuid;

    @Transient
    @JsonInclude(JsonInclude.Include.NON_NULL)
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


    public Integer getId() {
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
