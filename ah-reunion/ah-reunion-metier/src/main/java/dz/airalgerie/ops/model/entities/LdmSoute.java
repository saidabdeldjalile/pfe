/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this
 * license Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package dz.airalgerie.ops.model.entities;

import dz.airalgerie.commun.utils.ErpConstante;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Root
 */
@Entity
@Table(name = "LDM_SOUTE", schema = ErpConstante.DbSchemaName.OPS)
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LdmSoute.findAll", query = "SELECT l FROM LdmSoute l"),
    @NamedQuery(name = "LdmSoute.findByFDate", query = "SELECT l FROM LdmSoute l WHERE l.ldmSoutePK.fDate = :fDate"),
    @NamedQuery(name = "LdmSoute.findByFlt", query = "SELECT l FROM LdmSoute l WHERE l.ldmSoutePK.flt = :flt"),
    @NamedQuery(name = "LdmSoute.findBySuffix", query = "SELECT l FROM LdmSoute l WHERE l.ldmSoutePK.suffix = :suffix"),
    @NamedQuery(name = "LdmSoute.findByArr", query = "SELECT l FROM LdmSoute l WHERE l.ldmSoutePK.arr = :arr"),
    @NamedQuery(name = "LdmSoute.findByCompartiment", query = "SELECT l FROM LdmSoute l WHERE l.ldmSoutePK.compartiment = :compartiment"),
    @NamedQuery(name = "LdmSoute.findByQuantite", query = "SELECT l FROM LdmSoute l WHERE l.quantite = :quantite")})
public class LdmSoute implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected LdmSoutePK ldmSoutePK;
    @Column(name = "QUANTITE")
    private Integer quantite;

    public LdmSoute() {
    }

    public LdmSoute(LdmSoutePK ldmSoutePK) {
        this.ldmSoutePK = ldmSoutePK;
    }

    public LdmSoute(Date fDate, int flt, String suffix, String arr, String compartiment) {
        this.ldmSoutePK = new LdmSoutePK(fDate, flt, suffix, arr, compartiment);
    }

    public LdmSoutePK getLdmSoutePK() {
        return ldmSoutePK;
    }

    public void setLdmSoutePK(LdmSoutePK ldmSoutePK) {
        this.ldmSoutePK = ldmSoutePK;
    }

    public Integer getQuantite() {
        return quantite;
    }

    public void setQuantite(Integer quantite) {
        this.quantite = quantite;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ldmSoutePK != null ? ldmSoutePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LdmSoute)) {
            return false;
        }
        LdmSoute other = (LdmSoute) object;
        if ((this.ldmSoutePK == null && other.ldmSoutePK != null) || (this.ldmSoutePK != null && !this.ldmSoutePK.equals(other.ldmSoutePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dz.airalgerie.ops.model.entities.LdmSoute[ ldmSoutePK=" + ldmSoutePK + " ]";
    }

}
