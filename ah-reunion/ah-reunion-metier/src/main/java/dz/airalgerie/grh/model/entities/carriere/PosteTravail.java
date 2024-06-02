/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.grh.model.entities.carriere;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Diaf
 */
@Entity
@Table(schema = "CAR", name = "POSTE_TRAVAIL")
public class PosteTravail implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @NotNull
  @Column(name = "CODE_PSTR")
  private Integer codePstr;
  @NotNull
  @Column(name = "REF_PSTR")
  private Integer refPstr;
  @Size(max = 150)
  @Column(name = "LIBELLE")
  private String libelle;
  @Size(max = 10)
  @Column(name = "DATE_VAL")
  private String dateVal;
  @Column(name = "CODE_SFL")
  private String codeSfl;
  @Column(name = "NBR_EXPR")
  private Integer nbrExpr;

  @Column(name = "CODE_FIL")
  private String codeFil;

  @OneToMany(mappedBy = "posteTravail", fetch = FetchType.LAZY)
  private List<Carriere> carriereList;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "posteTravail", fetch = FetchType.LAZY)
  private List<Antecedent> antecedentList;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "posteTravail", fetch = FetchType.LAZY)
  private List<PosteTrvDet> posteTrvDetList;

  public PosteTravail() {}

  public PosteTravail(Integer codePstr) {
    this.codePstr = codePstr;
  }

  public Integer getCodePstr() {
    return codePstr;
  }

  public void setCodePstr(Integer codePstr) {
    this.codePstr = codePstr;
  }

  public Integer getRefPstr() {
    return refPstr;
  }

  public void setRefPstr(Integer refPstr) {
    this.refPstr = refPstr;
  }

  public String getLibelle() {
    return libelle;
  }

  public void setLibelle(String libelle) {
    this.libelle = libelle;
  }

  public String getDateVal() {
    return dateVal;
  }

  public void setDateVal(String dateVal) {
    this.dateVal = dateVal;
  }

  public String getCodeSfl() {
    return codeSfl;
  }

  public void setCodeSfl(String codeSfl) {
    this.codeSfl = codeSfl;
  }

  public Integer getNbrExpr() {
    return nbrExpr;
  }

  public void setNbrExpr(Integer nbrExpr) {
    this.nbrExpr = nbrExpr;
  }

  public String getCodeFil() {
    return codeFil;
  }

  public void setCodeFil(String codeFil) {
    this.codeFil = codeFil;
  }

  @XmlTransient
  public List<Carriere> getCarriereList() {
    return carriereList;
  }

  public void setCarriereList(List<Carriere> carriereList) {
    this.carriereList = carriereList;
  }

  @XmlTransient
  public List<Antecedent> getAntecedentList() {
    return antecedentList;
  }

  public void setAntecedentList(List<Antecedent> antecedentList) {
    this.antecedentList = antecedentList;
  }

  @XmlTransient
  public List<PosteTrvDet> getPosteTrvDetList() {
    return posteTrvDetList;
  }

  public void setPosteTrvDetList(List<PosteTrvDet> posteTrvDetList) {
    this.posteTrvDetList = posteTrvDetList;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (codePstr != null ? codePstr.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof PosteTravail)) {
      return false;
    }
    PosteTravail other = (PosteTravail) object;
    if ((this.codePstr == null && other.codePstr != null)
        || (this.codePstr != null && !this.codePstr.equals(other.codePstr))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "PosteDeTravail[ " + codePstr + ", " + libelle + " ]";
  }

}
