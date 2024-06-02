package dz.airalgerie.commun.reunion;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "REUNIONS")
public class Reunion implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "ID")
    private Integer id;
    
    @Column(name = "DATE_DEB")
    private LocalDateTime dateDeb;
    
    @Column(name = "DUREE") // Ajout de la colonne Durée
    private LocalTime duree;
    
    @Column(name = "TITRE")
    private String titre;
    
    @Column(name = "DETAIL")
    private String detaille;
    
    @Column(name = "NOMBRE_FICHIER") // Nouvel attribut ajouté
    private Integer nombreFichier;

    @ManyToMany
    @JoinTable(
            name = "REUNION_EMPLOYE",
            joinColumns = @JoinColumn(name = "ID_REUNION"),
            inverseJoinColumns = @JoinColumn(name = "MATRICULE_EMPLOYE"))
    Set<Employe> gestionreunion;

    public Reunion() {
    }

      public Reunion(Integer id, LocalDateTime dateDeb, String titre, String detaille, Integer nombreFichier, LocalTime duree) {
        this.id = id;
        this.dateDeb = dateDeb;
        this.titre = titre;
        this.detaille = detaille;
        this.nombreFichier = nombreFichier;
        this.duree = duree;
    }

    public Integer getId() {
        return id;
    }

    public LocalTime getDuree() {
        return duree;
    }

    public void setDuree(LocalTime duree) {
        this.duree = duree;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getDateDeb() {
        return dateDeb;
    }

    public void setDateDeb(LocalDateTime dateDeb) {
        this.dateDeb = dateDeb;
    }


    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDetaille() {
        return detaille;
    }

    public void setDetaille(String detaille) {
        this.detaille = detaille;
    }

    public Integer getNombreFichier() {
        return nombreFichier;
    }

    public void setNombreFichier(Integer nombreFichier) {
        this.nombreFichier = nombreFichier;
    }

    public Set<Employe> getGestionreunion() {
        return this.gestionreunion;
    }

    public void setGestionreunion(Set<Employe> gestionreunion) {
        this.gestionreunion = gestionreunion;
    }

    // Méthodes hashCode, equals et toString mises à jour pour inclure le nouvel attribut
    // ...

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Reunion)) {
            return false;
        }
        Reunion other = (Reunion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dz.airalgerie.product.Reunion[ id=" + id + " ]";
    }

    public FichierReunion getFichierReunion() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
