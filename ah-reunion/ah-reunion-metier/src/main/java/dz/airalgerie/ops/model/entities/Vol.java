/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.ops.model.entities;

import dz.airalgerie.commun.utils.ErpConstante;
import dz.airalgerie.ops.model.dto.vol.PlanningFlightOpsDTO;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlTransient;
import org.eclipse.persistence.annotations.BatchFetch;
import org.eclipse.persistence.annotations.BatchFetchType;

/**
 *
 * @author Root
 */
@Entity
@Table(name = "VOL", schema = ErpConstante.DbSchemaName.OPS)

@SqlResultSetMapping(name = "PlanningFlightOpsDTO",
    classes = @ConstructorResult(targetClass = PlanningFlightOpsDTO.class,
        columns = {@ColumnResult(name = "ID", type = Integer.class),
            @ColumnResult(name = "FLT", type = String.class),
            @ColumnResult(name = "DEP", type = String.class),
            @ColumnResult(name = "ARR", type = String.class),
            @ColumnResult(name = "STD", type = LocalDateTime.class),
            @ColumnResult(name = "STA", type = LocalDateTime.class),
            @ColumnResult(name = "N_ID", type = Integer.class),
            @ColumnResult(name = "N_FLT", type = String.class),
            @ColumnResult(name = "N_STD", type = LocalDateTime.class),
            @ColumnResult(name = "N_STA", type = LocalDateTime.class),
            @ColumnResult(name = "N_DEP", type = String.class),
            @ColumnResult(name = "N_ARR", type = String.class),
            @ColumnResult(name = "TOTAL_HOURS", type = Integer.class),
            @ColumnResult(name = "TOTAL_MIN", type = Integer.class)}))

