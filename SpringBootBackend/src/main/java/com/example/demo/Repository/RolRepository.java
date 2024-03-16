package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.Rol;

@Repository
public interface RolRepository extends JpaRepository<Rol, Long> {

}
