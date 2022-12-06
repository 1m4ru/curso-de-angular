package com.maruan.crudspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.maruan.crudspring.controller.model.Conteiner;

@Repository
public interface ConteinerRepository extends JpaRepository<Conteiner, Long>{
    
}


