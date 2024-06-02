/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.grh.model.entities.carriere;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author Diaf
 */
@Entity
@Table(schema = "CAR", name = "POSTE_TRV_DET")
public class PosteTrvDet implements Serializable {

  private static final long serialVersionUID = 1L;
  @EmbeddedId
  protected PosteTrvDetPK posteTrvDetPK;
  // @Max(value=?) @Min(value=?)//if you know range of your decimal fields consider using these
  // annotations to enforce field validation
  @Column(name = "SALAIRE_BASE")
  private BigDecimal salaireBase;
  @Column(name = "INDI_SALAIRE")
  private Integer indiSalaire;
  @Size(max = 10)
  @Column(name = "DATE_FIN")
  private String dateFin;
  @JoinColumn(name = "CODE_SEC", referencedColumnName = "CODE_SEC")
  @ManyToOne(fetch = FetchType.LAZY)
  private Section section;
  @JoinColumn(name = "CODE_PSTR", referencedColumnName = "CODE_PSTR", insertable = false,
      updatable = false)
  @ManyToOne(optional = false, fetch = FetchType.LAZY)
  private PosteTravail posteTravail;
  @JoinColumn(name = "CODE_CORPS", referencedColumnName = "CODE_CORPS")
  @ManyToOne(fetch = FetchType.LAZY)
  private Corps corps;
  @JoinColumn(name = "CODE_CATG", referencedColumnName = "CODE_CATG")
  @ManyToOne(fetch = FetchType.LAZY)
  private Categorie categorie;

  public PosteTrvDet() {}

  public PosteTrvDet(PosteTrvDetPK posteTrvDetPK) {
    this.posteTrvDetPK = posteTrvDetPK;
  }

  public PosteTrvDet(int codePstr, String dateDeb) {
    this.posteTrvDetPK = new PosteTrvDetPK(codePstr, dateDeb);
  }

  public PosteTrvDetPK getPosteTrvDetPK() {
    return posteTrvDetPK;
  }

  public void setPosteTrvDetPK(PosteTrvDetPK posteTrvDetPK) {
    this.posteTrvDetPK = posteTrvDetPK;
  }

  public BigDecimal getSalaireBase() {
    return salaireBase;
  }

  public void setSalaireBase(BigDecimal salaireBase) {
    this.salaireBase = salaireBase;
  }

  public Integer getIndiSalaire() {
    return indiSalaire;
  }

  public void setIndiSalaire(Integer indiSalaire) {
    this.indiSalaire = indiSalaire;
  }

  public String getDateFin() {
    return dateFin;
  }

  public void setDateFin(String dateFin) {
    this.dateFin = dateFin;
  }

  public Section getSection() {
    return section;
  }

  public void setSection(Section section) {
    this.section = section;
  }

  public PosteTravail getPosteTravail() {
    return posteTravail;
  }

  public void setPosteTravail(PosteTravail posteTravail) {
    this.posteTravail = posteTravail;
  }

  public Corps getCorps() {
    return corps;
  }

  public void setCorps(Corps corps) {
    this.corps = corps;
  }

  public Categorie getCategorie() {
    return categorie;
  }

  public void setCategorie(Categorie categorie) {
    this.categorie = categorie;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (posteTrvDetPK != null ? posteTrvDetPK.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof PosteTrvDet)) {
      return false;
    }
    PosteTrvDet other = (PosteTrvDet) object;
    if ((this.posteTrvDetPK == null && other.posteTrvDetPK != null)
        || (this.posteTrvDetPK != null && !this.posteTrvDetPK.equals(other.posteTrvDetPK))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "FRM.PosteTrvDet[ posteTrvDetPK=" + posteTrvDetPK + " ]";
  }

}
