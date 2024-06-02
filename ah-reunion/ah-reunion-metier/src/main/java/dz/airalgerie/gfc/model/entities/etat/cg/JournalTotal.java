/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.gfc.model.entities.etat.cg;

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
@Table(name = "JOURNAL_TOTAL")
@XmlRootElement
@NamedQueries({@NamedQuery(name = "JournalTotal.findAll", query = "SELECT j FROM JournalTotal j"),
    @NamedQuery(name = "JournalTotal.findByDateTrt",
        query = "SELECT j FROM JournalTotal j WHERE j.journalTotalPK.dateTrt = :dateTrt"),
    @NamedQuery(name = "JournalTotal.findByNumJournal",
        query = "SELECT j FROM JournalTotal j WHERE j.journalTotalPK.numJournal = :numJournal"),
    @NamedQuery(name = "JournalTotal.findByLibelle",
        query = "SELECT j FROM JournalTotal j WHERE j.libelle = :libelle"),
    @NamedQuery(name = "JournalTotal.findByDebit",
        query = "SELECT j FROM JournalTotal j WHERE j.debit = :debit"),
    @NamedQuery(name = "JournalTotal.findByCredit",
        query = "SELECT j FROM JournalTotal j WHERE j.credit = :credit"),
    @NamedQuery(name = "JournalTotal.findByNbrEcriture",
        query = "SELECT j FROM JournalTotal j WHERE j.nbrEcriture = :nbrEcriture")})
public class JournalTotal implements Serializable {

  private static final long serialVersionUID = 1L;
  @EmbeddedId
  protected JournalTotalPK journalTotalPK;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 100)
  @Column(name = "LIBELLE")
  private String libelle;
  // @Max(value=?) @Min(value=?)//if you know range of your decimal fields consider using these
  // annotations to enforce field validation
  @Basic(optional = false)
  @NotNull
  @Column(name = "DEBIT")
  private BigDecimal debit;
  @Basic(optional = false)
  @NotNull
  @Column(name = "CREDIT")
  private BigDecimal credit;
  @Basic(optional = false)
  @NotNull
  @Column(name = "NBR_ECRITURE")
  private int nbrEcriture;

  public JournalTotal() {}

  public JournalTotal(JournalTotalPK journalTotalPK) {
    this.journalTotalPK = journalTotalPK;
  }

  public JournalTotal(JournalTotalPK journalTotalPK, String libelle, BigDecimal debit,
      BigDecimal credit, int nbrEcriture) {
    this.journalTotalPK = journalTotalPK;
    this.libelle = libelle;
    this.debit = debit;
    this.credit = credit;
    this.nbrEcriture = nbrEcriture;
  }

  public JournalTotal(int dateTrt, String numJournal) {
    this.journalTotalPK = new JournalTotalPK(dateTrt, numJournal);
  }

  public JournalTotalPK getJournalTotalPK() {
    return journalTotalPK;
  }

  public void setJournalTotalPK(JournalTotalPK journalTotalPK) {
    this.journalTotalPK = journalTotalPK;
  }

  public String getLibelle() {
    return libelle;
  }

  public void setLibelle(String libelle) {
    this.libelle = libelle;
  }

  public BigDecimal getDebit() {
    return debit;
  }

  public void setDebit(BigDecimal debit) {
    this.debit = debit;
  }

  public BigDecimal getCredit() {
    return credit;
  }

  public void setCredit(BigDecimal credit) {
    this.credit = credit;
  }

  public int getNbrEcriture() {
    return nbrEcriture;
  }

  public void setNbrEcriture(int nbrEcriture) {
    this.nbrEcriture = nbrEcriture;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (journalTotalPK != null ? journalTotalPK.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof JournalTotal)) {
      return false;
    }
    JournalTotal other = (JournalTotal) object;
    if ((this.journalTotalPK == null && other.journalTotalPK != null)
        || (this.journalTotalPK != null && !this.journalTotalPK.equals(other.journalTotalPK))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "ENTITY.JournalTotal[ journalTotalPK=" + journalTotalPK + " ]";
  }

}
