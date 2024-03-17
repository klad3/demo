package com.example.demo.ServiceImpl;

import java.util.List;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Profesor;
import com.example.demo.Controller.Dto.HorarioDto;
import com.example.demo.Entity.Curso;
import com.example.demo.Entity.Horario;
import com.example.demo.Repository.CursoRepository;
import com.example.demo.Repository.HorarioRepository;
import com.example.demo.Repository.ProfesorRepository;
import com.example.demo.Service.HorarioService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class HorarioServiceImpl implements HorarioService {

    private final HorarioRepository HorarioRepository;
    private final ProfesorRepository profesorRepository;
    private final CursoRepository cursoRepository;



    @Override
    @Transactional
    /* 
    public Horario crearHorario(Horario Horario, Long idProfesor, Long idCurso) {
        // Encuentra el aula y asegúrate de que exista
        Profesor profesor = profesorRepository.findById(idProfesor).orElseThrow(() -> new RuntimeException("Profesor no encontrado"));
        Curso curso = cursoRepository.findById(idCurso).orElseThrow(() -> new RuntimeException("Curso no encontrado"));

        // Establece el aula y los cursos para el Horario
        Horario.setProfesor(profesor);
        Horario.setCurso(curso);

        // Guarda el Horario, esto también debería persistir la relación debido a la cascada
        return HorarioRepository.save(Horario);
    }
    */
    public Horario guardarHorario(HorarioDto horarioDto) {
        Profesor profesor = profesorRepository.findById(horarioDto.getIdProfesor()).orElseThrow(() -> new RuntimeException("Profesor no encontrado"));
        Curso curso = cursoRepository.findById(horarioDto.getIdCurso()).orElseThrow(() -> new RuntimeException("Curso no encontrado"));

        Horario horario = Horario.builder()
                .horaInicio(horarioDto.getHoraInicio())
                .horaFin(horarioDto.getHoraFin())
                .build();

        horario.setProfesor(profesor);
        horario.setCurso(curso);
        
        return HorarioRepository.save(horario);
    }


    @Override
    public List<Horario> listaHorarios() {
        return HorarioRepository.findAll();
    }

    @Override
    public Horario obtenerHorario(Long id) {
        return HorarioRepository.findById(id).orElseThrow(() -> new RuntimeException("Horario no encontrado"));
    }

    @Override
    public Horario actualizarHorario(Long id, Horario datosHorario) {
        Horario Horario = obtenerHorario(id);
        Horario.setHoraInicio(datosHorario.getHoraInicio());
        Horario.setHoraFin(datosHorario.getHoraFin());
        // Actualizar otros campos necesarios
        return HorarioRepository.save(Horario);
    }

    @Override
    public void eliminarHorario(Long id) {
        Horario Horario = obtenerHorario(id);
        HorarioRepository.delete(Horario);
    }
}
