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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Estudiante;
import com.example.demo.Service.EstudianteService;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/api/estudiantes")
@RequiredArgsConstructor
public class EstudianteController {

    private final EstudianteService estudianteService;

    @PostMapping("/matricular")
    public ResponseEntity<Estudiante> matricularEstudiante(@RequestBody Estudiante estudiante, @RequestParam Integer idAula) {
        Estudiante estudianteMatriculado = estudianteService.matricularEstudiante(estudiante, idAula);
        return new ResponseEntity<>(estudianteMatriculado, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Estudiante>> listarTodosLosEstudiantes() {
        List<Estudiante> estudiantes = estudianteService.listarTodosLosEstudiantes();
        return ResponseEntity.ok(estudiantes);
    }

    @GetMapping("/aula/{idAula}")
    public ResponseEntity<List<Estudiante>> listarEstudiantesPorAula(@PathVariable Integer idAula) {
        List<Estudiante> estudiantes = estudianteService.listarEstudiantesPorAula(idAula);
        return ResponseEntity.ok(estudiantes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Estudiante> obtenerDetallesDeEstudiante(@PathVariable Long id) {
        Estudiante estudiante = estudianteService.obtenerDetallesDeEstudiante(id);
        return ResponseEntity.ok(estudiante);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Estudiante> actualizarEstudiante(@PathVariable Long id, @RequestBody Estudiante estudiante) {
        Estudiante estudianteActualizado = estudianteService.actualizarEstudiante(id, estudiante);
        return ResponseEntity.ok(estudianteActualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarMatriculaDeEstudiante(@PathVariable Long id) {
        estudianteService.eliminarMatriculaDeEstudiante(id);
        return ResponseEntity.noContent().build();
    }
}
