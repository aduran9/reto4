package usac3g25g0.reto4.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import usac3g25g0.reto4.model.Score;
import usac3g25g0.reto4.repository.ScoreRepository;

@Service
public class ImplementsScoreService implements ScoreService{

    @Autowired
    ScoreRepository repositorioCalificacion;

    @Override
    public List<Score> listarCalificaciones() {
        return (List<Score>) repositorioCalificacion.findAll();
    }

    @Override
    public Optional<Score> listarCalificacionId(Integer id) {
        return repositorioCalificacion.findById(id);
    }

    @Override
    public Score crearCalificacion(Score calificacion) {
        return repositorioCalificacion.save(calificacion);
    }

    @Override
    public boolean borrarCalificacion(Integer id) {
        boolean estado=true;
        if (repositorioCalificacion.findById(id).isPresent()){
            repositorioCalificacion.deleteById(id);
        }
        else{
            estado=false;
        }
        return estado;
    }

    @Override
    public Score actualizaCalificacion(Score calificacion) {

        if (repositorioCalificacion.findById(calificacion.getId()).isPresent()){
            
            Optional<Score> calificacionCopia = repositorioCalificacion.findById(calificacion.getId());

            if(calificacion.getScore()!=calificacionCopia.get().getScore()
                &&calificacion.getScore()!=null){
                    calificacionCopia.get().setScore(calificacion.getScore());
                }
                
            if(calificacion.getScoreMessage()!=calificacionCopia.get().getScoreMessage()
                &&!calificacion.getScoreMessage().isEmpty()){
                    calificacionCopia.get().setScoreMessage(calificacion.getScoreMessage());
                }

            return repositorioCalificacion.save(calificacionCopia.get());
        }
        else{
            return null;
        }
    }

}