/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.gfc.model.entities.commun;

import java.io.Serializable;
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
@Table(name = "JOURNAL_AH", schema = "CG")
@XmlRootElement
@NamedQueries({@NamedQuery(name = "JournalAh.findAll", query = "SELECT j FROM JournalAh j"),
    @NamedQuery(name = "JournalAh.findByNumJournal",
        query = "SELECT j FROM JournalAh j WHERE j.numJournal = :numJournal"),
    @NamedQuery(name = "JournalAh.findByLibelle",
        query = "SELECT j FROM JournalAh j WHERE j.libelle = :libelle")})
public class JournalAh implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 2)
  @Column(name = "NUM_JOURNAL")
  private String numJournal;
  @Size(max = 100)
  @Column(name = "LIBELLE")
  private String libelle;

  public JournalAh() {}

  public JournalAh(String numJournal) {
    this.numJournal = numJournal;
  }

  public String getNumJournal() {
    return numJournal;
  }

  public void setNumJournal(String numJournal) {
    this.numJournal = numJournal;
  }

  public String getLibelle() {
    return libelle;
  }

  public void setLibelle(String libelle) {
    this.libelle = libelle;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (numJournal != null ? numJournal.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    if (!(object instanceof JournalAh)) {
      return false;
    }
    JournalAh other = (JournalAh) object;
    if ((this.numJournal == null && other.numJournal != null)
        || (this.numJournal != null && !this.numJournal.equals(other.numJournal))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "dz.airalgerie.scf.bean.journal.JournalAh[ numJournal=" + numJournal + " ]";
  }

}
