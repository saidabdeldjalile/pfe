/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.gfc.model.entities.ecofie;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author kehli
 */
@Entity
@Table(name = "CODE_CONTRAT_ECOFIE", schema = "CF")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CodeContratEcofie.findAll", query = "SELECT c FROM CodeContratEcofie c")
    , @NamedQuery(name = "CodeContratEcofie.findByCode", query = "SELECT c FROM CodeContratEcofie c WHERE c.code = :code")
    , @NamedQuery(name = "CodeContratEcofie.findByLibelle", query = "SELECT c FROM CodeContratEcofie c WHERE c.libelle = :libelle")})
public class CodeContratEcofie implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CODE")
    private Integer code;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "LIBELLE")
    private String libelle;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "code")
    private List<ContratEcofie> contratEcofieList;

    public CodeContratEcofie() {
    }

    public CodeContratEcofie(Integer code) {
        this.code = code;
    }

    public CodeContratEcofie(Integer code, String libelle) {
        this.code = code;
        this.libelle = libelle;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    @XmlTransient
    public List<ContratEcofie> getContratEcofieList() {
        return contratEcofieList;
    }

    public void setContratEcofieList(List<ContratEcofie> contratEcofieList) {
        this.contratEcofieList = contratEcofieList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (code != null ? code.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CodeContratEcofie)) {
            return false;
        }
        CodeContratEcofie other = (CodeContratEcofie) object;
        if ((this.code == null && other.code != null) || (this.code != null && !this.code.equals(other.code))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dz.airalgerie.gfc.model.entities.ecofie.CodeContratEcofie[ code=" + code + " ]";
    }

}
