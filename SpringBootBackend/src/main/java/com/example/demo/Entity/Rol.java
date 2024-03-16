package com.example.demo.Entity;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Rol {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long idRol;

    private String nombre;
    private String descripcion;
    /* 
    @OneToMany(mappedBy = "rol")
    private Set<UsuarioRol> usuarioRol; 
    */
}
