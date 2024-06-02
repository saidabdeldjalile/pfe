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
@Table(name = "PAYS", schema = "CF")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PaysEcofie.findAll", query = "SELECT p FROM PaysEcofie p")
    , @NamedQuery(name = "PaysEcofie.findById", query = "SELECT p FROM PaysEcofie p WHERE p.id = :id")
    , @NamedQuery(name = "PaysEcofie.findByNomPays", query = "SELECT p FROM PaysEcofie p WHERE p.nomPays = :nomPays")})
public class PaysEcofie implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NOM_PAYS")
    private String nomPays;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pays")
    private List<ContratEcofie> contratEcofieList;

    public PaysEcofie() {
    }

    public PaysEcofie(Integer id) {
        this.id = id;
    }

    public PaysEcofie(Integer id, String nomPays) {
        this.id = id;
        this.nomPays = nomPays;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomPays() {
        return nomPays;
    }

    public void setNomPays(String nomPays) {
        this.nomPays = nomPays;
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
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PaysEcofie)) {
            return false;
        }
        PaysEcofie other = (PaysEcofie) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dz.airalgerie.gfc.model.entities.ecofie.PaysEcofie[ id=" + id + " ]";
    }

}
