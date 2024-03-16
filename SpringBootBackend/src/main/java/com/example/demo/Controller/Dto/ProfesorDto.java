package com.example.demo.Controller.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProfesorDto {
    private Long idProfesor;
    private String correo;
    private Long idUsuario;
}
