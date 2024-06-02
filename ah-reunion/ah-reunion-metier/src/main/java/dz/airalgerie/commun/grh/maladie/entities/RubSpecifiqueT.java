/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.commun.grh.maladie.entities;

import java.io.Serializable;
import java.math.BigDecimal;
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
 * @author user
 */
@Entity
@Table(name = "PAIE.RUB_SPECIFIQUE_T")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RubSpecifiqueT.findAll", query = "SELECT r FROM RubSpecifiqueT r"),
    @NamedQuery(name = "RubSpecifiqueT.findByMatricule",
        query = "SELECT r FROM RubSpecifiqueT r WHERE r.rubSpecifiqueTPK.matricule = :matricule"),
    @NamedQuery(name = "RubSpecifiqueT.findByDateTrt",
        query = "SELECT r FROM RubSpecifiqueT r WHERE r.rubSpecifiqueTPK.dateTrt = :dateTrt"),
    @NamedQuery(name = "RubSpecifiqueT.findByAnciennete",
        query = "SELECT r FROM RubSpecifiqueT r WHERE r.anciennete = :anciennete"),
    @NamedQuery(name = "RubSpecifiqueT.findByCodeAbatIrg",
        query = "SELECT r FROM RubSpecifiqueT r WHERE r.codeAbatIrg = :codeAbatIrg"),
    @NamedQuery(name = "RubSpecifiqueT.findByCodeAstreinte",
        query = "SELECT r FROM RubSpecifiqueT r WHERE r.codeAstreinte = :codeAstreinte"),
    @NamedQuery(name = "RubSpecifiqueT.findByCodeCaat",
        query = "SELECT r FROM RubSpecifiqueT r WHERE r.codeCaat = :codeCaat"),
    @NamedQuery(name = "RubSpecifiqueT.findByCodeCaf",
        query = "SELECT r FROM RubSpecifiqueT r WHERE r.codeCaf = :codeCaf"),
    @NamedQuery(name = "RubSpecifiqueT.findByCodeDisponibilite",
        query = "SELECT r FROM RubSpecifiqueT r WHERE r.codeDisponibilite = :codeDisponibilite"),
    @NamedQuery(name = "RubSpecifiqueT.findByCodeEntretien",
        query = "SELECT r FROM RubSpecifiqueT r WHERE r.codeEntretien = :codeEntretien"),
    @NamedQuery(name = "RubSpecifiqueT.findByCodeFoyer",
        query = "SELECT r FROM RubSpecifiqueT r WHERE r.codeFoyer = :codeFoyer"),
    @NamedQuery(name = "RubSpecifiqueT.findByCodeHabillement",
        query = "SELECT r FROM RubSpecifiqueT r WHERE r.codeHabillement = :codeHabillement"),
    @NamedQuery(name = "RubSpecifiqueT.findByCodeIfsp",
        query = "SELECT r FROM RubSpecifiqueT r WHERE r.codeIfsp = :codeIfsp"),
    @NamedQuery(name = "RubSpecifiqueT.findByCodeIgm",
        query = "SELECT r FROM RubSpecifiqueT r WHERE r.codeIgm = :codeIgm"),
    @NamedQuery(name = "RubSpecifiqueT.findByCodeIpsu",
        query = "SELECT r FROM RubSpecifiqueT r WHERE r.codeIpsu = :codeIpsu"),
    @NamedQuery(name = "RubSpecifiqueT.findByCodeItp",
        query = "SELECT r FROM RubSpecifiqueT r WHERE r.codeItp = :codeItp"),
    @NamedQuery(name = "RubSpecifiqueT.findByCodeMgt",
        query = "SELECT r FROM RubSpecifiqueT r WHERE r.codeMgt = :codeMgt"),
    @NamedQuery(name = "RubSpecifiqueT.findByCodePenibilite",
        query = "SELECT r FROM RubSpecifiqueT r WHERE r.codePenibilite = :codePenibilite"),
    @NamedQuery(name = "RubSpecifiqueT.findByCodePff",
        query = "SELECT r FROM RubSpecifiqueT r WHERE r.codePff = :codePff"),
    @NamedQuery(name = "RubSpecifiqueT.findByCodePpa",
        query = "SELECT r FROM RubSpecifiqueT r WHERE r.codePpa = :codePpa"),
    @NamedQuery(name = "RubSpecifiqueT.findByCodePpc",
        query = "SELECT r FROM RubSpecifiqueT r WHERE r.codePpc = :codePpc"),
    @NamedQuery(name = "RubSpecifiqueT.findByCodePps",
        query = "SELECT r FROM RubSpecifiqueT r WHERE r.codePps = :codePps"),
    @NamedQuery(name = "RubSpecifiqueT.findByCodePqa",
        query = "SELECT r FROM RubSpecifiqueT r WHERE r.codePqa = :codePqa"),
    @NamedQuery(name = "RubSpecifiqueT.findByCodePqm",
        query = "SELECT r FROM RubSpecifiqueT r WHERE r.codePqm = :codePqm"),
    @NamedQuery(name = "RubSpecifiqueT.findByCodePsa",
        query = "SELECT r FROM RubSpecifiqueT r WHERE r.codePsa = :codePsa"),
    @NamedQuery(name = "RubSpecifiqueT.findByCodePsma",
        query = "SELECT r FROM RubSpecifiqueT r WHERE r.codePsma = :codePsma"),
    @NamedQuery(name = "RubSpecifiqueT.findByCodePsp",
        query = "SELECT r FROM RubSpecifiqueT r WHERE r.codePsp = :codePsp"),
    @NamedQuery(name = "RubSpecifiqueT.findByCodePta",
        query = "SELECT r FROM RubSpecifiqueT r WHERE r.codePta = :codePta"),
    @NamedQuery(name = "RubSpecifiqueT.findByCodeIts",
        query = "SELECT r FROM RubSpecifiqueT r WHERE r.codeIts = :codeIts"),
    @NamedQuery(name = "RubSpecifiqueT.findByCodeResponsabilite",
        query = "SELECT r FROM RubSpecifiqueT r WHERE r.codeResponsabilite = :codeResponsabilite"),
    @NamedQuery(name = "RubSpecifiqueT.findByCodeTransport",
        query = "SELECT r FROM RubSpecifiqueT r WHERE r.codeTransport = :codeTransport"),
    @NamedQuery(name = "RubSpecifiqueT.findByCodeVehicule",
        query = "SELECT r FROM RubSpecifiqueT r WHERE r.codeVehicule = :codeVehicule"),
    @NamedQuery(name = "RubSpecifiqueT.findByTauxNuisance",
        query = "SELECT r FROM RubSpecifiqueT r WHERE r.tauxNuisance = :tauxNuisance"),
    @NamedQuery(name = "RubSpecifiqueT.findByCodeCaisse",
        query = "SELECT r FROM RubSpecifiqueT r WHERE r.codeCaisse = :codeCaisse"),
    @NamedQuery(name = "RubSpecifiqueT.findByCodeExon25",
        query = "SELECT r FROM RubSpecifiqueT r WHERE r.codeExon25 = :codeExon25"),
    @NamedQuery(name = "RubSpecifiqueT.findByCodeDoc",
        query = "SELECT r FROM RubSpecifiqueT r WHERE r.codeDoc = :codeDoc"),
    @NamedQuery(name = "RubSpecifiqueT.findByCodeZonale",
        query = "SELECT r FROM RubSpecifiqueT r WHERE r.codeZonale = :codeZonale"),
    @NamedQuery(name = "RubSpecifiqueT.findByCodeZone",
        query = "SELECT r FROM RubSpecifiqueT r WHERE r.codeZone = :codeZone"),
    @NamedQuery(name = "RubSpecifiqueT.findByCodeWil",
        query = "SELECT r FROM RubSpecifiqueT r WHERE r.codeWil = :codeWil"),
    @NamedQuery(name = "RubSpecifiqueT.findByPhvBase",
        query = "SELECT r FROM RubSpecifiqueT r WHERE r.phvBase = :phvBase"),
    @NamedQuery(name = "RubSpecifiqueT.findByPhvReel",
        query = "SELECT r FROM RubSpecifiqueT r WHERE r.phvReel = :phvReel"),
    @NamedQuery(name = "RubSpecifiqueT.findByCodeFctPn",
        query = "SELECT r FROM RubSpecifiqueT r WHERE r.codeFctPn = :codeFctPn"),
    @NamedQuery(name = "RubSpecifiqueT.findByCodeQualifPn",
        query = "SELECT r FROM RubSpecifiqueT r WHERE r.codeQualifPn = :codeQualifPn"),
    @NamedQuery(name = "RubSpecifiqueT.findByCodeMachine",
        query = "SELECT r FROM RubSpecifiqueT r WHERE r.codeMachine = :codeMachine"),
    @NamedQuery(name = "RubSpecifiqueT.findByTypeContrat",
        query = "SELECT r FROM RubSpecifiqueT r WHERE r.typeContrat = :typeContrat"),
    @NamedQuery(name = "RubSpecifiqueT.findByCodeTech",
        query = "SELECT r FROM RubSpecifiqueT r WHERE r.codeTech = :codeTech"),
    @NamedQuery(name = "RubSpecifiqueT.findByIndice",
        query = "SELECT r FROM RubSpecifiqueT r WHERE r.indice = :indice"),
    @NamedQuery(name = "RubSpecifiqueT.findBySalaireBase",
        query = "SELECT r FROM RubSpecifiqueT r WHERE r.salaireBase = :salaireBase"),
    @NamedQuery(name = "RubSpecifiqueT.findByMontDevise",
        query = "SELECT r FROM RubSpecifiqueT r WHERE r.montDevise = :montDevise"),
    @NamedQuery(name = "RubSpecifiqueT.findByNumMgt",
        query = "SELECT r FROM RubSpecifiqueT r WHERE r.numMgt = :numMgt"),
    @NamedQuery(name = "RubSpecifiqueT.findByNumCaat",
        query = "SELECT r FROM RubSpecifiqueT r WHERE r.numCaat = :numCaat")})
