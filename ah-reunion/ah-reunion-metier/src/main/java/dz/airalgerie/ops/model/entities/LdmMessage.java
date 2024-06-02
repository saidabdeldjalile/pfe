/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this
 * license Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package dz.airalgerie.ops.model.entities;

import dz.airalgerie.commun.utils.ErpConstante;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Root
 */
@Entity
@Table(name = "LDM_MESSAGE", schema = ErpConstante.DbSchemaName.OPS)
@XmlRootElement
@NamedQueries({@NamedQuery(name = "LdmMessage.findAll", query = "SELECT l FROM LdmMessage l"),
    @NamedQuery(name = "LdmMessage.findByFDate",
        query = "SELECT l FROM LdmMessage l WHERE l.ldmMessagePK.fDate = :fDate"),
    @NamedQuery(name = "LdmMessage.findByFDay",
        query = "SELECT l FROM LdmMessage l WHERE l.fDay = :fDay"),
    @NamedQuery(name = "LdmMessage.findByFlt",
        query = "SELECT l FROM LdmMessage l WHERE l.ldmMessagePK.flt = :flt"),
    @NamedQuery(name = "LdmMessage.findBySuffix",
        query = "SELECT l FROM LdmMessage l WHERE l.ldmMessagePK.suffix = :suffix"),
    @NamedQuery(name = "LdmMessage.findByArr",
        query = "SELECT l FROM LdmMessage l WHERE l.ldmMessagePK.arr = :arr"),
    @NamedQuery(name = "LdmMessage.findByReg",
        query = "SELECT l FROM LdmMessage l WHERE l.reg = :reg"),
    @NamedQuery(name = "LdmMessage.findByAcVer",
        query = "SELECT l FROM LdmMessage l WHERE l.acVer = :acVer"),
    @NamedQuery(name = "LdmMessage.findByAcVerF",
        query = "SELECT l FROM LdmMessage l WHERE l.acVerF = :acVerF"),
    @NamedQuery(name = "LdmMessage.findByAcVerC",
        query = "SELECT l FROM LdmMessage l WHERE l.acVerC = :acVerC"),
    @NamedQuery(name = "LdmMessage.findByAcVerY",
        query = "SELECT l FROM LdmMessage l WHERE l.acVerY = :acVerY"),
    @NamedQuery(name = "LdmMessage.findByAdults",
        query = "SELECT l FROM LdmMessage l WHERE l.adults = :adults"),
    @NamedQuery(name = "LdmMessage.findByMales",
        query = "SELECT l FROM LdmMessage l WHERE l.males = :males"),
    @NamedQuery(name = "LdmMessage.findByFemales",
        query = "SELECT l FROM LdmMessage l WHERE l.females = :females"),
    @NamedQuery(name = "LdmMessage.findByChild",
        query = "SELECT l FROM LdmMessage l WHERE l.child = :child"),
    @NamedQuery(name = "LdmMessage.findByInfants",
        query = "SELECT l FROM LdmMessage l WHERE l.infants = :infants"),
    @NamedQuery(name = "LdmMessage.findByCabinBagW",
        query = "SELECT l FROM LdmMessage l WHERE l.cabinBagW = :cabinBagW"),
    @NamedQuery(name = "LdmMessage.findByTotalDeadload",
        query = "SELECT l FROM LdmMessage l WHERE l.totalDeadload = :totalDeadload"),
    @NamedQuery(name = "LdmMessage.findByPaxF",
        query = "SELECT l FROM LdmMessage l WHERE l.paxF = :paxF"),
    @NamedQuery(name = "LdmMessage.findByPaxC",
        query = "SELECT l FROM LdmMessage l WHERE l.paxC = :paxC"),
    @NamedQuery(name = "LdmMessage.findByPaxY",
        query = "SELECT l FROM LdmMessage l WHERE l.paxY = :paxY"),
    @NamedQuery(name = "LdmMessage.findByPadF",
        query = "SELECT l FROM LdmMessage l WHERE l.padF = :padF"),
    @NamedQuery(name = "LdmMessage.findByPadC",
        query = "SELECT l FROM LdmMessage l WHERE l.padC = :padC"),
    @NamedQuery(name = "LdmMessage.findByPadY",
        query = "SELECT l FROM LdmMessage l WHERE l.padY = :padY"),
    @NamedQuery(name = "LdmMessage.findByJumpSeater",
        query = "SELECT l FROM LdmMessage l WHERE l.jumpSeater = :jumpSeater"),
    @NamedQuery(name = "LdmMessage.findByCrewMembers",
        query = "SELECT l FROM LdmMessage l WHERE l.crewMembers = :crewMembers"),
    @NamedQuery(name = "LdmMessage.findByFktPosition",
        query = "SELECT l FROM LdmMessage l WHERE l.fktPosition = :fktPosition"),
    @NamedQuery(name = "LdmMessage.findByFktWeight",
        query = "SELECT l FROM LdmMessage l WHERE l.fktWeight = :fktWeight"),
    @NamedQuery(name = "LdmMessage.findByNbCargo",
        query = "SELECT l FROM LdmMessage l WHERE l.nbCargo = :nbCargo"),
    @NamedQuery(name = "LdmMessage.findByQuantityCargo",
        query = "SELECT l FROM LdmMessage l WHERE l.quantityCargo = :quantityCargo"),
    @NamedQuery(name = "LdmMessage.findByNbMail",
        query = "SELECT l FROM LdmMessage l WHERE l.nbMail = :nbMail"),
    @NamedQuery(name = "LdmMessage.findByQuantityMail",
        query = "SELECT l FROM LdmMessage l WHERE l.quantityMail = :quantityMail"),
    @NamedQuery(name = "LdmMessage.findByNbBaggage",
        query = "SELECT l FROM LdmMessage l WHERE l.nbBaggage = :nbBaggage"),
    @NamedQuery(name = "LdmMessage.findByQuantityBaggage",
        query = "SELECT l FROM LdmMessage l WHERE l.quantityBaggage = :quantityBaggage"),
    @NamedQuery(name = "LdmMessage.findBySubject",
        query = "SELECT l FROM LdmMessage l WHERE l.subject = :subject"),
    @NamedQuery(name = "LdmMessage.findBySi",
        query = "SELECT l FROM LdmMessage l WHERE l.si = :si"),
    @NamedQuery(name = "LdmMessage.findByIdVol",
        query = "SELECT l FROM LdmMessage l WHERE l.idVol = :idVol"),
    @NamedQuery(name = "LdmMessage.findByDep",
        query = "SELECT l FROM LdmMessage l WHERE l.dep = :dep")})
