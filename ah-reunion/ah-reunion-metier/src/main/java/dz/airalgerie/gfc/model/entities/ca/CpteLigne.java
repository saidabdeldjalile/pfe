/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.gfc.model.entities.ca;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrateur
 */
@Entity
@Table(name = "CPTE_LIGNE", schema = "CA")
@XmlRootElement
@NamedQueries({@NamedQuery(name = "CpteLigne.findAll", query = "SELECT c FROM CpteLigne c"),
    @NamedQuery(name = "CpteLigne.findByNumLigne",
        query = "SELECT c FROM CpteLigne c WHERE c.cpteLignePK.numLigne = :numLigne"),
    @NamedQuery(name = "CpteLigne.findByRelation",
        query = "SELECT c FROM CpteLigne c WHERE c.cpteLignePK.relation = :relation"),
    @NamedQuery(name = "CpteLigne.findByCaeEsc",
        query = "SELECT c FROM CpteLigne c WHERE c.caeEsc = :caeEsc"),
    @NamedQuery(name = "CpteLigne.findByCaeLigne",
        query = "SELECT c FROM CpteLigne c WHERE c.caeLigne = :caeLigne"),
    @NamedQuery(name = "CpteLigne.findByEntree",
        query = "SELECT c FROM CpteLigne c WHERE c.entree = :entree"),
    @NamedQuery(name = "CpteLigne.findBySortie",
        query = "SELECT c FROM CpteLigne c WHERE c.sortie = :sortie"),
    @NamedQuery(name = "CpteLigne.findByDistance",
        query = "SELECT c FROM CpteLigne c WHERE c.distance = :distance")})
public class CpteLigne implements Serializable {

  @JoinColumn(name = "CODE_PRE", referencedColumnName = "CODE_PRE")
  @ManyToOne
  private Prestation codePre;
  @JoinColumn(name = "CODE_REL", referencedColumnName = "CODE_REL")
  @ManyToOne(optional = false)
  private CpteRelation codeRel;

  private static final long serialVersionUID = 1L;
  @EmbeddedId
  protected CpteLignePK cpteLignePK;
  @Size(max = 6)
  @Column(name = "CAE_ESC", length = 6)
  private String caeEsc;
  @Size(max = 6)
  @Column(name = "CAE_LIGNE", length = 6)
  private String caeLigne;
  @Column(name = "ENTREE")
  private Short entree;
  @Column(name = "SORTIE")
  private Short sortie;
  @Column(name = "DISTANCE")
  private Integer distance;

  public CpteLigne() {}

  public CpteLigne(CpteLignePK cpteLignePK) {
    this.cpteLignePK = cpteLignePK;
  }

  public CpteLigne(short numLigne, String relation) {
    this.cpteLignePK = new CpteLignePK(numLigne, relation);
  }

  public CpteLignePK getCpteLignePK() {
    if (cpteLignePK == null)
      cpteLignePK = new CpteLignePK();

    return cpteLignePK;
  }

  public void setCpteLignePK(CpteLignePK cpteLignePK) {

    this.cpteLignePK = cpteLignePK;
  }

  public String getCaeEsc() {
    return caeEsc;
  }

  public void setCaeEsc(String caeEsc) {
    this.caeEsc = caeEsc;
  }

  public String getCaeLigne() {
    return caeLigne;
  }

  public void setCaeLigne(String caeLigne) {
    this.caeLigne = caeLigne;
  }

  public Short getEntree() {
    return entree;
  }

  public void setEntree(Short entree) {
    this.entree = entree;
  }

  public Short getSortie() {
    return sortie;
  }

  public void setSortie(Short sortie) {
    this.sortie = sortie;
  }

  public Integer getDistance() {
    return distance;
  }

  public void setDistance(Integer distance) {
    this.distance = distance;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (cpteLignePK != null ? cpteLignePK.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof CpteLigne)) {
      return false;
    }
    CpteLigne other = (CpteLigne) object;
    if ((this.cpteLignePK == null && other.cpteLignePK != null)
        || (this.cpteLignePK != null && !this.cpteLignePK.equals(other.cpteLignePK))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "jpa.CpteLigne[ cpteLignePK=" + cpteLignePK + " ]";
  }

  public Prestation getCodePre() {
    if (codePre == null)
      codePre = new Prestation();
    return codePre;
  }

  public void setCodePre(Prestation codePre) {
    this.codePre = codePre;
  }

  public CpteRelation getCodeRel() {
    if (codeRel == null)
      codeRel = new CpteRelation();
    return codeRel;
  }

  public void setCodeRel(CpteRelation codeRel) {
    this.codeRel = codeRel;
  }

}