public class RubSpecifiqueT implements Serializable {
  private static final long serialVersionUID = 1L;
  @EmbeddedId
  protected RubSpecifiqueTPK rubSpecifiqueTPK;
  // @Max(value=?) @Min(value=?)//if you know range of your decimal fields consider using these
  // annotations to enforce field validation
  @Column(name = "ANCIENNETE")
  private BigDecimal anciennete;
  @Column(name = "CODE_ABAT_IRG")
  private Short codeAbatIrg;
  @Column(name = "CODE_ASTREINTE")
  private Boolean codeAstreinte;
  @Column(name = "CODE_CAAT")
  private Short codeCaat;
  @Column(name = "CODE_CAF")
  private Boolean codeCaf;
  @Column(name = "CODE_DISPONIBILITE")
  private Boolean codeDisponibilite;
  @Column(name = "CODE_ENTRETIEN")
  private Short codeEntretien;
  @Column(name = "CODE_FOYER")
  private Boolean codeFoyer;
  @Column(name = "CODE_HABILLEMENT")
  private Short codeHabillement;
  @Column(name = "CODE_IFSP")
  private Boolean codeIfsp;
  @Column(name = "CODE_IGM")
  private Short codeIgm;
  @Column(name = "CODE_IPSU")
  private Short codeIpsu;
  @Column(name = "CODE_ITP")
  private Short codeItp;
  @Column(name = "CODE_MGT")
  private BigDecimal codeMgt;
  @Column(name = "CODE_PENIBILITE")
  private Boolean codePenibilite;
  @Column(name = "CODE_PFF")
  private Short codePff;
  @Column(name = "CODE_PPA")
  private Boolean codePpa;
  @Column(name = "CODE_PPC")
  private Short codePpc;
  @Column(name = "CODE_PPS")
  private Short codePps;
  @Column(name = "CODE_PQA")
  private Short codePqa;
  @Column(name = "CODE_PQM")
  private Short codePqm;
  @Column(name = "CODE_PSA")
  private Short codePsa;
  @Column(name = "CODE_PSMA")
  private Boolean codePsma;
  @Column(name = "CODE_PSP")
  private Short codePsp;
  @Column(name = "CODE_PTA")
  private Boolean codePta;
  @Column(name = "CODE_ITS")
  private Short codeIts;
  @Column(name = "CODE_RESPONSABILITE")
  private Short codeResponsabilite;
  @Column(name = "CODE_TRANSPORT")
  private Short codeTransport;
  @Column(name = "CODE_VEHICULE")
  private Short codeVehicule;
  @Column(name = "TAUX_NUISANCE")
  private BigDecimal tauxNuisance;
  @Column(name = "CODE_CAISSE")
  private Short codeCaisse;
  @Column(name = "CODE_EXON25")
  private Boolean codeExon25;
  @Column(name = "CODE_DOC")
  private Short codeDoc;
  @Column(name = "CODE_ZONALE")
  private Short codeZonale;
  @Column(name = "CODE_ZONE")
  private Short codeZone;
  @Size(max = 2)
  @Column(name = "CODE_WIL")
  private String codeWil;
  @Column(name = "PHV_BASE")
  private BigDecimal phvBase;
  @Column(name = "PHV_REEL")
  private BigDecimal phvReel;
  @Column(name = "CODE_FCT_PN")
  private Character codeFctPn;
  @Column(name = "CODE_QUALIF_PN")
  private Character codeQualifPn;
  @Column(name = "CODE_MACHINE")
  private Character codeMachine;
  @Column(name = "TYPE_CONTRAT")
  private Character typeContrat;
  @Column(name = "CODE_TECH")
  private Character codeTech;
  @Column(name = "INDICE")
  private Short indice;
  @Column(name = "SALAIRE_BASE")
  private BigDecimal salaireBase;
  @Column(name = "MONT_DEVISE")
  private BigDecimal montDevise;
  @Size(max = 30)
  @Column(name = "NUM_MGT")
  private String numMgt;
  @Size(max = 30)
  @Column(name = "NUM_CAAT")
  private String numCaat;

