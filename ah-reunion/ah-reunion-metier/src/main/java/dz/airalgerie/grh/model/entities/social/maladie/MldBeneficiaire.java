/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this
 * license Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package dz.airalgerie.grh.model.entities.social.maladie;

import dz.airalgerie.commun.utils.ErpConstante.DbSchemaName;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 */
@Entity
@Table(name = "CODE_BENEFICIAIRE", schema = DbSchemaName.GRH_MLD)
@NamedQueries({
    @NamedQuery(name = "MldBeneficiaire.findAll", query = "SELECT b FROM MldBeneficiaire b")})
public class MldBeneficiaire implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "CODE_BENEF")
    private String codeBenef;
    @Size(max = 255)
    @Column(name = "LIBELLE")
    private String libelle;

    public MldBeneficiaire() {
    }

    public MldBeneficiaire(String codeBenef) {
        this.codeBenef = codeBenef;
    }

    public String getCodeBenef() {
        return codeBenef;
    }

    public void setCodeBenef(String codeBenef) {
        this.codeBenef = codeBenef;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codeBenef != null ? codeBenef.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MldBeneficiaire)) {
            return false;
        }
        MldBeneficiaire other = (MldBeneficiaire) object;
        if ((this.codeBenef == null && other.codeBenef != null) || (this.codeBenef != null && !this.codeBenef.equals(other.codeBenef))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dz.airalgerie.grh.model.entities.social.maladie.Beneficiaire[ codeBenef=" + codeBenef + " ]";
    }

}
