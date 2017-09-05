package com.example.demo.entity;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Vardan on 05.09.2017.
 */
@Entity
@Table(name = "reserv")
public class Reserv {

    private long Id;
    private Statuss statuss;
    private Set<OProduct> oProductSet;
    private CTable cTableByCTableId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }


    @Column(name = "statuss")
    @Enumerated(EnumType.STRING)
    public Statuss getStatuss() {
        return statuss;
    }

    public void setStatuss(Statuss statuss) {
        this.statuss = statuss;
    }

    @ManyToOne
    @JoinColumn(name = "reserv_id", referencedColumnName = "id", nullable = true)
    public CTable getcTableByCTableId() {
        return cTableByCTableId;
    }

    public void setcTableByCTableId(CTable cTableByCTableId) {
        this.cTableByCTableId = cTableByCTableId;
    }

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "orderedproduct_reserv", joinColumns = @JoinColumn(name = "reserv_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "oproduct_id", referencedColumnName = "id"))
    public Set<OProduct> getoProductSet() {
        return oProductSet;
    }

    public void setoProductSet(Set<OProduct> oProductSet) {
        this.oProductSet = oProductSet;
    }

    @Override
    public String toString() {
        return "Reserv{" +
                "Id=" + Id +
                ", statuss=" + statuss +
                ", oProductSet=" + oProductSet +
                ", cTableByCTableId=" + cTableByCTableId +
                '}';
    }
}
