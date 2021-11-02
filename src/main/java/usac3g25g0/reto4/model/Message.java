package usac3g25g0.reto4.model;

import java.io.Serializable;

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
@Table(name = "message")
/**
 * Class Message
 */
public class Message implements Serializable {

    @Id
    @GeneratedValue (strategy=GenerationType.IDENTITY)
    private Integer idMessage;

    @Column(length = 250)
    private String messageText;    

    /**
     * Relacion muchos a uno con entidad Costume
     */
    @ManyToOne
    @JoinColumn(name = "fk_id_costume")
    @JsonIgnoreProperties({"messages", "reservations"})
    private Costume costume;

    /**
     * Relacion muchos a uno con entidad cliente
     */
    @ManyToOne
    @JoinColumn(name = "fk_id_client")
    @JsonIgnoreProperties({"messages", "reservations"})
    private Client client;

    public Message() {
        /**
         * Constructor vacio
         */
    }

    public Message(Integer idMessage, String messageText, Costume costume, Client client) {
        this.idMessage = idMessage;
        this.messageText = messageText;
        this.costume = costume;
        this.client = client;
    }

    public Integer getIdMessage() {
        return idMessage;
    }

    public void setIdMessage(Integer idMessage) {
        this.idMessage = idMessage;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
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

}
