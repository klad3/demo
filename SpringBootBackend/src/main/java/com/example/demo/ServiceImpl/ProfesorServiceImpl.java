package com.example.demo.ServiceImpl;


import com.example.demo.Controller.Dto.ProfesorDto;
import com.example.demo.Entity.Curso;
import com.example.demo.Entity.Horario;
import com.example.demo.Entity.Profesor;
import com.example.demo.Entity.Usuario;

import jakarta.persistence.EntityNotFoundException;

import com.example.demo.Repository.HorarioRepository;
import com.example.demo.Repository.ProfesorRepository;
import com.example.demo.Repository.UsuarioRepository;
import com.example.demo.Service.ProfesorService;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProfesorServiceImpl implements ProfesorService {

    private final ProfesorRepository profesorRepository;
    private final UsuarioRepository usuarioRepository;

    @Override
    public List<Profesor> listarProfesores() {
        return profesorRepository.findAll();
    }

    @Override
    public Profesor obtenerProfesor(Long id) {
        return profesorRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Profesor no encontrado"));
    }

    @Override
    public Profesor guardarProfesor(ProfesorDto profesorDto) {
        Usuario usuario = usuarioRepository.findById(profesorDto.getIdProfesor()).orElseThrow(() -> new RuntimeException("Profesor no encontrado"));

        Profesor profesor = Profesor.builder()
                .correo(profesorDto.getCorreo())
                .build();

        profesor.setUsuario(usuario);
        
        return profesorRepository.save(profesor);
    }

    @Override
    public Profesor actualizarProfesor(Long id, Profesor datosProfesor) {
        Profesor profesor = obtenerProfesor(id);
        profesor.setCorreo(datosProfesor.getCorreo());
        // Actualizar otros campos necesarios
        return profesorRepository.save(profesor);
    }


    @Override
    public void eliminarProfesor(Long id) {
        profesorRepository.deleteById(id);
    }

}
