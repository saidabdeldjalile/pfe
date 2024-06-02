/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.grh.model.entities.rem;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author kemikem
 */
@Entity
@Table(schema = "CAR", name = "COMPTE_BANCAIRE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CompteBancaire.findAll", query = "SELECT c FROM CompteBancaire c"),
    @NamedQuery(name = "CompteBancaire.findByMatricule",
        query = "SELECT c FROM CompteBancaire c WHERE c.compteBancairePK.matricule = :matricule"),
    @NamedQuery(name = "CompteBancaire.findByDateDeb",
        query = "SELECT c FROM CompteBancaire c WHERE c.compteBancairePK.dateDeb = :dateDeb"),
    @NamedQuery(name = "CompteBancaire.findByIsDevise",
        query = "SELECT c FROM CompteBancaire c WHERE c.compteBancairePK.isDevise = :isDevise"),
    @NamedQuery(name = "CompteBancaire.findByDateFin",
        query = "SELECT c FROM CompteBancaire c WHERE c.dateFin = :dateFin"),
    @NamedQuery(name = "CompteBancaire.findByNumCpt",
        query = "SELECT c FROM CompteBancaire c WHERE c.numCpt = :numCpt"),
    @NamedQuery(name = "CompteBancaire.findByCodeDevise",
        query = "SELECT c FROM CompteBancaire c WHERE c.codeDevise = :codeDevise"),
    @NamedQuery(name = "CompteBancaire.findByStatut",
        query = "SELECT c FROM CompteBancaire c WHERE c.statut = :statut")})
public class CompteBancaire implements Serializable {

  private static final long serialVersionUID = 1L;
  @EmbeddedId
  protected CompteBancairePK compteBancairePK;
  @Column(name = "DATE_FIN")
  @Temporal(TemporalType.DATE)
  private Date dateFin;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 200)
  @Column(name = "NUM_CPT")
  private String numCpt;
  @Column(name = "CODE_DEVISE")
  private Integer codeDevise;
  @Column(name = "STATUT")
  private Integer statut;
  @JoinColumn(name = "CODE_BANQUE", referencedColumnName = "CODE_BANQUE")
  @ManyToOne
  private Banque codeBanque;

  public CompteBancaire() {}

  public CompteBancaire(CompteBancairePK compteBancairePK) {
    this.compteBancairePK = compteBancairePK;
  }

  public CompteBancaire(CompteBancairePK compteBancairePK, String numCpt) {
    this.compteBancairePK = compteBancairePK;
    this.numCpt = numCpt;
  }

  public CompteBancaire(int matricule, Date dateDeb, boolean isDevise) {
    this.compteBancairePK = new CompteBancairePK(matricule, dateDeb, isDevise);
  }

  public CompteBancairePK getCompteBancairePK() {
    return compteBancairePK;
  }

  public void setCompteBancairePK(CompteBancairePK compteBancairePK) {
    this.compteBancairePK = compteBancairePK;
  }

  public Date getDateFin() {
    return dateFin;
  }

  public void setDateFin(Date dateFin) {
    this.dateFin = dateFin;
  }

  public String getNumCpt() {
    return numCpt;
  }

  public void setNumCpt(String numCpt) {
    this.numCpt = numCpt;
  }

  public Integer getCodeDevise() {
    return codeDevise;
  }

  public void setCodeDevise(Integer codeDevise) {
    this.codeDevise = codeDevise;
  }

  public Integer getStatut() {
    return statut;
  }

  public void setStatut(Integer statut) {
    this.statut = statut;
  }

  public Banque getCodeBanque() {
    return codeBanque;
  }

  public void setCodeBanque(Banque codeBanque) {
    this.codeBanque = codeBanque;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (compteBancairePK != null ? compteBancairePK.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof CompteBancaire)) {
      return false;
    }
    CompteBancaire other = (CompteBancaire) object;
    if ((this.compteBancairePK == null && other.compteBancairePK != null)
        || (this.compteBancairePK != null
            && !this.compteBancairePK.equals(other.compteBancairePK))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "ENTITY.SAISIE.CompteBancaire[ compteBancairePK=" + compteBancairePK + " ]";
  }

}