  public RubSpecifiqueT() {}

  public RubSpecifiqueT(RubSpecifiqueTPK rubSpecifiqueTPK) {
    this.rubSpecifiqueTPK = rubSpecifiqueTPK;
  }

  public RubSpecifiqueT(int matricule, int dateTrt) {
    this.rubSpecifiqueTPK = new RubSpecifiqueTPK(matricule, dateTrt);
  }

  public RubSpecifiqueTPK getRubSpecifiqueTPK() {
    return rubSpecifiqueTPK;
  }

  public void setRubSpecifiqueTPK(RubSpecifiqueTPK rubSpecifiqueTPK) {
    this.rubSpecifiqueTPK = rubSpecifiqueTPK;
  }

  public BigDecimal getAnciennete() {
    return anciennete;
  }

  public void setAnciennete(BigDecimal anciennete) {
    this.anciennete = anciennete;
  }

  public Short getCodeAbatIrg() {
    return codeAbatIrg;
  }

  public void setCodeAbatIrg(Short codeAbatIrg) {
    this.codeAbatIrg = codeAbatIrg;
  }

  public Boolean getCodeAstreinte() {
    return codeAstreinte;
  }

  public void setCodeAstreinte(Boolean codeAstreinte) {
    this.codeAstreinte = codeAstreinte;
  }