public class Vol implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(name = "ID")
  private Integer id;
  @Column(name = "FLT_DATE")
  private LocalDate fltDate;
  @Size(max = 10)
  @Column(name = "FLT")
  private String flt;
  @Size(max = 10)
  @Column(name = "AVION")
  private String avion;
  @Column(name = "STD")
  private LocalDateTime std;
  @Column(name = "STA")
  private LocalDateTime sta;
  @Column(name = "TAKE_OFF")
  private LocalDateTime takeOff;
  @Column(name = "TAKE_DOWN")
  private LocalDateTime takeDown;
  @Column(name = "ATD")
  private LocalDateTime atd;
  @Column(name = "ATA")
  private LocalDateTime ata;
  @Column(name = "BLOCK_DURATION")
  private LocalTime blockDuration;
  @Column(name = "FLIGHT_DURATION")
  private LocalTime flightDuration;
  @Column(name = "CAPACITY_F")
  private Integer capacityF;
  @Column(name = "CAPACITY_Y")
  private Integer capacityY;
  @Column(name = "CAPACITY_C")
  private Integer capacityC;
  @Column(name = "TOTAL_CAPACITY")
  private Integer totalCapacity;
  @Column(name = "PAX_F")
  private Integer paxF;
  @Column(name = "PAX_Y")
  private Integer paxY;
  @Column(name = "PAX_C")
  private Integer paxC;
  @Column(name = "PAX_INF")
  private Integer paxInf;
  @Column(name = "TOTAL_PAX")
  private Integer totalPax;
  @Column(name = "TOTAL_PAX_CALC")
  private Integer totalPaxCalc;
  @Column(name = "LOAD_FACTOR")
  private BigDecimal loadFactor;
  @Column(name = "CARGO")
  private Integer cargo;
  @Column(name = "MAIL")
  private Integer mail;
  @Column(name = "PAYLOAD")
  private Integer payload;
  @Column(name = "BAGS")
  private Integer bags;
  @Column(name = "STATUT")
  private Short statut;
  @Column(name = "VOL_RETARDE")
  private Boolean volRetarde;
  @Column(name = "VOL_ANNULE")
  private Boolean volAnnule;
  @Column(name = "DANGEROUS_GOODS")
  private int dangerousGoods;
  @Column(name = "QTE_FUEL")
  private float quantiteFuel;
  @OneToMany(mappedBy = "volId", fetch = FetchType.LAZY)
  @BatchFetch(BatchFetchType.IN)
  private List<Solution> solutionList;
  @OneToMany(mappedBy = "volId", cascade = CascadeType.ALL, orphanRemoval = true,
      fetch = FetchType.LAZY)
  @BatchFetch(BatchFetchType.IN)
  private List<EventOps> eventList;
  @JoinColumn(name = "ARR", referencedColumnName = "CODE_IATA")
  @ManyToOne(fetch = FetchType.LAZY)
  @BatchFetch(BatchFetchType.IN)
  private AeroportOps arr;
  @JoinColumn(name = "DEP", referencedColumnName = "CODE_IATA")
  @ManyToOne(fetch = FetchType.LAZY)
  @BatchFetch(BatchFetchType.IN)
  private AeroportOps dep;
  @JoinColumn(name = "REG", referencedColumnName = "REG")
  @ManyToOne(fetch = FetchType.LAZY)
  @BatchFetch(BatchFetchType.IN)
  private Avion reg;
  @JoinColumn(name = "ROUTE_ID", referencedColumnName = "ID")
  @ManyToOne(fetch = FetchType.LAZY)
  @BatchFetch(BatchFetchType.IN)
  private Route routeId;
  @JoinColumn(name = "TYPE", referencedColumnName = "TYPE")
  @ManyToOne(fetch = FetchType.LAZY)
  @BatchFetch(BatchFetchType.IN)
  private TypeVol type;
  @JoinColumn(name = "STATUT_VOL", referencedColumnName = "CODE_STATUT")
  @ManyToOne(fetch = FetchType.LAZY)
  @BatchFetch(BatchFetchType.IN)
  private StatutVol statutVol;
  @OneToMany(mappedBy = "volId", fetch = FetchType.LAZY)
  @BatchFetch(BatchFetchType.IN)
  private List<Delay> delayList;
  @OneToMany(mappedBy = "volId", fetch = FetchType.LAZY)
  @BatchFetch(BatchFetchType.IN)
  private List<CrewOps> crewList;

  public Vol() {
  }

  public Vol(Integer id) {
    this.id = id;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public LocalDate getFltDate() {
    return fltDate;
  }

  public void setFltDate(LocalDate fltDate) {
    this.fltDate = fltDate;
  }

  public String getFlt() {
    return flt;
  }

  public void setFlt(String flt) {
    this.flt = flt;
  }

  public String getAvion() {
    return avion;
  }

  public void setAvion(String avion) {
    this.avion = avion;
  }

  public LocalDateTime getStd() {
    return std;
  }

  public void setStd(LocalDateTime std) {
    this.std = std;
  }

  public LocalDateTime getSta() {
    return sta;
  }

  public void setSta(LocalDateTime sta) {
    this.sta = sta;
  }

  public LocalDateTime getTakeOff() {
    return takeOff;
  }

  public void setTakeOff(LocalDateTime takeOff) {
    this.takeOff = takeOff;
  }

  public LocalDateTime getTakeDown() {
    return takeDown;
  }

  public void setTakeDown(LocalDateTime takeDown) {
    this.takeDown = takeDown;
  }

  public LocalDateTime getAtd() {
    return atd;
  }

  public void setAtd(LocalDateTime atd) {
    this.atd = atd;
  }

  public LocalDateTime getAta() {
    return ata;
  }

  public void setAta(LocalDateTime ata) {
    this.ata = ata;
  }

  public LocalTime getBlockDuration() {
    return blockDuration;
  }

  public void setBlockDuration(LocalTime blockDuration) {
    this.blockDuration = blockDuration;
  }

  public LocalTime getFlightDuration() {
    return flightDuration;
  }

  public void setFlightDuration(LocalTime flightDuration) {
    this.flightDuration = flightDuration;
  }

  public Integer getCapacityF() {
    return capacityF;
  }

  public void setCapacityF(Integer capacityF) {
    this.capacityF = capacityF;
  }

  public Integer getCapacityY() {
    return capacityY;
  }

  public void setCapacityY(Integer capacityY) {
    this.capacityY = capacityY;
  }

  public Integer getCapacityC() {
    return capacityC;
  }

  public void setCapacityC(Integer capacityC) {
    this.capacityC = capacityC;
  }

  public Integer getTotalCapacity() {
    return totalCapacity;
  }

  public void setTotalCapacity(Integer totalCapacity) {
    this.totalCapacity = totalCapacity;
  }

  public Integer getPaxF() {
    return paxF;
  }

  public void setPaxF(Integer paxF) {
    this.paxF = paxF;
  }

  public Integer getPaxY() {
    return paxY;
  }

  public void setPaxY(Integer paxY) {
    this.paxY = paxY;
  }

  public Integer getPaxC() {
    return paxC;
  }

  public void setPaxC(Integer paxC) {
    this.paxC = paxC;
  }

  public Integer getPaxInf() {
    return paxInf;
  }

  public void setPaxInf(Integer paxInf) {
    this.paxInf = paxInf;
  }

  public Integer getTotalPax() {
    return totalPax;
  }

  public void setTotalPax(Integer totalPax) {
    this.totalPax = totalPax;
  }

  public Integer getTotalPaxCalc() {
    return totalPaxCalc;
  }

  public void setTotalPaxCalc(Integer totalPaxCalc) {
    this.totalPaxCalc = totalPaxCalc;
  }

  public BigDecimal getLoadFactor() {
    return loadFactor;
  }

  public void setLoadFactor(BigDecimal loadFactor) {
    this.loadFactor = loadFactor;
  }

  public Integer getCargo() {
    return cargo;
  }

  public void setCargo(Integer cargo) {
    this.cargo = cargo;
  }

  public Integer getMail() {
    return mail;
  }

  public void setMail(Integer mail) {
    this.mail = mail;
  }

  public Integer getPayload() {
    return payload;
  }

  public void setPayload(Integer payload) {
    this.payload = payload;
  }

  public Integer getBags() {
    return bags;
  }

  public void setBags(Integer bags) {
    this.bags = bags;
  }

  public Short getStatut() {
    return statut;
  }

  public void setStatut(Short statut) {
    this.statut = statut;
  }

  public Boolean getVolRetarde() {
    return volRetarde;
  }

  public void setVolRetarde(Boolean volRetarde) {
    this.volRetarde = volRetarde;
  }

  public Boolean getVolAnnule() {
    return volAnnule;
  }

  public void setVolAnnule(Boolean volAnnule) {
    this.volAnnule = volAnnule;
  }

  @XmlTransient
  public List<Solution> getSolutionList() {
    return solutionList;
  }

  public void setSolutionList(List<Solution> solutionList) {
    this.solutionList = solutionList;
  }

  @XmlTransient
  public List<EventOps> getEventList() {
    return eventList;
  }

  public void setEventList(List<EventOps> eventList) {
    this.eventList = eventList;
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

  public Avion getReg() {
    return reg;
  }

  public void setReg(Avion reg) {
    this.reg = reg;
  }

  public Route getRouteId() {
    return routeId;
  }

  public void setRouteId(Route routeId) {
    this.routeId = routeId;
  }

  public TypeVol getType() {
    return type;
  }

  public void setType(TypeVol type) {
    this.type = type;
  }

  public StatutVol getStatutVol() {
    return statutVol;
  }

  public void setStatutVol(StatutVol statutVol) {
    this.statutVol = statutVol;
  }

  public int getDangerousGoods() {
    return dangerousGoods;
  }

  public void setDangerousGoods(int dangerousGoods) {
    this.dangerousGoods = dangerousGoods;
  }

  public float getQuantiteFuel() {
    return quantiteFuel;
  }

  public void setQuantiteFuel(float quantiteFuel) {
    this.quantiteFuel = quantiteFuel;
  }

  @XmlTransient
  public List<Delay> getDelayList() {
    return delayList;
  }

  public void setDelayList(List<Delay> delayList) {
    this.delayList = delayList;
  }

  @XmlTransient
  public List<CrewOps> getCrewList() {
    return crewList;
  }

  public void setCrewList(List<CrewOps> crewList) {
    this.crewList = crewList;
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
    if (!(object instanceof Vol)) {
      return false;
    }
    Vol other = (Vol) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "dz.airalgerie.ops.model.entities.Vol[ id=" + id + " ]";
  }

}
