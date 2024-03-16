package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.Grado;

@Repository
public interface GradoRepository extends JpaRepository<Grado, Long> {

}
