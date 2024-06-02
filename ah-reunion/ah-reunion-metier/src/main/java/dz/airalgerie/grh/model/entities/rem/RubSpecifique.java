/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.grh.model.entities.rem;

import dz.airalgerie.commun.grh.utils.Utils;
import dz.airalgerie.commun.model.entities.commun.Wilaya;
import dz.airalgerie.grh.model.entities.commun.Personnel;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Diaf
 */
@Entity
@Table(name = "RUB_SPECIFIQUE_T", schema = Utils.dbSchema)
public class RubSpecifique implements Serializable {

  private static final long serialVersionUID = 1L;
  @EmbeddedId
  private RubSpecifiquePK rubriqueSpecifiquePK;

  @Column(name = "ANCIENNETE")
  private BigDecimal anciennete;

  @Column(name = "CODE_EXON25")
  private Boolean codeExon25;

  @Column(name = "CODE_DOC")
  private Short codeDoc;

  @Column(name = "MONT_DEVISE")
  private BigDecimal montDevise;

  @Column(name = "CODE_ABAT_IRG")
  private Integer CODE_ABAT_IRG;

  @Column(name = "CODE_ASTREINTE")
  private boolean CODE_ASTREINTE;

  @Column(name = "CODE_CAAT")
  private Integer CODE_CAAT;

  @Column(name = "CODE_CAF")
  private Integer CODE_CAF;

  @Column(name = "CODE_ENTRETIEN")
  private Integer CODE_ENTRETIEN;

  @Column(name = "CODE_FOYER")
  private Integer CODE_FOYER;

  @Column(name = "CODE_HABILLEMENT")
  private Integer CODE_HABILLEMENT;

  @Column(name = "CODE_IFSP")
  private boolean CODE_IFSP;

  @Column(name = "CODE_IGM")
  private Integer CODE_IGM;

  // CODE_PPC REEL
  @Column(name = "CODE_IPSU")
  private Integer CODE_IPSU;
  @Column(name = "QUALIF_CHANTIER")
  private Integer qualifChantier;

  @Column(name = "CODE_ITP")
  private Integer CODE_ITP;

  @Column(name = "CODE_MGT")
  private Integer CODE_MGT;

  @Column(name = "CODE_PENIBILITE")
  private boolean CODE_PENIBILITE;

  @Column(name = "CODE_PFF")
  private Integer CODE_PFF;

  @Column(name = "CODE_PPA")
  private boolean CODE_PPA;

  @Column(name = "CODE_PPC")
  private Integer CODE_PPC;

  @Column(name = "CODE_PPS")
  private Integer CODE_PPS;

  @Column(name = "CODE_PQA")
  private Integer CODE_PQA;

  @Column(name = "CODE_PQM")
  private Integer CODE_PQM;

  @Column(name = "CODE_PSA")
  private Integer CODE_PSA;

  @Column(name = "CODE_PSMA")
  private boolean CODE_PSMA;

  @Column(name = "CODE_PSP")
  private Integer CODE_PSP;

  @Column(name = "CODE_PTA")
  private boolean CODE_PTA;

  @Column(name = "CODE_ITS")
  private Integer CODE_ITS;

  @Column(name = "CODE_RESPONSABILITE")
  private Integer CODE_RESPONSABILITE;

  @Column(name = "CODE_ZONALE")
  private Integer CODE_ZONALE;

  @Column(name = "CODE_CAISSE")
  private Integer CODE_CAISSE;

  @Column(name = "CODE_TRANSPORT")
  private Integer CODE_TRANSPORT;

  @Column(name = "CODE_VEHICULE")
  private Integer CODE_VEHICULE;

  @Column(name = "CODE_ZONE")
  private Integer CODE_ZONE;

  @Column(name = "TAUX_NUISANCE")
  private BigDecimal TAUX_NUISANCE;

  @Column(name = "CODE_DISPONIBILITE")
  private boolean CODE_DISPONIBILITE;

  @Column(name = "TYPE_CONTRAT")
  private String TYPE_CONTRAT;

  @Column(name = "CODE_TECH")
  private String CODE_TECH;

