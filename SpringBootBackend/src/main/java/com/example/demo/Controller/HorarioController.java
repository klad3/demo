package com.example.demo.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Controller.Dto.HorarioDto;
import com.example.demo.Entity.Horario;
import com.example.demo.Service.HorarioService;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/api/horarios")
@RequiredArgsConstructor
public class HorarioController {

    private final HorarioService horarioService;

    @PostMapping
    public ResponseEntity<Horario> crearHorario(@RequestBody HorarioDto horarioDto) {

        Horario nuevoHorario = horarioService.guardarHorario(horarioDto);
        return new ResponseEntity<>(nuevoHorario, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Horario>> listarTodosLosHorarios() {
        List<Horario> Horarios = horarioService.listaHorarios();
        return ResponseEntity.ok(Horarios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Horario> obtenerDetallesDeHorario(@PathVariable Long id) {
        Horario Horario = horarioService.obtenerHorario(id);
        return ResponseEntity.ok(Horario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Horario> actualizarHorario(@PathVariable Long id, @RequestBody Horario Horario) {
        Horario HorarioActualizado = horarioService.actualizarHorario(id, Horario);
        return ResponseEntity.ok(HorarioActualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarHorario(@PathVariable Long id) {
        horarioService.eliminarHorario(id);
        return ResponseEntity.noContent().build();
    }
}
