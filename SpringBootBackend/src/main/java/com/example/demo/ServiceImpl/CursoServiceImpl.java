package com.example.demo.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.Entity.Curso;
import com.example.demo.Repository.CursoRepository;
import com.example.demo.Service.CursoService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CursoServiceImpl implements CursoService {

    private final CursoRepository cursoRepository;


    @Override
    public Curso guardarCurso(Curso curso) {
        return cursoRepository.save(curso);
    }

    @Override
    public List<Curso> listarCursos() {
        return cursoRepository.findAll();
    }

    @Override
    public Curso obtenerCurso(Long id) {
        Optional<Curso> curso = cursoRepository.findById(id);
        if (!curso.isPresent()) {
            throw new RuntimeException("Curso no encontrado");
        }
        return curso.get();
    }

    @Override
    public Curso actualizarCurso(Long id, Curso curso) {
        Curso cursoExistente = obtenerCurso(id);
        cursoExistente.setNombreCurso(curso.getNombreCurso());
        cursoExistente.setDescripcion(curso.getDescripcion());
        cursoExistente.setCantidadHoras(curso.getCantidadHoras());
        return cursoRepository.save(cursoExistente);
    }

    @Override
    public void eliminarCurso(Long id) {
        Curso curso = obtenerCurso(id);
        cursoRepository.delete(curso);
    }
}
