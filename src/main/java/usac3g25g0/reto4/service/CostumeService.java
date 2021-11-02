package usac3g25g0.reto4.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import usac3g25g0.reto4.model.Costume;

@Component
public interface CostumeService {
    
    public List<Costume> listarDisfraces();
    public Optional<Costume> listarDisfrazId(Integer id);
    public Costume crearDisfraz(Costume disfraz);
    public boolean borrarDisfraz(Integer id);
    public Costume actualizaDisfraz(Costume disfraz);
}
