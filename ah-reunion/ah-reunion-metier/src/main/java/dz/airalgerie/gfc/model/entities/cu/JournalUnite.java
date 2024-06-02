/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.gfc.model.entities.cu;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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

/**
 *
 * @author Root
 */
@Entity
@Table(schema = "CU", name = "JOURNAL_UNITE")
@NamedQueries({@NamedQuery(name = "JournalUnite.findAll", query = "SELECT j FROM JournalUnite j"),
    @NamedQuery(name = "JournalUnite.findByCodeJournal",
        query = "SELECT j FROM JournalUnite j WHERE j.codeJournal = :codeJournal"),
    @NamedQuery(name = "JournalUnite.findByLibelle",
        query = "SELECT j FROM JournalUnite j WHERE j.libelle = :libelle")})
public class JournalUnite implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @NotNull
  @Column(name = "CODE_JOURNAL")
  private Integer codeJournal;
  @Size(max = 50)
  @Column(name = "LIBELLE")
  private String libelle;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "codeJournal", fetch = FetchType.LAZY)
  private List<JournalOd> journalOdList;

  public JournalUnite() {
  }

  public JournalUnite(Integer codeJournal) {
    this.codeJournal = codeJournal;
  }

  public JournalUnite(Integer codeJournal, String libelle) {
    this.codeJournal = codeJournal;
    this.libelle = libelle;
  }

  public Integer getCodeJournal() {
    return codeJournal;
  }

  public void setCodeJournal(Integer codeJournal) {
    this.codeJournal = codeJournal;
  }

  public String getLibelle() {
    return libelle;
  }

  public void setLibelle(String libelle) {
    this.libelle = libelle;
  }

  public List<JournalOd> getJournalOdList() {
    return journalOdList;
  }

  public void setJournalOdList(List<JournalOd> journalOdList) {
    this.journalOdList = journalOdList;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (codeJournal != null ? codeJournal.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof JournalUnite)) {
      return false;
    }
    JournalUnite other = (JournalUnite) object;
    if ((this.codeJournal == null && other.codeJournal != null)
        || (this.codeJournal != null && !this.codeJournal.equals(other.codeJournal))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "dz.airalgerie.gfc.model.entities.cu.JournalUnite[ codeJournal=" + codeJournal + " ]";
  }

}
