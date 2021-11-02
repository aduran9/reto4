package usac3g25g0.reto4.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import usac3g25g0.reto4.model.Reservation;

@Component
public interface ReservationService {
 
    public List<Reservation> listarReservaciones();
    public Optional<Reservation> listarReservacionId(Integer id);
    public Reservation crearReservacion(Reservation reservacion);
    public boolean borrarReservacion(Integer id);
    public Reservation actualizaReservacion(Reservation reservacion);
}
