package com.example.demo.Controller;

import com.example.demo.Entity.Profesor;
import com.example.demo.Service.ProfesorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/profesores")
@RequiredArgsConstructor
public class ProfesorController {

    private final ProfesorService profesorService;
 
    @GetMapping
    public ResponseEntity<List<Profesor>> listarTodosLosProfesors() {
        List<Profesor> Profesors = profesorService.listarProfesores();
        return new ResponseEntity<>(Profesors, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Profesor> obtenerProfesorPorId(@PathVariable Long id) {
        Profesor Profesor = profesorService.obtenerProfesor(id);
        return new ResponseEntity<>(Profesor, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Profesor> crearProfesor(@RequestBody Profesor Profesor) {
        Profesor nuevoProfesor = profesorService.guardarProfesor(Profesor);
        return new ResponseEntity<>(nuevoProfesor, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarProfesor(@PathVariable Long id) {
        profesorService.eliminarProfesor(id);
        return ResponseEntity.noContent().build();
    }

}
