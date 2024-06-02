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
@Table(name = "AEROPORT", schema = ErpConstante.DbSchemaName.OPS)
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AeroportOps.findAll", query = "SELECT a FROM AeroportOps a")
    , @NamedQuery(name = "AeroportOps.findByCodeIata", query = "SELECT a FROM AeroportOps a WHERE a.codeIata = :codeIata")
    , @NamedQuery(name = "AeroportOps.findByAeroDesc", query = "SELECT a FROM AeroportOps a WHERE a.aeroDesc = :aeroDesc")
    , @NamedQuery(name = "AeroportOps.findByCodeOaci", query = "SELECT a FROM AeroportOps a WHERE a.codeOaci = :codeOaci")
    , @NamedQuery(name = "AeroportOps.findByLatDeg", query = "SELECT a FROM AeroportOps a WHERE a.latDeg = :latDeg")
    , @NamedQuery(name = "AeroportOps.findByLatMin", query = "SELECT a FROM AeroportOps a WHERE a.latMin = :latMin")
    , @NamedQuery(name = "AeroportOps.findByLatSec", query = "SELECT a FROM AeroportOps a WHERE a.latSec = :latSec")
    , @NamedQuery(name = "AeroportOps.findByNS", query = "SELECT a FROM AeroportOps a WHERE a.nS = :nS")
    , @NamedQuery(name = "AeroportOps.findByLonDeg", query = "SELECT a FROM AeroportOps a WHERE a.lonDeg = :lonDeg")
    , @NamedQuery(name = "AeroportOps.findByLonMin", query = "SELECT a FROM AeroportOps a WHERE a.lonMin = :lonMin")
    , @NamedQuery(name = "AeroportOps.findByLonSec", query = "SELECT a FROM AeroportOps a WHERE a.lonSec = :lonSec")
    , @NamedQuery(name = "AeroportOps.findByEW", query = "SELECT a FROM AeroportOps a WHERE a.eW = :eW")
    , @NamedQuery(name = "AeroportOps.findByAeroCountry", query = "SELECT a FROM AeroportOps a WHERE a.aeroCountry = :aeroCountry")
    , @NamedQuery(name = "AeroportOps.findByReseau", query = "SELECT a FROM AeroportOps a WHERE a.reseau = :reseau")
    , @NamedQuery(name = "AeroportOps.findByEuEts", query = "SELECT a FROM AeroportOps a WHERE a.euEts = :euEts")})
public class AeroportOps implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "CODE_IATA")
    private String codeIata;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "AERO_DESC")
    private String aeroDesc;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "CODE_OACI")
    private String codeOaci;
    @Column(name = "LAT_DEG")
    private Integer latDeg;
    @Column(name = "LAT_MIN")
    private Integer latMin;
    @Column(name = "LAT_SEC")
    private Integer latSec;
    @Column(name = "N_S")
    private Character nS;
    @Column(name = "LON_DEG")
    private Integer lonDeg;
    @Column(name = "LON_MIN")
    private Integer lonMin;
    @Column(name = "LON_SEC")
    private Integer lonSec;
    @Column(name = "E_W")
    private Character eW;
    @Size(max = 100)
    @Column(name = "AERO_COUNTRY")
    private String aeroCountry;
    @Size(max = 3)
    @Column(name = "RESEAU")
    private String reseau;
    @Column(name = "EU_ETS")
    private Character euEts;
    @OneToMany(mappedBy = "arr",fetch = FetchType.LAZY)
    @BatchFetch(BatchFetchType.IN)
    private List<Vol> volList;
    @OneToMany(mappedBy = "dep",fetch = FetchType.LAZY)
    @BatchFetch(BatchFetchType.IN)
    private List<Vol> volList1;
    @OneToMany(mappedBy = "arr",fetch = FetchType.LAZY)
    @BatchFetch(BatchFetchType.IN)
    private List<Troncon> tronconList;
    @OneToMany(mappedBy = "dep",fetch = FetchType.LAZY)
    @BatchFetch(BatchFetchType.IN)
    private List<Troncon> tronconList1;

    public AeroportOps() {
    }

    public AeroportOps(String codeIata) {
        this.codeIata = codeIata;
    }

    public AeroportOps(String codeIata, String aeroDesc, String codeOaci) {
        this.codeIata = codeIata;
        this.aeroDesc = aeroDesc;
        this.codeOaci = codeOaci;
    }

    public String getCodeIata() {
        return codeIata;
    }

    public void setCodeIata(String codeIata) {
        this.codeIata = codeIata;
    }

    public String getAeroDesc() {
        return aeroDesc;
    }

    public void setAeroDesc(String aeroDesc) {
        this.aeroDesc = aeroDesc;
    }

    public String getCodeOaci() {
        return codeOaci;
    }

    public void setCodeOaci(String codeOaci) {
        this.codeOaci = codeOaci;
    }

    public Integer getLatDeg() {
        return latDeg;
    }

    public void setLatDeg(Integer latDeg) {
        this.latDeg = latDeg;
    }

    public Integer getLatMin() {
        return latMin;
    }

    public void setLatMin(Integer latMin) {
        this.latMin = latMin;
    }

    public Integer getLatSec() {
        return latSec;
    }

    public void setLatSec(Integer latSec) {
        this.latSec = latSec;
    }

    public Character getNS() {
        return nS;
    }

    public void setNS(Character nS) {
        this.nS = nS;
    }

    public Integer getLonDeg() {
        return lonDeg;
    }

    public void setLonDeg(Integer lonDeg) {
        this.lonDeg = lonDeg;
    }

    public Integer getLonMin() {
        return lonMin;
    }

    public void setLonMin(Integer lonMin) {
        this.lonMin = lonMin;
    }

    public Integer getLonSec() {
        return lonSec;
    }

    public void setLonSec(Integer lonSec) {
        this.lonSec = lonSec;
    }

    public Character getEW() {
        return eW;
    }

    public void setEW(Character eW) {
        this.eW = eW;
    }

    public String getAeroCountry() {
        return aeroCountry;
    }

    public void setAeroCountry(String aeroCountry) {
        this.aeroCountry = aeroCountry;
    }

    public String getReseau() {
        return reseau;
    }

    public void setReseau(String reseau) {
        this.reseau = reseau;
    }

    public Character getEuEts() {
        return euEts;
    }

    public void setEuEts(Character euEts) {
        this.euEts = euEts;
    }

    @XmlTransient
    public List<Vol> getVolList() {
        return volList;
    }

    public void setVolList(List<Vol> volList) {
        this.volList = volList;
    }

    @XmlTransient
    public List<Vol> getVolList1() {
        return volList1;
    }

    public void setVolList1(List<Vol> volList1) {
        this.volList1 = volList1;
    }

    @XmlTransient
    public List<Troncon> getTronconList() {
        return tronconList;
    }

    public void setTronconList(List<Troncon> tronconList) {
        this.tronconList = tronconList;
    }

    @XmlTransient
    public List<Troncon> getTronconList1() {
        return tronconList1;
    }

    public void setTronconList1(List<Troncon> tronconList1) {
        this.tronconList1 = tronconList1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codeIata != null ? codeIata.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AeroportOps)) {
            return false;
        }
        AeroportOps other = (AeroportOps) object;
        if ((this.codeIata == null && other.codeIata != null) || (this.codeIata != null && !this.codeIata.equals(other.codeIata))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dz.airalgerie.ops.model.entities.Aeroport[ codeIata=" + codeIata + " ]";
    }
    
}
