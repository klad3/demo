package com.example.demo.ServiceImpl;


import com.example.demo.Entity.Rol;
import jakarta.persistence.EntityNotFoundException;
import com.example.demo.Repository.RolRepository;
import com.example.demo.Service.RolService;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RolServiceImpl implements RolService {

     private final RolRepository rolRepository;

    public List<Rol> listarRoles() {
        return rolRepository.findAll();
    }

    public Rol obtenerRol(Long id) {
        return rolRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Rol no encontrado"));
    }

    public Rol guardarRol(Rol Rol) {
        return rolRepository.save(Rol);
    }

    public void actualizarRol(Long id, Rol rolActualizado) {
        Rol Rol = rolRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Rol no encontrado"));

        // Actualiza los datos del Rol
        Rol.setNombre(rolActualizado.getNombre());
        Rol.setDescripcion(rolActualizado.getDescripcion());

        rolRepository.save(Rol);
    }

    public void eliminarRol(Long id) {
        rolRepository.deleteById(id);
    }

}