public class LdmMessage implements Serializable {

  private static final long serialVersionUID = 1L;
  @EmbeddedId
  protected LdmMessagePK ldmMessagePK;
  @Column(name = "F_DAY")
  private Integer fDay;
  @Size(max = 50)
  @Column(name = "REG")
  private String reg;
  @Size(max = 50)
  @Column(name = "AC_VER")
  private String acVer;
  @Column(name = "AC_VER_F")
  private Integer acVerF;
  @Column(name = "AC_VER_C")
  private Integer acVerC;
  @Column(name = "AC_VER_Y")
  private Integer acVerY;
  @Column(name = "ADULTS")
  private Integer adults;
  @Column(name = "MALES")
  private Integer males;
  @Column(name = "FEMALES")
  private Integer females;
  @Column(name = "CHILD")
  private Integer child;
  @Column(name = "INFANTS")
  private Integer infants;
  @Column(name = "CABIN_BAG_W")
  private Integer cabinBagW;
  @Column(name = "TOTAL_DEADLOAD")
  private Integer totalDeadload;
  @Column(name = "PAX_F")
  private Integer paxF;
  @Column(name = "PAX_C")
  private Integer paxC;
  @Column(name = "PAX_Y")
  private Integer paxY;
  @Column(name = "PAD_F")
  private Integer padF;
  @Column(name = "PAD_C")
  private Integer padC;
  @Column(name = "PAD_Y")
  private Integer padY;
  @Column(name = "JUMP_SEATER")
  private Integer jumpSeater;
  @Column(name = "CREW_MEMBERS")
  private Integer crewMembers;
  @Size(max = 50)
  @Column(name = "FKT_POSITION")
  private String fktPosition;
  @Column(name = "FKT_WEIGHT")
  private Integer fktWeight;
  @Column(name = "NB_CARGO")
  private Integer nbCargo;
  @Column(name = "QUANTITY_CARGO")
  private Integer quantityCargo;
  @Column(name = "NB_MAIL")
  private Integer nbMail;
  @Column(name = "QUANTITY_MAIL")
  private Integer quantityMail;
  @Column(name = "NB_BAGGAGE")
  private Integer nbBaggage;
  @Column(name = "QUANTITY_BAGGAGE")
  private Integer quantityBaggage;
  @Size(max = 250)
  @Column(name = "SUBJECT")
  private String subject;
  @Size(max = 1000)
  @Column(name = "SI")
  private String si;
  @Column(name = "ID_VOL")
  private Integer idVol;
  @Size(max = 3)
  @Column(name = "DEP")
  private String dep;

