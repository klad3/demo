package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.GradoXNivel;

@Repository
public interface GradoXNivelRepository extends JpaRepository<GradoXNivel, Integer> {


}
