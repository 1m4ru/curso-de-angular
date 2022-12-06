package com.maruan.crudspring.controller.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Conteiner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 200, nullable = false)
    private String client;

    @Column(length = 10, nullable = false)
    private String numberOfConteiner;

    @Column(length = 10, nullable = false)
    private String type;

    @Column(length = 20, nullable = false)
    private String status;

    @Column(length = 20, nullable = false)
    private String category;

}
