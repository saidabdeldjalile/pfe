/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dz.airalgerie.ops.model.entities;

import dz.airalgerie.commun.utils.ErpConstante;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
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
@Table(name = "DL_STRUCTURE", schema = ErpConstante.DbSchemaName.OPS)
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DlStructure.findAll", query = "SELECT d FROM DlStructure d")
    , @NamedQuery(name = "DlStructure.findById", query = "SELECT d FROM DlStructure d WHERE d.id = :id")
    , @NamedQuery(name = "DlStructure.findByStructure", query = "SELECT d FROM DlStructure d WHERE d.structure = :structure")
    , @NamedQuery(name = "DlStructure.findByDescription", query = "SELECT d FROM DlStructure d WHERE d.description = :description")
    , @NamedQuery(name = "DlStructure.findByCodeDir", query = "SELECT d FROM DlStructure d WHERE d.codeDir = :codeDir")
    , @NamedQuery(name = "DlStructure.findByDateDeb", query = "SELECT d FROM DlStructure d WHERE d.dateDeb = :dateDeb")
    , @NamedQuery(name = "DlStructure.findByDateFin", query = "SELECT d FROM DlStructure d WHERE d.dateFin = :dateFin")})
public class DlStructure implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Size(max = 50)
    @Column(name = "STRUCTURE")
    private String structure;
    @Size(max = 255)
    @Column(name = "DESCRIPTION")
    private String description;
    @Size(max = 2)
    @Column(name = "CODE_DIR")
    private String codeDir;
    @Column(name = "DATE_DEB")
    private LocalDate dateDeb;
    @Column(name = "DATE_FIN")
    private LocalDate dateFin;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idStructure",fetch = FetchType.LAZY)
    @BatchFetch(BatchFetchType.IN)
    private List<DlCodes> dlCodesList;

    public DlStructure() {
    }

    public DlStructure(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStructure() {
        return structure;
    }

    public void setStructure(String structure) {
        this.structure = structure;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCodeDir() {
        return codeDir;
    }

    public void setCodeDir(String codeDir) {
        this.codeDir = codeDir;
    }

    public LocalDate getDateDeb() {
        return dateDeb;
    }

    public void setDateDeb(LocalDate dateDeb) {
        this.dateDeb = dateDeb;
    }

    public LocalDate getDateFin() {
        return dateFin;
    }

    public void setDateFin(LocalDate dateFin) {
        this.dateFin = dateFin;
    }

    @XmlTransient
    public List<DlCodes> getDlCodesList() {
        return dlCodesList;
    }

    public void setDlCodesList(List<DlCodes> dlCodesList) {
        this.dlCodesList = dlCodesList;
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
        if (!(object instanceof DlStructure)) {
            return false;
        }
        DlStructure other = (DlStructure) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dz.airalgerie.ops.model.entities.DlStructure[ id=" + id + " ]";
    }
    
}
