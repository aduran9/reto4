package usac3g25g0.reto4.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import usac3g25g0.reto4.model.Reservation;

@Repository
public interface ReservationRepository extends CrudRepository<Reservation, Integer>{
    
}
