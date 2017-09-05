package com.example.demo.entity;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Vardan on 05.09.2017.
 */
@Entity
@Table(name = "product")
public class Product {

    private long id;
    private String name;
    private Set<OProduct> oProductSet;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @ManyToMany(mappedBy = "productSet")
    public Set<OProduct> getoProductSet() {
        return oProductSet;
    }

    public void setoProductSet(Set<OProduct> oProductSet) {
        this.oProductSet = oProductSet;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", oProductSet=" + oProductSet +
                '}';
    }
}
