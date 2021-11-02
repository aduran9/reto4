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

import usac3g25g0.reto4.model.Message;
import usac3g25g0.reto4.service.ImplementsMessageService;

@RestController
@RequestMapping("/api/Message")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class MessageController {
    
    @Autowired
    ImplementsMessageService serviciosMensaje;

    @GetMapping("/all")
    public List<Message> listadoMensajes() {
        return serviciosMensaje.listarMensajes();              
    }

    @GetMapping("/{id}")
    public Optional<Message> detalleMensaje(@PathVariable("id") Integer id){
        return serviciosMensaje.listarMensajeId(id);
    }

    @PostMapping("/save")  
    @ResponseStatus(HttpStatus.CREATED)
    public Message anadirMensaje(@RequestBody Message mensaje){
        return serviciosMensaje.crearMensaje(mensaje);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean eliminarMensaje(@PathVariable("id") Integer id){
        return serviciosMensaje.borrarMensaje(id);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Message actualizaMensaje(@RequestBody Message mensaje){
        return serviciosMensaje.actualizaMensaje(mensaje);
    }
}