  @Column(name = "PHV_REEL")
  private BigDecimal PHV_REEL;

  @Column(name = "CODE_FCT_PN")
  private String CODE_FCT_PN;

  @Column(name = "CODE_QUALIF_PN")
  private String CODE_QUALIF_PN;

  @Column(name = "CODE_MACHINE")
  private String CODE_MACHINE;

  @Column(name = "INDICE")
  private Integer INDICE;

  @Column(name = "SALAIRE_BASE")
  private BigDecimal SALAIRE_BASE;

  @Column(name = "NUM_MGT")
  private String numMgt;
  @Column(name = "NUM_CAAT")
  private String numCaat;

  @JoinColumn(name = "matricule", referencedColumnName = "matricule", insertable = false,
      updatable = false)
  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  private Personnel personnel;

  @JoinColumn(name = "CODE_WIL", referencedColumnName = "CODE_WIL", insertable = false,
      updatable = false)
  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  private Wilaya wilaya;

  public String getTYPE_CONTRAT() {
    return TYPE_CONTRAT;
  }

  public void setTYPE_CONTRAT(String TYPE_CONTRAT) {
    this.TYPE_CONTRAT = TYPE_CONTRAT;
  }

  public String getCODE_TECH() {
    return CODE_TECH;
  }

  public void setCODE_TECH(String CODE_TECH) {
    this.CODE_TECH = CODE_TECH;
  }

  public Integer getCODE_ZONE() {
    return CODE_ZONE;
  }

  public void setCODE_ZONE(Integer CODE_ZONE) {
    this.CODE_ZONE = CODE_ZONE;
  }

  public Wilaya getWilaya() {
    return wilaya;
  }

  public void setWilaya(Wilaya wilaya) {
    this.wilaya = wilaya;
  }

  public Personnel getPersonnel() {
    return personnel;
  }

  public void setPersonnel(Personnel personnel) {
    this.personnel = personnel;
  }

  public Integer getCODE_ZONALE() {
    return CODE_ZONALE;
  }

  public void setCODE_ZONALE(Integer CODE_ZONALE) {
    this.CODE_ZONALE = CODE_ZONALE;
  }

  public Integer getCODE_CAISSE() {
    return CODE_CAISSE;
  }

  public void setCODE_CAISSE(Integer CODE_CAISSE) {
    this.CODE_CAISSE = CODE_CAISSE;
  }

  public boolean isCODE_DISPONIBILITE() {
    return CODE_DISPONIBILITE;
  }

  public void setCODE_DISPONIBILITE(boolean CODE_DISPONIBILITE) {
    this.CODE_DISPONIBILITE = CODE_DISPONIBILITE;
  }

  public BigDecimal getAnciennete() {
    return anciennete;
  }

  public void setAnciennete(BigDecimal anciennete) {
    this.anciennete = anciennete;
  }

  public Integer getCODE_ABAT_IRG() {
    return CODE_ABAT_IRG;
  }

  public void setCODE_ABAT_IRG(Integer CODE_ABAT_IRG) {
    this.CODE_ABAT_IRG = CODE_ABAT_IRG;
  }

  public boolean isCODE_ASTREINTE() {
    return CODE_ASTREINTE;
  }

  public void setCODE_ASTREINTE(boolean CODE_ASTREINTE) {
    this.CODE_ASTREINTE = CODE_ASTREINTE;
  }

  public Integer getCODE_CAAT() {
    return CODE_CAAT;
  }

  public void setCODE_CAAT(Integer CODE_CAAT) {
    this.CODE_CAAT = CODE_CAAT;
  }

  public Integer getCODE_CAF() {
    return CODE_CAF;
  }

  public void setCODE_CAF(Integer CODE_CAF) {
    this.CODE_CAF = CODE_CAF;
  }

  public Integer getCODE_ENTRETIEN() {
    return CODE_ENTRETIEN;
  }

  public void setCODE_ENTRETIEN(Integer CODE_ENTRETIEN) {
    this.CODE_ENTRETIEN = CODE_ENTRETIEN;
  }

