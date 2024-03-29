package com.example.demo.ServiceImpl;

import java.util.List;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Aula;
import com.example.demo.Entity.Estudiante;
import com.example.demo.Repository.AulaRepository;
import com.example.demo.Repository.EstudianteRepository;
import com.example.demo.Service.EstudianteService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EstudianteServiceImpl implements EstudianteService {

    private final EstudianteRepository estudianteRepository;
    private final AulaRepository aulaRepository;



    @Override
    @Transactional
    public Estudiante matricularEstudiante(Estudiante estudiante, Integer idAula) {
        // Encuentra el aula y asegúrate de que exista
        Aula aula = aulaRepository.findById(idAula).orElseThrow(() -> new RuntimeException("Aula no encontrada"));


        // Establece el aula y los cursos para el estudiante
        estudiante.setAula(aula);

        // Guarda el estudiante, esto también debería persistir la relación debido a la cascada
        return estudianteRepository.save(estudiante);
    }

    @Override
    public List<Estudiante> listarTodosLosEstudiantes() {
        return estudianteRepository.findAll();
    }

    @Override
    public List<Estudiante> listarEstudiantesPorAula(Integer idAula) {
        // Encuentra el aula y asegúrate de que exista
        Aula aula = aulaRepository.findById(idAula).orElseThrow(() -> new RuntimeException("Aula no encontrada"));

        List<Estudiante> estudiantes = aula.getEstudiante();

        return estudiantes;
    }

    @Override
    public Estudiante obtenerDetallesDeEstudiante(Long id) {
        return estudianteRepository.findById(id).orElseThrow(() -> new RuntimeException("Estudiante no encontrado"));
    }

    @Override
    public Estudiante actualizarEstudiante(Long id, Estudiante datosEstudiante) {
        Estudiante estudiante = obtenerDetallesDeEstudiante(id);
        estudiante.setDireccion(datosEstudiante.getDireccion());
        estudiante.setFechaNacimiento(datosEstudiante.getFechaNacimiento());
        // Actualizar otros campos necesarios
        return estudianteRepository.save(estudiante);
    }

    @Override
    public void eliminarMatriculaDeEstudiante(Long id) {
        Estudiante estudiante = obtenerDetallesDeEstudiante(id);
        estudianteRepository.delete(estudiante);
    }
}
