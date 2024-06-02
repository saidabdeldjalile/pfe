/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.grh.model.entities.social.impots;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author AGHA Riadh
 */
@Entity
@Table(name = "IMPOT", schema = "T_BP")
@XmlRootElement
@NamedQueries({@NamedQuery(name = "Impot.findAll", query = "SELECT i FROM Impot i"),
    @NamedQuery(name = "Impot.findById", query = "SELECT i FROM Impot i WHERE i.id = :id"),
    @NamedQuery(name = "Impot.findByMatricule",
        query = "SELECT i FROM Impot i WHERE i.matricule = :matricule"),
    @NamedQuery(name = "Impot.findByAnneeTrt",
        query = "SELECT i FROM Impot i WHERE i.anneeTrt = :anneeTrt"),
    @NamedQuery(name = "Impot.findByMoisTrt",
        query = "SELECT i FROM Impot i WHERE i.moisTrt = :moisTrt"),
    @NamedQuery(name = "Impot.findByAnneePaie",
        query = "SELECT i FROM Impot i WHERE i.anneePaie = :anneePaie"),
    @NamedQuery(name = "Impot.findByMois", query = "SELECT i FROM Impot i WHERE i.mois = :mois"),
    @NamedQuery(name = "Impot.findByCodeWil",
        query = "SELECT i FROM Impot i WHERE i.codeWil = :codeWil"),
    @NamedQuery(name = "Impot.findByCodeFil",
        query = "SELECT i FROM Impot i WHERE i.codeFil = :codeFil"),
    @NamedQuery(name = "Impot.findByBulPrim",
        query = "SELECT i FROM Impot i WHERE i.bulPrim = :bulPrim"),
    @NamedQuery(name = "Impot.findByCodeReg",
        query = "SELECT i FROM Impot i WHERE i.codeReg = :codeReg"),
    @NamedQuery(name = "Impot.findByCodeFct",
        query = "SELECT i FROM Impot i WHERE i.codeFct = :codeFct"),
    @NamedQuery(name = "Impot.findByCodeCivil",
        query = "SELECT i FROM Impot i WHERE i.codeCivil = :codeCivil"),
    @NamedQuery(name = "Impot.findByEnfantm10",
        query = "SELECT i FROM Impot i WHERE i.enfantm10 = :enfantm10"),
    @NamedQuery(name = "Impot.findByCodeIts",
        query = "SELECT i FROM Impot i WHERE i.codeIts = :codeIts"),
    @NamedQuery(name = "Impot.findBySoumis",
        query = "SELECT i FROM Impot i WHERE i.soumis = :soumis"),
    @NamedQuery(name = "Impot.findByNetFiscal",
        query = "SELECT i FROM Impot i WHERE i.netFiscal = :netFiscal"),
    @NamedQuery(name = "Impot.findByIrg", query = "SELECT i FROM Impot i WHERE i.irg = :irg"),
    @NamedQuery(name = "Impot.findByVersementForfaitaire",
        query = "SELECT i FROM Impot i WHERE i.versementForfaitaire = :versementForfaitaire")})
