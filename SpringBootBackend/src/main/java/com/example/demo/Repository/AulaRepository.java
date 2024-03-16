package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.Aula;

@Repository
public interface AulaRepository extends JpaRepository<Aula, Long>{

}
