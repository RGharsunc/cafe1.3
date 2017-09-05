package com.example.demo.entity;

import javax.persistence.*;

/**
 * Created by Vardan on 05.09.2017.
 */
@Entity
@Table(name = "ctable")
public class CTable {
    private long id;
    private String name;
    private Reserv reservByReservId;
    private User userByUserId;
    private Statuss statuss;

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
    public Reserv getReservByReservId() {
        return reservByReservId;
    }
    public void setReservByReservId(Reserv reservByReservId) {
        this.reservByReservId = reservByReservId;
    }


    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = true)
    public User getUserByUserId() {
        return userByUserId;
    }

    public void setUserByUserId(User userByUserId) {
        this.userByUserId = userByUserId;
    }

    @Override
    public String toString() {
        return "CTable{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", reservByReservId=" + reservByReservId +
                ", userByUserId=" + userByUserId +
                ", statuss=" + statuss +
                '}';
    }
}
