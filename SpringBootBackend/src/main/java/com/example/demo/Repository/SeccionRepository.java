package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.Seccion;

@Repository
public interface SeccionRepository extends JpaRepository<Seccion, Integer> {

}
