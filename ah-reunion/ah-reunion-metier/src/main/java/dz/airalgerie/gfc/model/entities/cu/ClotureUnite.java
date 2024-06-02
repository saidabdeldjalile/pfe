/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dz.airalgerie.gfc.model.entities.cu;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Root
 */
@Entity
@Table(schema = "CU", name = "CLOTURE_UNITE")
@NamedQueries({
    @NamedQuery(name = "ClotureUnite.findAll", query = "SELECT c FROM ClotureUnite c")
    , @NamedQuery(name = "ClotureUnite.findByCodeUnite", query = "SELECT c FROM ClotureUnite c WHERE c.clotureUnitePK.codeUnite = :codeUnite")
    , @NamedQuery(name = "ClotureUnite.findByDateTrt", query = "SELECT c FROM ClotureUnite c WHERE c.clotureUnitePK.dateTrt = :dateTrt")
    , @NamedQuery(name = "ClotureUnite.findByIsCloture", query = "SELECT c FROM ClotureUnite c WHERE c.isCloture = :isCloture")})
public class ClotureUnite implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ClotureUnitePK clotureUnitePK;
    @Column(name = "IS_CLOTURE")
    private Boolean isCloture;

    public ClotureUnite() {
    }

    public ClotureUnite(ClotureUnitePK clotureUnitePK) {
        this.clotureUnitePK = clotureUnitePK;
    }

    public ClotureUnite(String codeUnite, int dateTrt) {
        this.clotureUnitePK = new ClotureUnitePK(codeUnite, dateTrt);
    }

    public ClotureUnitePK getClotureUnitePK() {
        return clotureUnitePK;
    }

    public void setClotureUnitePK(ClotureUnitePK clotureUnitePK) {
        this.clotureUnitePK = clotureUnitePK;
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
        hash += (clotureUnitePK != null ? clotureUnitePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ClotureUnite)) {
            return false;
        }
        ClotureUnite other = (ClotureUnite) object;
        if ((this.clotureUnitePK == null && other.clotureUnitePK != null) || (this.clotureUnitePK != null && !this.clotureUnitePK.equals(other.clotureUnitePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dz.airalgerie.gfc.model.entities.cu.ClotureUnite[ clotureUnitePK=" + clotureUnitePK + " ]";
    }
    
}
