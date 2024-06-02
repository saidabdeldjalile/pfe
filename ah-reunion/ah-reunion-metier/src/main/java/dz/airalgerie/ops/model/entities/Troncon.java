/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dz.airalgerie.ops.model.entities;

import dz.airalgerie.commun.utils.ErpConstante;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Root
 */
@Entity
@Table(name = "TRONCON", schema = ErpConstante.DbSchemaName.OPS)
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Troncon.findAll", query = "SELECT t FROM Troncon t")
    , @NamedQuery(name = "Troncon.findById", query = "SELECT t FROM Troncon t WHERE t.id = :id")
    , @NamedQuery(name = "Troncon.findByDistance", query = "SELECT t FROM Troncon t WHERE t.distance = :distance")
    , @NamedQuery(name = "Troncon.findByTauxZoneDesertJour", query = "SELECT t FROM Troncon t WHERE t.tauxZoneDesertJour = :tauxZoneDesertJour")
    , @NamedQuery(name = "Troncon.findByTauxZoneDesertNuit", query = "SELECT t FROM Troncon t WHERE t.tauxZoneDesertNuit = :tauxZoneDesertNuit")})
public class Troncon implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "DISTANCE")
    private BigDecimal distance;
    @Column(name = "TAUX_ZONE_DESERT_JOUR")
    private Integer tauxZoneDesertJour;
    @Column(name = "TAUX_ZONE_DESERT_NUIT")
    private Integer tauxZoneDesertNuit;
    @JoinColumn(name = "ARR", referencedColumnName = "CODE_IATA")
    @ManyToOne(fetch = FetchType.LAZY)
    private AeroportOps arr;
    @JoinColumn(name = "DEP", referencedColumnName = "CODE_IATA")
    @ManyToOne(fetch = FetchType.LAZY)
    private AeroportOps dep;

    public Troncon() {
    }

    public Troncon(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getDistance() {
        return distance;
    }

    public void setDistance(BigDecimal distance) {
        this.distance = distance;
    }

    public Integer getTauxZoneDesertJour() {
        return tauxZoneDesertJour;
    }

    public void setTauxZoneDesertJour(Integer tauxZoneDesertJour) {
        this.tauxZoneDesertJour = tauxZoneDesertJour;
    }

    public Integer getTauxZoneDesertNuit() {
        return tauxZoneDesertNuit;
    }

    public void setTauxZoneDesertNuit(Integer tauxZoneDesertNuit) {
        this.tauxZoneDesertNuit = tauxZoneDesertNuit;
    }

    public AeroportOps getArr() {
        return arr;
    }

    public void setArr(AeroportOps arr) {
        this.arr = arr;
    }

    public AeroportOps getDep() {
        return dep;
    }

    public void setDep(AeroportOps dep) {
        this.dep = dep;
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
        if (!(object instanceof Troncon)) {
            return false;
        }
        Troncon other = (Troncon) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dz.airalgerie.ops.model.entities.Troncon[ id=" + id + " ]";
    }
    
}
