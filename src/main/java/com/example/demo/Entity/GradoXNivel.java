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
public class GradoXNivel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idGradoNivel;

    @ManyToOne
    @JoinColumn(name = "idGrado", insertable = false, updatable = false)
    private Grado grado;

    @ManyToOne
    @JoinColumn(name = "idNivel", insertable = false, updatable = false)
    private Nivel nivel;
}
