package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.Clase;

@Repository
public interface ClaseRepository extends JpaRepository<Clase, Integer>{

}