  public Integer getCODE_FOYER() {
    return CODE_FOYER;
  }

  public void setCODE_FOYER(Integer CODE_FOYER) {
    this.CODE_FOYER = CODE_FOYER;
  }

  public Integer getCODE_HABILLEMENT() {
    return CODE_HABILLEMENT;
  }

  public void setCODE_HABILLEMENT(Integer CODE_HABILLEMENT) {
    this.CODE_HABILLEMENT = CODE_HABILLEMENT;
  }

  public boolean isCODE_IFSP() {
    return CODE_IFSP;
  }

  public void setCODE_IFSP(boolean CODE_IFSP) {
    this.CODE_IFSP = CODE_IFSP;
  }

  public Integer getCODE_IGM() {
    return CODE_IGM;
  }

  public void setCODE_IGM(Integer CODE_IGM) {
    this.CODE_IGM = CODE_IGM;
  }

  public Integer getCODE_IPSU() {
    return CODE_IPSU;
  }

  public void setCODE_IPSU(Integer CODE_IPSU) {
    this.CODE_IPSU = CODE_IPSU;
  }

  public Integer getQualifChantier() {
    return qualifChantier;
  }

  public void setQualifChantier(Integer qualifChantier) {
    this.qualifChantier = qualifChantier;
  }

  public Integer getCODE_ITP() {
    return CODE_ITP;
  }

  public void setCODE_ITP(Integer CODE_ITP) {
    this.CODE_ITP = CODE_ITP;
  }

  public Integer getCODE_MGT() {
    return CODE_MGT;
  }

  public void setCODE_MGT(Integer CODE_MGT) {
    this.CODE_MGT = CODE_MGT;
  }

  public boolean isCODE_PENIBILITE() {
    return CODE_PENIBILITE;
  }

  public void setCODE_PENIBILITE(boolean CODE_PENIBILITE) {
    this.CODE_PENIBILITE = CODE_PENIBILITE;
  }

  public Integer getCODE_PFF() {
    return CODE_PFF;
  }

  public void setCODE_PFF(Integer CODE_PFF) {
    this.CODE_PFF = CODE_PFF;
  }

  public boolean isCODE_PPA() {
    return CODE_PPA;
  }

  public void setCODE_PPA(boolean CODE_PPA) {
    this.CODE_PPA = CODE_PPA;
  }

  public Integer getCODE_PPC() {
    return CODE_PPC;
  }

  public void setCODE_PPC(Integer CODE_PPC) {
    this.CODE_PPC = CODE_PPC;
  }

  public Integer getCODE_PPS() {
    return CODE_PPS;
  }

  public void setCODE_PPS(Integer CODE_PPS) {
    this.CODE_PPS = CODE_PPS;
  }

  public Integer getCODE_PQA() {
    return CODE_PQA;
  }

  public void setCODE_PQA(Integer CODE_PQA) {
    this.CODE_PQA = CODE_PQA;
  }

  public Integer getCODE_PQM() {
    return CODE_PQM;
  }

  public void setCODE_PQM(Integer CODE_PQM) {
    this.CODE_PQM = CODE_PQM;
  }

  public Integer getCODE_PSA() {
    return CODE_PSA;
  }

  public void setCODE_PSA(Integer CODE_PSA) {
    this.CODE_PSA = CODE_PSA;
  }

  public boolean isCODE_PSMA() {
    return CODE_PSMA;
  }

  public void setCODE_PSMA(boolean CODE_PSMA) {
    this.CODE_PSMA = CODE_PSMA;
  }

  public Integer getCODE_PSP() {
    return CODE_PSP;
  }

  public void setCODE_PSP(Integer CODE_PSP) {
    this.CODE_PSP = CODE_PSP;
  }

  public boolean isCODE_PTA() {
    return CODE_PTA;
  }

  public void setCODE_PTA(boolean CODE_PTA) {
    this.CODE_PTA = CODE_PTA;
  }

  public Integer getCODE_ITS() {
    return CODE_ITS;
  }

  public void setCODE_ITS(Integer CODE_ITS) {
    this.CODE_ITS = CODE_ITS;
  }

