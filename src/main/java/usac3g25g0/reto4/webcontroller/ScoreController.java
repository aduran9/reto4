package usac3g25g0.reto4.webcontroller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import usac3g25g0.reto4.model.Score;
import usac3g25g0.reto4.service.ImplementsScoreService;

@RestController
@RequestMapping("/api/Score")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class ScoreController {
    
    @Autowired
    ImplementsScoreService serviciosCalificacion;

    @GetMapping("/all")
    public List<Score> listadoCalificaciones() {
        return serviciosCalificacion.listarCalificaciones();              
    }

    @GetMapping("/{id}")
    public Optional<Score> detalleCalificacion(@PathVariable("id") Integer id){
        return serviciosCalificacion.listarCalificacionId(id);
    }

    @PostMapping("/save")  
    @ResponseStatus(HttpStatus.CREATED)
    public Score anadirCalificacion(@RequestBody Score calificacion){
        return serviciosCalificacion.crearCalificacion(calificacion);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean eliminarCalificacion(@PathVariable("id") Integer id){
        return serviciosCalificacion.borrarCalificacion(id);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Score actualizarCalificacion(@RequestBody Score calificacion){
        return serviciosCalificacion.actualizaCalificacion(calificacion);
    }
}
