package usac3g25g0.reto4.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import usac3g25g0.reto4.model.Message;
import usac3g25g0.reto4.repository.MessageRepository;

@Service
public class ImplementsMessageService implements MessageService{
    
    @Autowired
    MessageRepository repositorioMensaje;

    @Override
    public List<Message> listarMensajes() {
        return (List<Message>) repositorioMensaje.findAll();
    }

    @Override
    public Optional<Message> listarMensajeId(Integer id) {
        return repositorioMensaje.findById(id);
    }

    @Override
    public Message crearMensaje(Message mensaje) {
        return repositorioMensaje.save(mensaje);
    }

    @Override
    public boolean borrarMensaje(Integer id) {
        boolean estado=true;
        if (repositorioMensaje.findById(id).isPresent()){
            repositorioMensaje.deleteById(id);
        }
        else{
            estado=false;
        }
        return estado;
    }

    @Override
    public Message actualizaMensaje(Message mensaje) {

        if (repositorioMensaje.findById(mensaje.getIdMessage()).isPresent()){
            
            Optional<Message> mensajeCopia = repositorioMensaje.findById(mensaje.getIdMessage());

            if(mensaje.getMessageText()!=mensajeCopia.get().getMessageText()
                &&mensaje.getMessageText()!=null){
                    mensajeCopia.get().setMessageText(mensaje.getMessageText());
                }
                
            return repositorioMensaje.save(mensajeCopia.get());
        }
        else{
            return null;
        }
    }

    /**
    @Override
    public Message crearMensaje(Message mensaje) {
        // TODO Auto-generated method stub
        return null;
    }
    */

}
