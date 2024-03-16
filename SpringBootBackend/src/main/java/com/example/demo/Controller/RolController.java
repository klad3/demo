package com.example.demo.Controller;

import com.example.demo.Entity.Rol;
import com.example.demo.Service.RolService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/roles")
@RequiredArgsConstructor
public class RolController {

    private final RolService rolService;
    @GetMapping
    public ResponseEntity<List<Rol>> listarTodosLosRoles() {
        List<Rol> roles = rolService.listarRoles();
        return new ResponseEntity<>(roles, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Rol> obtenerRolPorId(@PathVariable Long id) {
        Rol rol = rolService.obtenerRol(id);
        return new ResponseEntity<>(rol, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Rol> crearRol(@RequestBody Rol Rol) {
        Rol nuevoRol = rolService.guardarRol(Rol);
        return new ResponseEntity<>(nuevoRol, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> actualizarRol(@PathVariable Long id, @RequestBody Rol RolActualizado) {
        rolService.actualizarRol(id, RolActualizado); // Llama al método de servicio para actualizar el Rol
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarRol(@PathVariable Long id) {
        rolService.eliminarRol(id);
        return ResponseEntity.noContent().build();
    }
}
