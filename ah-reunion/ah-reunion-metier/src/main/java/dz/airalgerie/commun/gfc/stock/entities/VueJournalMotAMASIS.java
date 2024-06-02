/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.commun.gfc.stock.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author user
 */
@Entity
@Table(name = "STK.V_JOURNAL_MotAMASIS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VueJournalMot.findAll", query = "SELECT v FROM VueJournalMotAMASIS v"),
    @NamedQuery(name = "VueJournalMot.findByLibStk",
        query = "SELECT v FROM VueJournalMotAMASIS v WHERE v.libStk = :libStk"),
    @NamedQuery(name = "VueJournalMot.findByPag",
        query = "SELECT v FROM VueJournalMotAMASIS v WHERE v.pag = :pag"),
    @NamedQuery(name = "VueJournalMot.findByCompte",
        query = "SELECT v FROM VueJournalMotAMASIS v WHERE v.compte = :compte"),
    @NamedQuery(name = "VueJournalMot.findByLibMvt",
        query = "SELECT v FROM VueJournalMotAMASIS v WHERE v.libMvt = :libMvt"),
    @NamedQuery(name = "VueJournalMot.findByDateTraitSTK",
        query = "SELECT v FROM VueJournalMotAMASIS v WHERE v.dateTraitSTK = :dateTraitSTK"),
    @NamedQuery(name = "VueJournalMot.findBySigne",
        query = "SELECT v FROM VueJournalMotAMASIS v WHERE v.signe = :signe"),
    @NamedQuery(name = "VueJournalMot.findByCgener",
        query = "SELECT v FROM VueJournalMotAMASIS v WHERE v.cgener = :cgener"),
    @NamedQuery(name = "VueJournalMot.findByCpartic",
        query = "SELECT v FROM VueJournalMotAMASIS v WHERE v.cpartic = :cpartic"),
    @NamedQuery(name = "VueJournalMot.findByMois",
        query = "SELECT v FROM VueJournalMotAMASIS v WHERE v.mois = :mois"),
    @NamedQuery(name = "VueJournalMot.findByAnnee",
        query = "SELECT v FROM VueJournalMotAMASIS v WHERE v.annee = :annee"),
    @NamedQuery(name = "VueJournalMot.findByDebit",
        query = "SELECT v FROM VueJournalMotAMASIS v WHERE v.debit = :debit"),
    @NamedQuery(name = "VueJournalMot.findByCredit",
        query = "SELECT v FROM VueJournalMotAMASIS v WHERE v.credit = :credit"),
    @NamedQuery(name = "VueJournalMot.findByNewVal",
        query = "SELECT v FROM VueJournalMotAMASIS v WHERE v.newVal = :newVal"),
    @NamedQuery(name = "VueJournalMot.findByNewLibMvt",
        query = "SELECT v FROM VueJournalMotAMASIS v WHERE v.newLibMvt = :newLibMvt"),
    @NamedQuery(name = "VueJournalMot.findByOrdreLibMvt",
        query = "SELECT v FROM VueJournalMotAMASIS v WHERE v.ordreLibMvt = :ordreLibMvt")})
public class VueJournalMotAMASIS implements Serializable {
  private static final long serialVersionUID = 1L;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 6)
  @Column(name = "libStk")
  private String libStk;
  @Size(max = 3)
  @Column(name = "pag")
  private String pag;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 12)
  @Column(name = "compte")
  private String compte;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 20)
  @Column(name = "libMvt")
  private String libMvt;
  @Id
  @Basic(optional = false)
  @NotNull
  @Column(name = "dateTraitSTK")
  private int dateTraitSTK;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 1)
  @Column(name = "signe")
  private String signe;
  @Size(max = 7)
  @Column(name = "cgener")
  private String cgener;
  @Size(max = 6)
  @Column(name = "cpartic")
  private String cpartic;
  @Size(max = 2)
  @Column(name = "mois")
  private String mois;
  @Size(max = 4)
  @Column(name = "annee")
  private String annee;
  @Size(max = 18)
  @Column(name = "debit")
  private String debit;
  @Size(max = 18)
  @Column(name = "credit")
  private String credit;
  // @Max(value=?) @Min(value=?)//if you know range of your decimal fields consider using these
  // annotations to enforce field validation
  @Column(name = "newVal")
  private BigDecimal newVal;
  @Size(max = 20)
  @Column(name = "newLibMvt")
  private String newLibMvt;
  @Size(max = 1)
  @Column(name = "ordreLibMvt")
  private String ordreLibMvt;

  public VueJournalMotAMASIS() {}

  public String getLibStk() {
    return libStk;
  }

  public void setLibStk(String libStk) {
    this.libStk = libStk;
  }

  public String getPag() {
    return pag;
  }

  public void setPag(String pag) {
    this.pag = pag;
  }

  public String getCompte() {
    return compte;
  }

  public void setCompte(String compte) {
    this.compte = compte;
  }

  public String getLibMvt() {
    return libMvt;
  }

  public void setLibMvt(String libMvt) {
    this.libMvt = libMvt;
  }

  public int getDateTraitSTK() {
    return dateTraitSTK;
  }

  public void setDateTraitSTK(int dateTraitSTK) {
    this.dateTraitSTK = dateTraitSTK;
  }

  public String getSigne() {
    return signe;
  }

  public void setSigne(String signe) {
    this.signe = signe;
  }

  public String getCgener() {
    return cgener;
  }

  public void setCgener(String cgener) {
    this.cgener = cgener;
  }

  public String getCpartic() {
    return cpartic;
  }

  public void setCpartic(String cpartic) {
    this.cpartic = cpartic;
  }

  public String getMois() {
    return mois;
  }

  public void setMois(String mois) {
    this.mois = mois;
  }

  public String getAnnee() {
    return annee;
  }

  public void setAnnee(String annee) {
    this.annee = annee;
  }

  public String getDebit() {
    return debit;
  }

  public void setDebit(String debit) {
    this.debit = debit;
  }

  public String getCredit() {
    return credit;
  }

  public void setCredit(String credit) {
    this.credit = credit;
  }

  public BigDecimal getNewVal() {
    return newVal;
  }

  public void setNewVal(BigDecimal newVal) {
    this.newVal = newVal;
  }

  public String getNewLibMvt() {
    return newLibMvt;
  }

  public void setNewLibMvt(String newLibMvt) {
    this.newLibMvt = newLibMvt;
  }

  public String getOrdreLibMvt() {
    return ordreLibMvt;
  }

  public void setOrdreLibMvt(String ordreLibMvt) {
    this.ordreLibMvt = ordreLibMvt;
  }

}
