package usac3g25g0.reto4.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import usac3g25g0.reto4.model.Score;

@Component
public interface ScoreService {
    
    public List<Score> listarCalificaciones();
    public Optional<Score> listarCalificacionId(Integer id);
    public Score crearCalificacion(Score calificacion);
    public boolean borrarCalificacion(Integer id);
    public Score actualizaCalificacion(Score calificacion);
}
