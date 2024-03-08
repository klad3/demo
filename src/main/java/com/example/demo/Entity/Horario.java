package com.example.demo.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Horario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idHorario;

    private Integer horaInicio;
    private Integer horaFin;

    @ManyToOne
    @JoinColumn(name = "idCurso", insertable = false, updatable = false)
    private Curso curso;

    @ManyToOne
    @JoinColumn(name = "idProfesor", insertable = false, updatable = false)
    private Profesor profesor;
}
