/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dz.airalgerie.ops.model.entities;

import dz.airalgerie.commun.utils.ErpConstante;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Basic;
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
@Table(name = "TYPE_AVION", schema = ErpConstante.DbSchemaName.OPS)
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TypeAvion.findAll", query = "SELECT t FROM TypeAvion t")
    , @NamedQuery(name = "TypeAvion.findById", query = "SELECT t FROM TypeAvion t WHERE t.id = :id")
    , @NamedQuery(name = "TypeAvion.findByCodeOaci", query = "SELECT t FROM TypeAvion t WHERE t.codeOaci = :codeOaci")
    , @NamedQuery(name = "TypeAvion.findByLibelle", query = "SELECT t FROM TypeAvion t WHERE t.libelle = :libelle")
    , @NamedQuery(name = "TypeAvion.findByNbMoteurs", query = "SELECT t FROM TypeAvion t WHERE t.nbMoteurs = :nbMoteurs")
    , @NamedQuery(name = "TypeAvion.findByCapacitePax", query = "SELECT t FROM TypeAvion t WHERE t.capacitePax = :capacitePax")
    , @NamedQuery(name = "TypeAvion.findByCapaciteFuel", query = "SELECT t FROM TypeAvion t WHERE t.capaciteFuel = :capaciteFuel")
    , @NamedQuery(name = "TypeAvion.findByCapaciteSoute", query = "SELECT t FROM TypeAvion t WHERE t.capaciteSoute = :capaciteSoute")
    , @NamedQuery(name = "TypeAvion.findByPoidsMaxDecollage", query = "SELECT t FROM TypeAvion t WHERE t.poidsMaxDecollage = :poidsMaxDecollage")
    , @NamedQuery(name = "TypeAvion.findByCruiseSpeed", query = "SELECT t FROM TypeAvion t WHERE t.cruiseSpeed = :cruiseSpeed")
    , @NamedQuery(name = "TypeAvion.findByMaxSpeed", query = "SELECT t FROM TypeAvion t WHERE t.maxSpeed = :maxSpeed")
    , @NamedQuery(name = "TypeAvion.findByEtops", query = "SELECT t FROM TypeAvion t WHERE t.etops = :etops")
    , @NamedQuery(name = "TypeAvion.findByPoidsAVide", query = "SELECT t FROM TypeAvion t WHERE t.poidsAVide = :poidsAVide")})
public class TypeAvion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Size(max = 10)
    @Column(name = "CODE_OACI")
    private String codeOaci;
    @Size(max = 150)
    @Column(name = "LIBELLE")
    private String libelle;
    @Column(name = "NB_MOTEURS")
    private Integer nbMoteurs;
    @Column(name = "CAPACITE_PAX")
    private Integer capacitePax;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "CAPACITE_FUEL")
    private BigDecimal capaciteFuel;
    @Column(name = "CAPACITE_SOUTE")
    private BigDecimal capaciteSoute;
    @Column(name = "POIDS_MAX_DECOLLAGE")
    private BigDecimal poidsMaxDecollage;
    @Column(name = "CRUISE_SPEED")
    private BigDecimal cruiseSpeed;
    @Column(name = "MAX_SPEED")
    private BigDecimal maxSpeed;
    @Column(name = "ETOPS")
    private Integer etops;
    @Column(name = "POIDS_A_VIDE")
    private BigDecimal poidsAVide;
    @OneToMany(mappedBy = "typeAvionId",fetch = FetchType.LAZY)
    @BatchFetch(BatchFetchType.IN)
    private List<Avion> avionList;

    public TypeAvion() {
    }

    public TypeAvion(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodeOaci() {
        return codeOaci;
    }

    public void setCodeOaci(String codeOaci) {
        this.codeOaci = codeOaci;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Integer getNbMoteurs() {
        return nbMoteurs;
    }

    public void setNbMoteurs(Integer nbMoteurs) {
        this.nbMoteurs = nbMoteurs;
    }

    public Integer getCapacitePax() {
        return capacitePax;
    }

    public void setCapacitePax(Integer capacitePax) {
        this.capacitePax = capacitePax;
    }

    public BigDecimal getCapaciteFuel() {
        return capaciteFuel;
    }

    public void setCapaciteFuel(BigDecimal capaciteFuel) {
        this.capaciteFuel = capaciteFuel;
    }

    public BigDecimal getCapaciteSoute() {
        return capaciteSoute;
    }

    public void setCapaciteSoute(BigDecimal capaciteSoute) {
        this.capaciteSoute = capaciteSoute;
    }

    public BigDecimal getPoidsMaxDecollage() {
        return poidsMaxDecollage;
    }

    public void setPoidsMaxDecollage(BigDecimal poidsMaxDecollage) {
        this.poidsMaxDecollage = poidsMaxDecollage;
    }

    public BigDecimal getCruiseSpeed() {
        return cruiseSpeed;
    }

    public void setCruiseSpeed(BigDecimal cruiseSpeed) {
        this.cruiseSpeed = cruiseSpeed;
    }

    public BigDecimal getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(BigDecimal maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public Integer getEtops() {
        return etops;
    }

    public void setEtops(Integer etops) {
        this.etops = etops;
    }

    public BigDecimal getPoidsAVide() {
        return poidsAVide;
    }

    public void setPoidsAVide(BigDecimal poidsAVide) {
        this.poidsAVide = poidsAVide;
    }

    @XmlTransient
    public List<Avion> getAvionList() {
        return avionList;
    }

    public void setAvionList(List<Avion> avionList) {
        this.avionList = avionList;
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
        if (!(object instanceof TypeAvion)) {
            return false;
        }
        TypeAvion other = (TypeAvion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dz.airalgerie.ops.model.entities.TypeAvion[ id=" + id + " ]";
    }
    
}
