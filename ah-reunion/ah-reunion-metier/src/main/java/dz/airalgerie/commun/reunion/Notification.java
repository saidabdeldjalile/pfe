package dz.airalgerie.commun.reunion;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "NOTIFICATION")
public class Notification implements Serializable {

    private static final long serialVersionUID = 1L;

    
   
    @Column(name = "ID_NOTIF")
    private int id;
    @Id
    @ManyToOne
    @JoinColumn(name = "REUNION_ID")
    private Reunion reunion;

    @ManyToOne
    @JoinColumn(name = "EMPLOYE_MATRICULE")
    private Employe employe;

    @Column(name = "MESSAGE", length = 500)
    private String message;

    @Column(name = "DATE_DEBUT")
    private LocalDateTime dateDebut;

    // Constructeurs, getters et setters

    public Notification() {
    }

  public Notification(int id, Reunion reunion, Employe employe, String message, LocalDateTime dateDebut) {
    this.id = id;
    this.reunion = reunion;
    this.employe = employe;
    this.message = message;
    this.dateDebut = dateDebut;
}


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Reunion getReunion() {
        return reunion;
    }

    public void setReunion(Reunion reunion) {
        this.reunion = reunion;
    }

    public Employe getEmploye() {
        return employe;
    }

    public void setEmploye(Employe employe) {
        this.employe = employe;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(LocalDateTime dateDebut) {
        this.dateDebut = dateDebut;
    }

    // Autres méthodes éventuelles

    @Override
    public String toString() {
        return "Notification [id=" + id + ", reunion=" + reunion + ", employe=" + employe + ", message=" + message
                + ", dateDebut=" + dateDebut + "]";
    }
}
