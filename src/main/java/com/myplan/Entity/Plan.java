package com.myplan.Entity;
import com.sun.istack.Nullable;

import javax.persistence.*;

import java.sql.Blob;
import java.util.List;

@Entity
@Table(name="plan")
public class Plan {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Blob image;

    private String numero;

    private String description;

    private Integer max_bureau;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Blob getImage() {
        return this.image;
    }

    public void setImage(Blob image) {
        this.image = image;
    }

    public String getNumero() {
        return this.numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getMax_bureau() {
        return this.max_bureau;
    }

    public void setMax_bureau(Integer max_bureau) {
        this.max_bureau = max_bureau;
    }

}