package com.example.demo.Service;

import java.util.List;

import com.example.demo.Entity.Usuario;

public interface UsuarioService {
    
    List<Usuario> listarUsuarios();

    Usuario obtenerUsuario(Long id);

    Usuario guardarUsuario(Usuario usuario);

    void eliminarUsuario(Long id);

    void actualizarUsuario(Long id, Usuario usuario);
}
