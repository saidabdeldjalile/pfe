/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dz.airalgerie.ops.model.entities;

import dz.airalgerie.commun.utils.ErpConstante;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.eclipse.persistence.annotations.BatchFetch;
import org.eclipse.persistence.annotations.BatchFetchType;

/**
 *
 * @author Root
 */
@Entity
@Table(name = "TYPE_VOL", schema = ErpConstante.DbSchemaName.OPS)
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TypeVol.findAll", query = "SELECT t FROM TypeVol t")
    , @NamedQuery(name = "TypeVol.findByType", query = "SELECT t FROM TypeVol t WHERE t.type = :type")
    , @NamedQuery(name = "TypeVol.findByDescription", query = "SELECT t FROM TypeVol t WHERE t.description = :description")})
public class TypeVol implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "TYPE")
    private String type;
    @Size(max = 50)
    @Column(name = "DESCRIPTION")
    private String description;
    @OneToMany(mappedBy = "type",fetch = FetchType.LAZY)
    @BatchFetch(BatchFetchType.IN)
    private List<Vol> volList;

    public TypeVol() {
    }

    public TypeVol(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlTransient
    public List<Vol> getVolList() {
        return volList;
    }

    public void setVolList(List<Vol> volList) {
        this.volList = volList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (type != null ? type.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TypeVol)) {
            return false;
        }
        TypeVol other = (TypeVol) object;
        if ((this.type == null && other.type != null) || (this.type != null && !this.type.equals(other.type))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dz.airalgerie.ops.model.entities.TypeVol[ type=" + type + " ]";
    }
    
}
