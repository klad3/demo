package com.example.demo.Service;

import java.util.List;

import com.example.demo.Entity.Rol;

public interface RolService {
    
    List<Rol> listarRoles();

    Rol obtenerRol(Long id);

    Rol guardarRol(Rol rol);

    void eliminarRol(Long id);

    void actualizarRol(Long id, Rol rol);
}