  public LdmMessage() {
  }

  public LdmMessage(LdmMessagePK ldmMessagePK) {
    this.ldmMessagePK = ldmMessagePK;
  }

  public LdmMessage(LocalDateTime fDate, int flt, String suffix, String arr) {
    this.ldmMessagePK = new LdmMessagePK(fDate, flt, suffix, arr);
  }

  public LdmMessage(LocalDateTime fDate, int flt, String suffix, String arr,Integer fDay, String reg, String acVer, Integer acVerF, Integer acVerC,
      Integer acVerY, Integer adults, Integer males, Integer females, Integer child,
      Integer infants, Integer cabinBagW, Integer totalDeadload, Integer paxF, Integer paxC,
      Integer paxY, Integer padF, Integer padC, Integer padY, Integer jumpSeater,
      Integer crewMembers, String fktPosition, Integer fktWeight, Integer nbCargo,
      Integer quantityCargo, Integer nbMail, Integer quantityMail, Integer nbBaggage,
      Integer quantityBaggage, String subject, String si, Integer idVol, String dep) {
    this.ldmMessagePK = new LdmMessagePK(fDate, flt, suffix, arr);
    this.fDay = fDay;
    this.reg = reg;
    this.acVer = acVer;
    this.acVerF = acVerF;
    this.acVerC = acVerC;
    this.acVerY = acVerY;
    this.adults = adults;
    this.males = males;
    this.females = females;
    this.child = child;
    this.infants = infants;
    this.cabinBagW = cabinBagW;
    this.totalDeadload = totalDeadload;
    this.paxF = paxF;
    this.paxC = paxC;
    this.paxY = paxY;
    this.padF = padF;
    this.padC = padC;
    this.padY = padY;
    this.jumpSeater = jumpSeater;
    this.crewMembers = crewMembers;
    this.fktPosition = fktPosition;
    this.fktWeight = fktWeight;
    this.nbCargo = nbCargo;
    this.quantityCargo = quantityCargo;
    this.nbMail = nbMail;
    this.quantityMail = quantityMail;
    this.nbBaggage = nbBaggage;
    this.quantityBaggage = quantityBaggage;
    this.subject = subject;
    this.si = si;
    this.idVol = idVol;
    this.dep = dep;
  }



  public LdmMessagePK getLdmMessagePK() {
    return ldmMessagePK;
  }

  public void setLdmMessagePK(LdmMessagePK ldmMessagePK) {
    this.ldmMessagePK = ldmMessagePK;
  }

  public Integer getFDay() {
    return fDay;
  }

  public void setFDay(Integer fDay) {
    this.fDay = fDay;
  }

  public String getReg() {
    return reg;
  }

  public void setReg(String reg) {
    this.reg = reg;
  }

  public String getAcVer() {
    return acVer;
  }

  public void setAcVer(String acVer) {
    this.acVer = acVer;
  }

  public Integer getAcVerF() {
    return acVerF;
  }

  public void setAcVerF(Integer acVerF) {
    this.acVerF = acVerF;
  }

  public Integer getAcVerC() {
    return acVerC;
  }

  public void setAcVerC(Integer acVerC) {
    this.acVerC = acVerC;
  }

  public Integer getAcVerY() {
    return acVerY;
  }

  public void setAcVerY(Integer acVerY) {
    this.acVerY = acVerY;
  }

  public Integer getAdults() {
    return adults;
  }

  public void setAdults(Integer adults) {
    this.adults = adults;
  }

  public Integer getMales() {
    return males;
  }