  public Short getCodeCaat() {
    return codeCaat;
  }

  public void setCodeCaat(Short codeCaat) {
    this.codeCaat = codeCaat;
  }

  public Boolean getCodeCaf() {
    return codeCaf;
  }

  public void setCodeCaf(Boolean codeCaf) {
    this.codeCaf = codeCaf;
  }

  public Boolean getCodeDisponibilite() {
    return codeDisponibilite;
  }

  public void setCodeDisponibilite(Boolean codeDisponibilite) {
    this.codeDisponibilite = codeDisponibilite;
  }

  public Short getCodeEntretien() {
    return codeEntretien;
  }

  public void setCodeEntretien(Short codeEntretien) {
    this.codeEntretien = codeEntretien;
  }

  public Boolean getCodeFoyer() {
    return codeFoyer;
  }

  public void setCodeFoyer(Boolean codeFoyer) {
    this.codeFoyer = codeFoyer;
  }

  public Short getCodeHabillement() {
    return codeHabillement;
  }

  public void setCodeHabillement(Short codeHabillement) {
    this.codeHabillement = codeHabillement;
  }

  public Boolean getCodeIfsp() {
    return codeIfsp;
  }

  public void setCodeIfsp(Boolean codeIfsp) {
    this.codeIfsp = codeIfsp;
  }

  public Short getCodeIgm() {
    return codeIgm;
  }

  public void setCodeIgm(Short codeIgm) {
    this.codeIgm = codeIgm;
  }

  public Short getCodeIpsu() {
    return codeIpsu;
  }

  public void setCodeIpsu(Short codeIpsu) {
    this.codeIpsu = codeIpsu;
  }

  public Short getCodeItp() {
    return codeItp;
  }

  public void setCodeItp(Short codeItp) {
    this.codeItp = codeItp;
  }

  public Boolean getCodePenibilite() {
    return codePenibilite;
  }

  public void setCodePenibilite(Boolean codePenibilite) {
    this.codePenibilite = codePenibilite;
  }

  public Short getCodePff() {
    return codePff;
  }

  public void setCodePff(Short codePff) {
    this.codePff = codePff;
  }

  public Boolean getCodePpa() {
    return codePpa;
  }

  public void setCodePpa(Boolean codePpa) {
    this.codePpa = codePpa;
  }

  public Short getCodePpc() {
    return codePpc;
  }

  public void setCodePpc(Short codePpc) {
    this.codePpc = codePpc;
  }

  public Short getCodePps() {
    return codePps;
  }

  public void setCodePps(Short codePps) {
    this.codePps = codePps;
  }

  public Short getCodePqa() {
    return codePqa;
  }

  public void setCodePqa(Short codePqa) {
    this.codePqa = codePqa;
  }

  public Short getCodePqm() {
    return codePqm;
  }

