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
        Rol rol = rolRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Rol no encontrado"));
        rol.setNombre(rolActualizado.getNombre());
        rol.setDescripcion(rolActualizado.getDescripcion());

        rolRepository.save(rol);
    }

    public void eliminarRol(Long id) {
        rolRepository.deleteById(id);
    }

}
