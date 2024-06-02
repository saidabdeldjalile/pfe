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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "DL_CODES", schema = ErpConstante.DbSchemaName.OPS)
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DlCodes.findAll", query = "SELECT d FROM DlCodes d")
    , @NamedQuery(name = "DlCodes.findByCodeDl", query = "SELECT d FROM DlCodes d WHERE d.codeDl = :codeDl")
    , @NamedQuery(name = "DlCodes.findByDescription", query = "SELECT d FROM DlCodes d WHERE d.description = :description")
    , @NamedQuery(name = "DlCodes.findByRespons", query = "SELECT d FROM DlCodes d WHERE d.respons = :respons")
    , @NamedQuery(name = "DlCodes.findByDateDeb", query = "SELECT d FROM DlCodes d WHERE d.dateDeb = :dateDeb")
    , @NamedQuery(name = "DlCodes.findByDateFin", query = "SELECT d FROM DlCodes d WHERE d.dateFin = :dateFin")})
public class DlCodes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "CODE_DL")
    private String codeDl;
    @Size(max = 255)
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "RESPONS")
    private Integer respons;
    @Column(name = "DATE_DEB")
    private LocalDate dateDeb;
    @Column(name = "DATE_FIN")
    private LocalDate dateFin;
    @JoinColumn(name = "ID_CATEGORIE", referencedColumnName = "ID")
    @ManyToOne(optional = false,fetch = FetchType.LAZY)
    private DlCategorie idCategorie;
    @JoinColumn(name = "ID_STRUCTURE", referencedColumnName = "ID")
    @ManyToOne(optional = false,fetch = FetchType.LAZY)
    private DlStructure idStructure;
    @OneToMany(mappedBy = "cause",fetch = FetchType.LAZY)
    @BatchFetch(BatchFetchType.IN)
    private List<Delay> delayList;

    public DlCodes() {
    }

    public DlCodes(String codeDl) {
        this.codeDl = codeDl;
    }

    public String getCodeDl() {
        return codeDl;
    }

    public void setCodeDl(String codeDl) {
        this.codeDl = codeDl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getRespons() {
        return respons;
    }

    public void setRespons(Integer respons) {
        this.respons = respons;
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

    public DlCategorie getIdCategorie() {
        return idCategorie;
    }

    public void setIdCategorie(DlCategorie idCategorie) {
        this.idCategorie = idCategorie;
    }

    public DlStructure getIdStructure() {
        return idStructure;
    }

    public void setIdStructure(DlStructure idStructure) {
        this.idStructure = idStructure;
    }

    @XmlTransient
    public List<Delay> getDelayList() {
        return delayList;
    }

    public void setDelayList(List<Delay> delayList) {
        this.delayList = delayList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codeDl != null ? codeDl.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DlCodes)) {
            return false;
        }
        DlCodes other = (DlCodes) object;
        if ((this.codeDl == null && other.codeDl != null) || (this.codeDl != null && !this.codeDl.equals(other.codeDl))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dz.airalgerie.ops.model.entities.DlCodes[ codeDl=" + codeDl + " ]";
    }
    
}
