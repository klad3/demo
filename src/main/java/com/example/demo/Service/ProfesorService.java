package com.example.demo.Service;

import java.util.List;

import com.example.demo.Entity.Profesor;

public interface ProfesorService {
    
    List<Profesor> listarProfesores();

    Profesor obtenerProfesor(Long id);

    Profesor guardarProfesor(Profesor Profesor);

    void eliminarProfesor(Long id);
}
