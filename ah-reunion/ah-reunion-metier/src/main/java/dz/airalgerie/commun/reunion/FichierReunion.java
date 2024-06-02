package dz.airalgerie.commun.reunion;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "FICHIERS_REUNIONS")
public class FichierReunion implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "FICHIER_ID")
    private Integer fichierId;
    
    @Column(name = "FICHIER_NOM")
    private String fichierNom;
    
    @Column(name = "FICHIER_NOMBRE")
    private Integer fichierNombre; // Nouvel attribut ajouté
    

    public FichierReunion() {
    }

    public FichierReunion(Integer fichierId, String fichierNom, Integer fichierNombre) {
        this.fichierId = fichierId;
        this.fichierNom = fichierNom;
        this.fichierNombre = fichierNombre;
    }

    public Integer getFichierId() {
        return fichierId;
    }

    public void setFichierId(Integer fichierId) {
        this.fichierId = fichierId;
    }

    public String getFichierNom() {
        return fichierNom;
    }

    public void setFichierNom(String fichierNom) {
        this.fichierNom = fichierNom;
    }

    public Integer getFichierNombre() {
        return fichierNombre;
    }

    public void setFichierNombre(Integer fichierNombre) {
        this.fichierNombre = fichierNombre;
    }

    // Méthodes hashCode, equals et toString mises à jour pour inclure le nouvel attribut
    // ...

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fichierId != null ? fichierId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof FichierReunion)) {
            return false;
        }
        FichierReunion other = (FichierReunion) object;
        if ((this.fichierId == null && other.fichierId != null) || (this.fichierId != null && !this.fichierId.equals(other.fichierId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dz.airalgerie.product.FichierReunion[ fichierId=" + fichierId + " ]";
    }
}
