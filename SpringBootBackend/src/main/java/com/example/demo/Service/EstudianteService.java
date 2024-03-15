package com.example.demo.Service;

import java.util.List;

import com.example.demo.Entity.Estudiante;

public interface EstudianteService {

    Estudiante matricularEstudiante(Estudiante estudiante, Integer idAula);
    List<Estudiante> listarTodosLosEstudiantes();
    List<Estudiante> listarEstudiantesPorAula(Integer idAula);
    Estudiante obtenerDetallesDeEstudiante(Long id);
    Estudiante actualizarEstudiante(Long id, Estudiante estudiante);
    void eliminarMatriculaDeEstudiante(Long id);
}
