package usac3g25g0.reto4.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "reservation")
/**
 * Clase Reservation
 */
public class Reservation implements Serializable{
        
    @Id
    @GeneratedValue (strategy=GenerationType.IDENTITY)
    private Integer idReservation;

    @Column
    private Date startDate;
    private Date devolutionDate;
    private String status = "created";

    /**
     * Relacion muchos a uno con entidad Costume
     * 
     */
    @ManyToOne
    @JoinColumn(name = "fk_id_costume")
    @JsonIgnoreProperties({"reservations"})
    private Costume costume;

    /**
     * Relacion muchos a uno con entidad Client
     */
    @ManyToOne
    @JoinColumn(name = "fk_id_client")
    @JsonIgnoreProperties({"messages","reservations"})
    private Client client;

    private String score;

    public Reservation() {
        /**
         * Constructor vacio
         */
    }

    public Reservation(Integer idReservation, Date startDate, Date devolutionDate, String status, Costume costume,
            Client client, String score) {
        this.idReservation = idReservation;
        this.startDate = startDate;
        this.devolutionDate = devolutionDate;
        this.status = status;
        this.costume = costume;
        this.client = client;
        this.score = score;
    }

    public Integer getIdReservation() {
        return idReservation;
    }

    public void setIdReservation(Integer idReservation) {
        this.idReservation = idReservation;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getDevolutionDate() {
        return devolutionDate;
    }

    public void setDevolutionDate(Date devolutionDate) {
        this.devolutionDate = devolutionDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Costume getCostume() {
        return costume;
    }

    public void setCostume(Costume costume) {
        this.costume = costume;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

}
