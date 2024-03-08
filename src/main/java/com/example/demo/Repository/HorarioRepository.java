package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.Horario;

@Repository
public interface HorarioRepository extends JpaRepository<Horario, Long> {
}
