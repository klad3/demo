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
    public Curso crearCurso(Curso curso) {
        return cursoRepository.save(curso);
    }

    @Override
    public List<Curso> listarTodosLosCursos() {
        return cursoRepository.findAll();
    }

    @Override
    public Curso obtenerCursoPorId(Long id) {
        Optional<Curso> curso = cursoRepository.findById(id);
        if (!curso.isPresent()) {
            throw new RuntimeException("Curso no encontrado");
        }
        return curso.get();
    }

    @Override
    public Curso actualizarCurso(Long id, Curso curso) {
        Curso cursoExistente = obtenerCursoPorId(id);
        cursoExistente.setNombreCurso(curso.getNombreCurso());
        cursoExistente.setDescripcion(curso.getDescripcion());
        cursoExistente.setCantidadHoras(curso.getCantidadHoras());
        return cursoRepository.save(cursoExistente);
    }

    @Override
    public void eliminarCurso(Long id) {
        Curso curso = obtenerCursoPorId(id);
        cursoRepository.delete(curso);
    }
}
