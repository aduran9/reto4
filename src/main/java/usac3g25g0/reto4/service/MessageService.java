package usac3g25g0.reto4.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import usac3g25g0.reto4.model.Message;

@Component
public interface MessageService {
    
    public List<Message> listarMensajes();
    public Optional<Message> listarMensajeId(Integer id);
    public Message crearMensaje(Message mensaje);
    public boolean borrarMensaje(Integer id);
    public Message actualizaMensaje(Message mensaje);
}
