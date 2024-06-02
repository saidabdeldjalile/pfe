/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.gfc.model.entities.etat.cr;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrateur
 */
@Entity
@Table(name = "CR.GLOBAL")
@XmlRootElement
@NamedQueries({@NamedQuery(name = "Global.findAll", query = "SELECT g FROM Global g"),
    @NamedQuery(name = "Global.findById",
        query = "SELECT g FROM Global g WHERE g.globalPK.id = :id"),
    @NamedQuery(name = "Global.findByCodeDoc",
        query = "SELECT g FROM Global g WHERE g.globalPK.codeDoc = :codeDoc"),
    @NamedQuery(name = "Global.findByDateTrt",
        query = "SELECT g FROM Global g WHERE g.globalPK.dateTrt = :dateTrt"),
    @NamedQuery(name = "Global.findByCptUnite",
        query = "SELECT g FROM Global g WHERE g.cptUnite = :cptUnite"),
    @NamedQuery(name = "Global.findByCptCompte",
        query = "SELECT g FROM Global g WHERE g.cptCompte = :cptCompte"),
    @NamedQuery(name = "Global.findByCptLibelle",
        query = "SELECT g FROM Global g WHERE g.cptLibelle = :cptLibelle"),
    @NamedQuery(name = "Global.findByCptDebit",
        query = "SELECT g FROM Global g WHERE g.cptDebit = :cptDebit"),
    @NamedQuery(name = "Global.findByCptCredit",
        query = "SELECT g FROM Global g WHERE g.cptCredit = :cptCredit"),
    @NamedQuery(name = "Global.findByCptCodeMonnaie",
        query = "SELECT g FROM Global g WHERE g.cptCodeMonnaie = :cptCodeMonnaie"),
    @NamedQuery(name = "Global.findByCptPieceA",
        query = "SELECT g FROM Global g WHERE g.cptPieceA = :cptPieceA"),
    @NamedQuery(name = "Global.findByCptPageA",
        query = "SELECT g FROM Global g WHERE g.cptPageA = :cptPageA"),
    @NamedQuery(name = "Global.findByCptNumJournal",
        query = "SELECT g FROM Global g WHERE g.cptNumJournal = :cptNumJournal"),
    @NamedQuery(name = "Global.findByCodeApplication",
        query = "SELECT g FROM Global g WHERE g.codeApplication = :codeApplication"),
    @NamedQuery(name = "Global.findByJv", query = "SELECT g FROM Global g WHERE g.jv = :jv")})
public class Global implements Serializable {

  private static final long serialVersionUID = 1L;
  @EmbeddedId
  protected GlobalPK globalPK;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 2)
  @Column(name = "CPT_UNITE")
  private String cptUnite;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 12)
  @Column(name = "CPT_COMPTE")
  private String cptCompte;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 30)
  @Column(name = "CPT_LIBELLE")
  private String cptLibelle;
  @Basic(optional = false)
  @NotNull
  @Column(name = "CPT_DEBIT")
  private BigDecimal cptDebit;
  @Basic(optional = false)
  @NotNull
  @Column(name = "CPT_CREDIT")
  private BigDecimal cptCredit;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 3)
  @Column(name = "CPT_CODE_MONNAIE")
  private String cptCodeMonnaie;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 5)
  @Column(name = "CPT_PIECE_A")
  private String cptPieceA;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 4)
  @Column(name = "CPT_PAGE_A")
  private String cptPageA;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 2)
  @Column(name = "CPT_NUM_JOURNAL")
  private String cptNumJournal;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 3)
  @Column(name = "CODE_APPLICATION")
  private String codeApplication;
  @Size(max = 6)
  @Column(name = "JV")
  private String jv;

  public Global() {}

  public Global(GlobalPK globalPK) {
    this.globalPK = globalPK;
  }

  public Global(GlobalPK globalPK, String cptUnite, String cptCompte, String cptLibelle,
      BigDecimal cptDebit, BigDecimal cptCredit, String cptCodeMonnaie, String cptPieceA,
      String cptPageA, String cptNumJournal, String codeApplication) {
    this.globalPK = globalPK;
    this.cptUnite = cptUnite;
    this.cptCompte = cptCompte;
    this.cptLibelle = cptLibelle;
    this.cptDebit = cptDebit;
    this.cptCredit = cptCredit;
    this.cptCodeMonnaie = cptCodeMonnaie;
    this.cptPieceA = cptPieceA;
    this.cptPageA = cptPageA;
    this.cptNumJournal = cptNumJournal;
    this.codeApplication = codeApplication;
  }

  public Global(int id, String codeDoc, int dateTrt) {
    this.globalPK = new GlobalPK(id, codeDoc, dateTrt);
  }

  public GlobalPK getGlobalPK() {
    return globalPK;
  }

  public void setGlobalPK(GlobalPK globalPK) {
    this.globalPK = globalPK;
  }

  public String getCptUnite() {
    return cptUnite;
  }

  public void setCptUnite(String cptUnite) {
    this.cptUnite = cptUnite;
  }

  public String getCptCompte() {
    return cptCompte;
  }

  public void setCptCompte(String cptCompte) {
    this.cptCompte = cptCompte;
  }

  public String getCptLibelle() {
    return cptLibelle;
  }

  public void setCptLibelle(String cptLibelle) {
    this.cptLibelle = cptLibelle;
  }

  public BigDecimal getCptDebit() {
    return cptDebit;
  }

  public void setCptDebit(BigDecimal cptDebit) {
    this.cptDebit = cptDebit;
  }

  public BigDecimal getCptCredit() {
    return cptCredit;
  }

  public void setCptCredit(BigDecimal cptCredit) {
    this.cptCredit = cptCredit;
  }

  public String getCptCodeMonnaie() {
    return cptCodeMonnaie;
  }

  public void setCptCodeMonnaie(String cptCodeMonnaie) {
    this.cptCodeMonnaie = cptCodeMonnaie;
  }

  public String getCptPieceA() {
    return cptPieceA;
  }

  public void setCptPieceA(String cptPieceA) {
    this.cptPieceA = cptPieceA;
  }

  public String getCptPageA() {
    return cptPageA;
  }

  public void setCptPageA(String cptPageA) {
    this.cptPageA = cptPageA;
  }

  public String getCptNumJournal() {
    return cptNumJournal;
  }

  public void setCptNumJournal(String cptNumJournal) {
    this.cptNumJournal = cptNumJournal;
  }

  public String getCodeApplication() {
    return codeApplication;
  }

  public void setCodeApplication(String codeApplication) {
    this.codeApplication = codeApplication;
  }

  public String getJv() {
    return jv;
  }

  public void setJv(String jv) {
    this.jv = jv;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (globalPK != null ? globalPK.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Global)) {
      return false;
    }
    Global other = (Global) object;
    if ((this.globalPK == null && other.globalPK != null)
        || (this.globalPK != null && !this.globalPK.equals(other.globalPK))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "ENTITY.Global[ globalPK=" + globalPK + " ]";
  }

}