  public void setCodePqm(Short codePqm) {
    this.codePqm = codePqm;
  }

  public Short getCodePsa() {
    return codePsa;
  }

  public void setCodePsa(Short codePsa) {
    this.codePsa = codePsa;
  }

  public Boolean getCodePsma() {
    return codePsma;
  }

  public void setCodePsma(Boolean codePsma) {
    this.codePsma = codePsma;
  }

  public Short getCodePsp() {
    return codePsp;
  }

  public void setCodePsp(Short codePsp) {
    this.codePsp = codePsp;
  }

  public Boolean getCodePta() {
    return codePta;
  }

  public void setCodePta(Boolean codePta) {
    this.codePta = codePta;
  }

  public Short getCodeIts() {
    return codeIts;
  }

  public void setCodeIts(Short codeIts) {
    this.codeIts = codeIts;
  }

  public Short getCodeResponsabilite() {
    return codeResponsabilite;
  }

  public void setCodeResponsabilite(Short codeResponsabilite) {
    this.codeResponsabilite = codeResponsabilite;
  }

  public Short getCodeTransport() {
    return codeTransport;
  }

  public void setCodeTransport(Short codeTransport) {
    this.codeTransport = codeTransport;
  }

  public Short getCodeVehicule() {
    return codeVehicule;
  }

  public void setCodeVehicule(Short codeVehicule) {
    this.codeVehicule = codeVehicule;
  }

  public BigDecimal getTauxNuisance() {
    return tauxNuisance;
  }

  public void setTauxNuisance(BigDecimal tauxNuisance) {
    this.tauxNuisance = tauxNuisance;
  }

  public Short getCodeCaisse() {
    return codeCaisse;
  }

  public void setCodeCaisse(Short codeCaisse) {
    this.codeCaisse = codeCaisse;
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

  public Short getCodeZonale() {
    return codeZonale;
  }

  public void setCodeZonale(Short codeZonale) {
    this.codeZonale = codeZonale;
  }

  public Short getCodeZone() {
    return codeZone;
  }

  public void setCodeZone(Short codeZone) {
    this.codeZone = codeZone;
  }

  public String getCodeWil() {
    return codeWil;
  }

  public void setCodeWil(String codeWil) {
    this.codeWil = codeWil;
  }

  public BigDecimal getPhvBase() {
    return phvBase;
  }

  public void setPhvBase(BigDecimal phvBase) {
    this.phvBase = phvBase;
  }

  public BigDecimal getPhvReel() {
    return phvReel;
  }

  public void setPhvReel(BigDecimal phvReel) {
    this.phvReel = phvReel;
  }

  public Character getCodeFctPn() {
    return codeFctPn;
  }

  public void setCodeFctPn(Character codeFctPn) {
    this.codeFctPn = codeFctPn;
  }

  public Character getCodeQualifPn() {
    return codeQualifPn;
  }

  public void setCodeQualifPn(Character codeQualifPn) {
    this.codeQualifPn = codeQualifPn;
  }

  public Character getCodeMachine() {
    return codeMachine;
  }

  public void setCodeMachine(Character codeMachine) {
    this.codeMachine = codeMachine;
  }

  public Character getTypeContrat() {
    return typeContrat;
  }

  public void setTypeContrat(Character typeContrat) {
    this.typeContrat = typeContrat;
  }

  public Character getCodeTech() {
    return codeTech;
  }

  public void setCodeTech(Character codeTech) {
    this.codeTech = codeTech;
  }

  public Short getIndice() {
    return indice;
  }

  public void setIndice(Short indice) {
    this.indice = indice;
  }

  public BigDecimal getSalaireBase() {
    return salaireBase;
  }

  public void setSalaireBase(BigDecimal salaireBase) {
    this.salaireBase = salaireBase;
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
    hash += (rubSpecifiqueTPK != null ? rubSpecifiqueTPK.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof RubSpecifiqueT)) {
      return false;
    }
    RubSpecifiqueT other = (RubSpecifiqueT) object;
    if ((this.rubSpecifiqueTPK == null && other.rubSpecifiqueTPK != null)
        || (this.rubSpecifiqueTPK != null
            && !this.rubSpecifiqueTPK.equals(other.rubSpecifiqueTPK))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "dz.ah.MLD.controlleur.RubSpecifiqueT[ rubSpecifiqueTPK=" + rubSpecifiqueTPK + " ]";
  }

  public BigDecimal getCodeMgt() {
    return codeMgt;
  }

  public void setCodeMgt(BigDecimal codeMgt) {
    this.codeMgt = codeMgt;
  }

}
