package com.example.demo.ServiceImpl;


import com.example.demo.Entity.Profesor;
import jakarta.persistence.EntityNotFoundException;
import com.example.demo.Repository.ProfesorRepository;
import com.example.demo.Service.ProfesorService;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProfesorServiceImpl implements ProfesorService {

     private final ProfesorRepository ProfesorRepository;

    public List<Profesor> listarProfesores() {
        return ProfesorRepository.findAll();
    }

    public Profesor obtenerProfesor(Long id) {
        return ProfesorRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Profesor no encontrado"));
    }

    public Profesor guardarProfesor(Profesor Profesor) {
        return ProfesorRepository.save(Profesor);
    }

    public void eliminarProfesor(Long id) {
        ProfesorRepository.deleteById(id);
    }

}