public class Impot implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @NotNull
  @Column(name = "ID")
  private Integer id;
  @Basic(optional = false)
  @NotNull
  @Column(name = "MATRICULE")
  private int matricule;
  @Basic(optional = false)
  @NotNull
  @Column(name = "ANNEE_TRT")
  private short anneeTrt;
  @Basic(optional = false)
  @NotNull
  @Column(name = "MOIS_TRT")
  private int moisTrt;
  @Basic(optional = false)
  @NotNull
  @Column(name = "ANNEE_PAIE")
  private short anneePaie;
  @Basic(optional = false)
  @NotNull
  @Column(name = "MOIS")
  private int mois;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 2)
  @Column(name = "CODE_WIL")
  private String codeWil;
  @Column(name = "CODE_FIL")
  private Character codeFil;
  @Column(name = "BUL_PRIM")
  private Boolean bulPrim;
  @Column(name = "CODE_REG")
  private Integer codeReg;
  @Size(max = 12)
  @Column(name = "CODE_FCT")
  private String codeFct;
  @Size(max = 1)
  @Column(name = "CODE_CIVIL")
  private String codeCivil;
  @Column(name = "ENFANTM10")
  private Integer enfantm10;
  @Column(name = "CODE_ITS")
  private Integer codeIts;
  // @Max(value=?) @Min(value=?)//if you know range of your decimal fields consider using these
  // annotations to enforce field validation
  @Column(name = "SOUMIS")
  private BigDecimal soumis;
  @Column(name = "NET_FISCAL")
  private BigDecimal netFiscal;
  @Column(name = "IRG")
  private BigDecimal irg;
  @Column(name = "VERSEMENT_FORFAITAIRE")
  private BigDecimal versementForfaitaire;

  public Impot() {}

  public Impot(Integer id) {
    this.id = id;
  }

  public Impot(Integer id, int matricule, short anneeTrt, int moisTrt, short anneePaie, int mois,
      String codeWil) {
    this.id = id;
    this.matricule = matricule;
    this.anneeTrt = anneeTrt;
    this.moisTrt = moisTrt;
    this.anneePaie = anneePaie;
    this.mois = mois;
    this.codeWil = codeWil;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public int getMatricule() {
    return matricule;
  }

  public void setMatricule(int matricule) {
    this.matricule = matricule;
  }

  public short getAnneeTrt() {
    return anneeTrt;
  }

  public void setAnneeTrt(short anneeTrt) {
    this.anneeTrt = anneeTrt;
  }

  public int getMoisTrt() {
    return moisTrt;
  }

  public void setMoisTrt(int moisTrt) {
    this.moisTrt = moisTrt;
  }

  public short getAnneePaie() {
    return anneePaie;
  }

  public void setAnneePaie(short anneePaie) {
    this.anneePaie = anneePaie;
  }

  public int getMois() {
    return mois;
  }

  public void setMois(int mois) {
    this.mois = mois;
  }

  public String getCodeWil() {
    return codeWil;
  }

  public void setCodeWil(String codeWil) {
    this.codeWil = codeWil;
  }

  public Character getCodeFil() {
    return codeFil;
  }

  public void setCodeFil(Character codeFil) {
    this.codeFil = codeFil;
  }

  public Boolean getBulPrim() {
    return bulPrim;
  }

  public void setBulPrim(Boolean bulPrim) {
    this.bulPrim = bulPrim;
  }

  public Integer getCodeReg() {
    return codeReg;
  }

  public void setCodeReg(Integer codeReg) {
    this.codeReg = codeReg;
  }

  public String getCodeFct() {
    return codeFct;
  }

  public void setCodeFct(String codeFct) {
    this.codeFct = codeFct;
  }

  public String getCodeCivil() {
    return codeCivil;
  }

  public void setCodeCivil(String codeCivil) {
    this.codeCivil = codeCivil;
  }

  public Integer getEnfantm10() {
    return enfantm10;
  }

  public void setEnfantm10(Integer enfantm10) {
    this.enfantm10 = enfantm10;
  }

  public Integer getCodeIts() {
    return codeIts;
  }

  public void setCodeIts(Integer codeIts) {
    this.codeIts = codeIts;
  }

  public BigDecimal getSoumis() {
    return soumis;
  }

  public void setSoumis(BigDecimal soumis) {
    this.soumis = soumis;
  }

  public BigDecimal getNetFiscal() {
    return netFiscal;
  }

  public void setNetFiscal(BigDecimal netFiscal) {
    this.netFiscal = netFiscal;
  }

  public BigDecimal getIrg() {
    return irg;
  }

  public void setIrg(BigDecimal irg) {
    this.irg = irg;
  }

  public BigDecimal getVersementForfaitaire() {
    return versementForfaitaire;
  }

  public void setVersementForfaitaire(BigDecimal versementForfaitaire) {
    this.versementForfaitaire = versementForfaitaire;
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
    if (!(object instanceof Impot)) {
      return false;
    }
    Impot other = (Impot) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "dz.airalgerie.commun.grh.retraite.entities.Impot[ id=" + id + " ]";
  }
  
  

}
