package com.example.demo.Service;

import java.util.List;

import com.example.demo.Entity.Horario;

public interface HorarioService {

    Horario crearHorario(Horario Horario, Long idProfesor, Long idCurso);
    List<Horario> listarTodosLosHorarios();
    Horario obtenerDetallesDeHorario(Long id);
    Horario actualizarHorario(Long id, Horario Horario);
    void eliminarHorario(Long id);
}
