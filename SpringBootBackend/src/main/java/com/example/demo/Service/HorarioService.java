package com.example.demo.Service;

import java.util.List;

import com.example.demo.Controller.Dto.HorarioDto;
import com.example.demo.Entity.Horario;

public interface HorarioService {

    Horario crearHorario(HorarioDto horarioDto);
    List<Horario> listarTodosLosHorarios();
    Horario obtenerDetallesDeHorario(Long id);
    Horario actualizarHorario(Long id, Horario Horario);
    void eliminarHorario(Long id);
}