  public void setMales(Integer males) {
    this.males = males;
  }

  public Integer getFemales() {
    return females;
  }

  public void setFemales(Integer females) {
    this.females = females;
  }

  public Integer getChild() {
    return child;
  }

  public void setChild(Integer child) {
    this.child = child;
  }

  public Integer getInfants() {
    return infants;
  }

  public void setInfants(Integer infants) {
    this.infants = infants;
  }

  public Integer getCabinBagW() {
    return cabinBagW;
  }

  public void setCabinBagW(Integer cabinBagW) {
    this.cabinBagW = cabinBagW;
  }

  public Integer getTotalDeadload() {
    return totalDeadload;
  }

  public void setTotalDeadload(Integer totalDeadload) {
    this.totalDeadload = totalDeadload;
  }

  public Integer getPaxF() {
    return paxF;
  }

  public void setPaxF(Integer paxF) {
    this.paxF = paxF;
  }

  public Integer getPaxC() {
    return paxC;
  }

  public void setPaxC(Integer paxC) {
    this.paxC = paxC;
  }

  public Integer getPaxY() {
    return paxY;
  }

  public void setPaxY(Integer paxY) {
    this.paxY = paxY;
  }

  public Integer getPadF() {
    return padF;
  }

  public void setPadF(Integer padF) {
    this.padF = padF;
  }

  public Integer getPadC() {
    return padC;
  }

  public void setPadC(Integer padC) {
    this.padC = padC;
  }

  public Integer getPadY() {
    return padY;
  }

  public void setPadY(Integer padY) {
    this.padY = padY;
  }

  public Integer getJumpSeater() {
    return jumpSeater;
  }

  public void setJumpSeater(Integer jumpSeater) {
    this.jumpSeater = jumpSeater;
  }

  public Integer getCrewMembers() {
    return crewMembers;
  }

  public void setCrewMembers(Integer crewMembers) {
    this.crewMembers = crewMembers;
  }

  public String getFktPosition() {
    return fktPosition;
  }

  public void setFktPosition(String fktPosition) {
    this.fktPosition = fktPosition;
  }

  public Integer getFktWeight() {
    return fktWeight;
  }

  public void setFktWeight(Integer fktWeight) {
    this.fktWeight = fktWeight;
  }

  public Integer getNbCargo() {
    return nbCargo;
  }

  public void setNbCargo(Integer nbCargo) {
    this.nbCargo = nbCargo;
  }

  public Integer getQuantityCargo() {
    return quantityCargo;
  }

  public void setQuantityCargo(Integer quantityCargo) {
    this.quantityCargo = quantityCargo;
  }

  public Integer getNbMail() {
    return nbMail;
  }

  public void setNbMail(Integer nbMail) {
    this.nbMail = nbMail;
  }

  public Integer getQuantityMail() {
    return quantityMail;
  }

  public void setQuantityMail(Integer quantityMail) {
    this.quantityMail = quantityMail;
  }

  public Integer getNbBaggage() {
    return nbBaggage;
  }

  public void setNbBaggage(Integer nbBaggage) {
    this.nbBaggage = nbBaggage;
  }

  public Integer getQuantityBaggage() {
    return quantityBaggage;
  }

  public void setQuantityBaggage(Integer quantityBaggage) {
    this.quantityBaggage = quantityBaggage;
  }

  public String getSubject() {
    return subject;
  }

  public void setSubject(String subject) {
    this.subject = subject;
  }

  public String getSi() {
    return si;
  }

  public void setSi(String si) {
    this.si = si;
  }

  public Integer getIdVol() {
    return idVol;
  }

  public void setIdVol(Integer idVol) {
    this.idVol = idVol;
  }

  public String getDep() {
    return dep;
  }

  public void setDep(String dep) {
    this.dep = dep;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (ldmMessagePK != null ? ldmMessagePK.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof LdmMessage)) {
      return false;
    }
    LdmMessage other = (LdmMessage) object;
    if ((this.ldmMessagePK == null && other.ldmMessagePK != null)
        || (this.ldmMessagePK != null && !this.ldmMessagePK.equals(other.ldmMessagePK))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "dz.airalgerie.ops.model.entities.LdmMessage[ ldmMessagePK=" + ldmMessagePK + " ]";
  }

}
