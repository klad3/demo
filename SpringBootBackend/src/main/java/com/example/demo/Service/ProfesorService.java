package com.example.demo.Service;

import java.util.List;

import com.example.demo.Controller.Dto.ProfesorDto;
import com.example.demo.Entity.Profesor;

public interface ProfesorService {
    
    List<Profesor> listarProfesores();

    Profesor guardarProfesor(ProfesorDto profesorDto);

    Profesor obtenerProfesor(Long id);

    Profesor actualizarProfesor(Long id, Profesor profesor);

    void eliminarProfesor(Long id);
}
