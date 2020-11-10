package com.example.testservicews.entity;

import javax.persistence.*;

@Table
@Entity
public class Mobile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @SequenceGenerator(name = "mobile_seq", sequenceName = "mobile_seq")
    private Long id;
    private String model;
    @Column(name = "opersys")
    private String operSys;
    private Integer memory;

    public Integer getMemory() {
        return memory;
    }

    public void setMemory(Integer year) {
        this.memory = year;
    }

    public Mobile() {
    }

    public Mobile(String model, String operSys, Integer memory) {
        this.model = model;
        this.memory = memory;
        this.operSys = operSys;
    }

    public String getOperSys() {
        return operSys;
    }

    public void setOperSys(String os) {
        this.operSys = os;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
