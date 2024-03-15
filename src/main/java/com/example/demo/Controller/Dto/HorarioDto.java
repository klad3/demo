package com.example.demo.Controller.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HorarioDto {
    private Long idHorario;
    private Integer horaInicio;
    private Integer horaFin;
    private Long idCurso;
    private Long idProfesor;
}
