package com.example.demo.Entity;


import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Aula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAula;

    private String nombre;
    private String capacidad;
    private String ubicacion;

    @ManyToOne
    @JoinColumn(name = "idSeccion", insertable = false, updatable = false)
    private Seccion seccion;

    @ManyToOne
    @JoinColumn(name = "idGradoNivel", insertable = false, updatable = false)
    private GradoXNivel gradoXNivel;

    @OneToMany(mappedBy = "aula")
    private List<Estudiante> estudiante;

}