  public Integer getCODE_RESPONSABILITE() {
    return CODE_RESPONSABILITE;
  }

  public void setCODE_RESPONSABILITE(Integer CODE_RESPONSABILITE) {
    this.CODE_RESPONSABILITE = CODE_RESPONSABILITE;
  }

  public Integer getCODE_TRANSPORT() {
    return CODE_TRANSPORT;
  }

  public void setCODE_TRANSPORT(Integer CODE_TRANSPORT) {
    this.CODE_TRANSPORT = CODE_TRANSPORT;
  }

  public Integer getCODE_VEHICULE() {
    return CODE_VEHICULE;
  }

  public void setCODE_VEHICULE(Integer CODE_VEHICULE) {
    this.CODE_VEHICULE = CODE_VEHICULE;
  }

  public BigDecimal getTAUX_NUISANCE() {
    return TAUX_NUISANCE;
  }

  public void setTAUX_NUISANCE(BigDecimal TAUX_NUISANCE) {
    this.TAUX_NUISANCE = TAUX_NUISANCE;
  }

  public RubSpecifiquePK getRubriqueSpecifiquePK() {
    return rubriqueSpecifiquePK;
  }

  public void setRubriqueSpecifiquePK(RubSpecifiquePK rubriqueSpecifiquePK) {
    this.rubriqueSpecifiquePK = rubriqueSpecifiquePK;
  }

  public BigDecimal getPHV_REEL() {
    return PHV_REEL;
  }

  public Integer getINDICE() {
    return INDICE;
  }

  public void setPHV_REEL(BigDecimal PHV_REEL) {
    this.PHV_REEL = PHV_REEL;
  }

  public void setINDICE(Integer INDICE) {
    this.INDICE = INDICE;
  }

  public String getCODE_FCT_PN() {
    return CODE_FCT_PN;
  }

  public BigDecimal getSALAIRE_BASE() {
    return SALAIRE_BASE;
  }

  public void setCODE_FCT_PN(String CODE_FCT_PN) {
    this.CODE_FCT_PN = CODE_FCT_PN;
  }

  public String getCODE_QUALIF_PN() {
    return CODE_QUALIF_PN;
  }

  public void setCODE_QUALIF_PN(String CODE_QUALIF_PN) {
    this.CODE_QUALIF_PN = CODE_QUALIF_PN;
  }

  public String getCODE_MACHINE() {
    return CODE_MACHINE;
  }

  public void setCODE_MACHINE(String CODE_MACHINE) {
    this.CODE_MACHINE = CODE_MACHINE;
  }

  public void setSALAIRE_BASE(BigDecimal SALAIRE_BASE) {
    this.SALAIRE_BASE = SALAIRE_BASE;
  }

  public Boolean getCodeExon25() {
    return codeExon25;
  }

  public void setCodeExon25(Boolean codeExon25) {
    this.codeExon25 = codeExon25;
  }

  public Short getCodeDoc() {
    return codeDoc;
  }

  public void setCodeDoc(Short codeDoc) {
    this.codeDoc = codeDoc;
  }

  public BigDecimal getMontDevise() {
    return montDevise;
  }

  public void setMontDevise(BigDecimal montDevise) {
    this.montDevise = montDevise;
  }

  public String getNumMgt() {
    return numMgt;
  }

  public void setNumMgt(String numMgt) {
    this.numMgt = numMgt;
  }

  public String getNumCaat() {
    return numCaat;
  }

  public void setNumCaat(String numCaat) {
    this.numCaat = numCaat;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (rubriqueSpecifiquePK != null ? rubriqueSpecifiquePK.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof RubSpecifique)) {
      return false;
    }
    RubSpecifique other = (RubSpecifique) object;
    if ((this.rubriqueSpecifiquePK == null && other.rubriqueSpecifiquePK != null)
        || (this.rubriqueSpecifiquePK != null
            && !this.rubriqueSpecifiquePK.equals(other.rubriqueSpecifiquePK))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "ENTITY.RubriqueSpecifique[ id=" + rubriqueSpecifiquePK + " ]";
  }

}
