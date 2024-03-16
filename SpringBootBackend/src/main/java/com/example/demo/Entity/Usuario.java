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
public class Usuario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;

    private String contrasenia;
    private String nombres;

    private String apellidos;
    /* 
    @OneToMany(mappedBy = "usuario")
    private Set<UsuarioRol> usuarioRol;
    */
}
