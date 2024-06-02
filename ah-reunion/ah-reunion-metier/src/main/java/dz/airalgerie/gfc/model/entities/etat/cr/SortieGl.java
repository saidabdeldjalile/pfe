/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.gfc.model.entities.etat.cr;

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
 * @author Administrateur
 */
@Entity
@Table(name = "CR.SORTIE_GL")
@XmlRootElement
@NamedQueries({@NamedQuery(name = "SortieGl.findAll", query = "SELECT s FROM SortieGl s"),
    @NamedQuery(name = "SortieGl.findById", query = "SELECT s FROM SortieGl s WHERE s.id = :id"),
    @NamedQuery(name = "SortieGl.findByAnnee",
        query = "SELECT s FROM SortieGl s WHERE s.annee = :annee"),
    @NamedQuery(name = "SortieGl.findByMois",
        query = "SELECT s FROM SortieGl s WHERE s.mois = :mois"),
    @NamedQuery(name = "SortieGl.findByNumJournal",
        query = "SELECT s FROM SortieGl s WHERE s.numJournal = :numJournal"),
    @NamedQuery(name = "SortieGl.findByNumCompte",
        query = "SELECT s FROM SortieGl s WHERE s.numCompte = :numCompte"),
    @NamedQuery(name = "SortieGl.findByLibelle",
        query = "SELECT s FROM SortieGl s WHERE s.libelle = :libelle"),
    @NamedQuery(name = "SortieGl.findByCodemonnaie",
        query = "SELECT s FROM SortieGl s WHERE s.codemonnaie = :codemonnaie"),
    @NamedQuery(name = "SortieGl.findByDebit",
        query = "SELECT s FROM SortieGl s WHERE s.debit = :debit"),
    @NamedQuery(name = "SortieGl.findByCredit",
        query = "SELECT s FROM SortieGl s WHERE s.credit = :credit"),
    @NamedQuery(name = "SortieGl.findByJv", query = "SELECT s FROM SortieGl s WHERE s.jv = :jv")})
public class SortieGl implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @NotNull
  @Column(name = "ID")
  private Integer id;
  // @Max(value=?) @Min(value=?)//if you know range of your decimal fields consider using these
  // annotations to enforce field validation
  @Column(name = "Annee")
  private Integer annee;
  @Column(name = "Mois")
  private String mois;
  @Column(name = "Num_Journal")
  private String numJournal;
  @Size(max = 255)
  @Column(name = "Num_Compte")
  private String numCompte;
  @Size(max = 255)
  @Column(name = "Libelle")
  private String libelle;
  @Column(name = "Code_monnaie")
  private String codemonnaie;
  @Column(name = "Debit")
  private BigDecimal debit;
  @Column(name = "Credit")
  private BigDecimal credit;
  @Size(max = 255)
  @Column(name = "JV")
  private String jv;

  public SortieGl() {}

  public SortieGl(Integer id) {
    this.id = id;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getAnnee() {
    return annee;
  }

  public void setAnnee(Integer annee) {
    this.annee = annee;
  }

  public String getMois() {
    return mois;
  }

  public void setMois(String mois) {
    this.mois = mois;
  }

  public String getNumJournal() {
    return numJournal;
  }

  public void setNumJournal(String numJournal) {
    this.numJournal = numJournal;
  }

  public String getNumCompte() {
    return numCompte;
  }

  public void setNumCompte(String numCompte) {
    this.numCompte = numCompte;
  }

  public String getLibelle() {
    return libelle;
  }

  public void setLibelle(String libelle) {
    this.libelle = libelle;
  }

  public String getCodemonnaie() {
    return codemonnaie;
  }

  public void setCodemonnaie(String codemonnaie) {
    this.codemonnaie = codemonnaie;
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

  public String getJv() {
    return jv;
  }

  public void setJv(String jv) {
    this.jv = jv;
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
    if (!(object instanceof SortieGl)) {
      return false;
    }
    SortieGl other = (SortieGl) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "ENTITY.SortieGl[ id=" + id + " ]";
  }

}
