package com.example.demo.ServiceImpl;


import com.example.demo.Entity.Usuario;
import jakarta.persistence.EntityNotFoundException;
import com.example.demo.Repository.UsuarioRepository;
import com.example.demo.Service.UsuarioService;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

     private final UsuarioRepository usuarioRepository;

    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    public Usuario obtenerUsuario(Long id) {
        return usuarioRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Usuario no encontrado"));
    }

    public Usuario guardarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public void eliminarUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }

}
