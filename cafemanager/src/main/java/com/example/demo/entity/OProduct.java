package com.example.demo.entity;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Vardan on 05.09.2017.
 */
@Entity
@Table(name = "o_product")
public class OProduct {
    private long id;
    private int amount;
    private Set<Product> productSet;
    private Set<Reserv> reservSet;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }


    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "product_order", joinColumns = @JoinColumn(name = "oproduct_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "product_id", referencedColumnName = "id"))
    public Set<Product> getProductSet() {
        return productSet;
    }
    public void setProductSet(Set<Product> productSet) {
        this.productSet = productSet;
    }


    @ManyToMany(mappedBy = "oProductSet")
    public Set<Reserv> getReservSet() {
        return reservSet;
    }

    public void setReservSet(Set<Reserv> reservSet) {
        this.reservSet = reservSet;
    }

    @Override
    public String toString() {
        return "OProduct{" +
                "id=" + id +
                ", amount=" + amount +
                ", productSet=" + productSet +
                ", reservSet=" + reservSet +
                '}';
    }
}
