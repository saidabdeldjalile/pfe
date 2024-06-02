/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dz.airalgerie.gfc.model.entities.fac;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 */
@Entity
@Table(schema = "FAC", name = "CLOTURE_FACTURE")
public class ClotureFacture implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ClotureFacturePK clotureFacturePK;
    @Column(name = "IS_CLOTURE")
    private Boolean isCloture;

    public ClotureFacture() {
    }

    public ClotureFacture(ClotureFacturePK clotureFacturePK) {
        this.clotureFacturePK = clotureFacturePK;
    }

    public ClotureFacture(String codeUnite, int dateTrt) {
        this.clotureFacturePK = new ClotureFacturePK(codeUnite, dateTrt);
    }

    public ClotureFacturePK getClotureFacturePK() {
        return clotureFacturePK;
    }

    public void setClotureFacturePK(ClotureFacturePK clotureFacturePK) {
        this.clotureFacturePK = clotureFacturePK;
    }

    public Boolean getIsCloture() {
        return isCloture;
    }

    public void setIsCloture(Boolean isCloture) {
        this.isCloture = isCloture;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (clotureFacturePK != null ? clotureFacturePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ClotureFacture)) {
            return false;
        }
        ClotureFacture other = (ClotureFacture) object;
        if ((this.clotureFacturePK == null && other.clotureFacturePK != null) || (this.clotureFacturePK != null && !this.clotureFacturePK.equals(other.clotureFacturePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dz.airalgerie.gfc.model.entities.fac.ClotureFacture[ clotureFacturePK=" + clotureFacturePK + " ]";
    }
    
}
