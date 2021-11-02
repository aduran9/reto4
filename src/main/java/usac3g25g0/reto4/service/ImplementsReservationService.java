package usac3g25g0.reto4.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import usac3g25g0.reto4.model.Reservation;
import usac3g25g0.reto4.repository.ReservationRepository;

@Service
public class ImplementsReservationService implements ReservationService{

    @Autowired
    ReservationRepository repositorioReservacion;

    @Override
    public List<Reservation> listarReservaciones() {
        return (List<Reservation>) repositorioReservacion.findAll();
    }

    @Override
    public Optional<Reservation> listarReservacionId(Integer id) {
        return repositorioReservacion.findById(id);
    }

    @Override
    public Reservation crearReservacion(Reservation reservacion) {
        return repositorioReservacion.save(reservacion);
    }

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

    /**
    @Override
    public Reservation crearReservacion(Reservation reservacion) {
        // TODO Auto-generated method stub
        return null;
    }    
    */

}
