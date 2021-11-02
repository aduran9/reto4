package usac3g25g0.reto4.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import usac3g25g0.reto4.model.Reservation;
import usac3g25g0.reto4.repository.ReservationRepository;


/**
 * @Author Andres Duran
 * Clase Implements Reservation Service
 */

@Service
public class ImplementsReservationService implements ReservationService{

     /**
     * Inyeccion de dependencias del repositorio
     */
    @Autowired
    ReservationRepository repositorioReservacion;

    /**
     * Metodo para obtener todos los registros
     */    
    @Override
    public List<Reservation> listarReservaciones() {
        return (List<Reservation>) repositorioReservacion.findAll();
    }

    /**
     * Metodo para obtener una reservacion por ID
     */
    @Override
    public Optional<Reservation> listarReservacionId(Integer id) {
        return repositorioReservacion.findById(id);
    }

    /**
     * Metodo para guardar registros
     * @param reservacion
     * @return
     */  
    @Override
    public Reservation crearReservacion(Reservation reservacion) {
        return repositorioReservacion.save(reservacion);
    }

    /**
     * Metodo para borrar registros
     * @param id
     */    
    @Override
    public boolean borrarReservacion(Integer id) {
        boolean estado=true;
        if (repositorioReservacion.findById(id).isPresent()){
            repositorioReservacion.deleteById(id);
        }
        else{
            estado=false;
        }
        return estado;
    }

    /**
     * Metodo para actualizar registros
     * @param reservacion
     * @return
     */    
    @Override
    public Reservation actualizaReservacion (Reservation reservacion) {

        if (repositorioReservacion.findById(reservacion.getIdReservation()).isPresent()){
            
            Optional<Reservation> reservacionCopia = repositorioReservacion.findById(reservacion.getIdReservation());

            if(reservacion.getStartDate()!=reservacionCopia.get().getStartDate()
                &&reservacion.getStartDate()!=null){
                    reservacionCopia.get().setStartDate(reservacion.getStartDate());
                }

            if(reservacion.getDevolutionDate()!=reservacionCopia.get().getDevolutionDate()
                &&reservacion.getDevolutionDate()!=null){
                    reservacionCopia.get().setDevolutionDate(reservacion.getDevolutionDate());
                }

            if(reservacion.getStatus()!=reservacionCopia.get().getStatus()
                &&reservacion.getStatus()!=null){
                    reservacionCopia.get().setStatus(reservacion.getStatus());
                }
            
            return repositorioReservacion.save(reservacionCopia.get());
        }
        else{
            return null;
        }
    }

}