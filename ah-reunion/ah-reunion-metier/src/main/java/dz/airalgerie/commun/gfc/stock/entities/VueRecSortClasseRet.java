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
@Table(name = "STK.V_REC_SORT_CLASSE_RET")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VRecSortClasseRet.findAll", query = "SELECT v FROM VueRecSortClasseRet v"),
    @NamedQuery(name = "VRecSortClasseRet.findByClasse",
        query = "SELECT v FROM VueRecSortClasseRet v WHERE v.classe = :classe"),
    @NamedQuery(name = "VRecSortClasseRet.findByDateTraitSortie",
        query = "SELECT v FROM VueRecSortClasseRet v WHERE v.dateTraitSortie = :dateTraitSortie"),
    @NamedQuery(name = "VRecSortClasseRet.findByCompte",
        query = "SELECT v FROM VueRecSortClasseRet v WHERE v.compte = :compte"),
    @NamedQuery(name = "VRecSortClasseRet.findByCommun",
        query = "SELECT v FROM VueRecSortClasseRet v WHERE v.commun = :commun"),
    @NamedQuery(name = "VRecSortClasseRet.findByB727",
        query = "SELECT v FROM VueRecSortClasseRet v WHERE v.b727 = :b727"),
    @NamedQuery(name = "VRecSortClasseRet.findByB737",
        query = "SELECT v FROM VueRecSortClasseRet v WHERE v.b737 = :b737"),
    @NamedQuery(name = "VRecSortClasseRet.findByA310",
        query = "SELECT v FROM VueRecSortClasseRet v WHERE v.a310 = :a310"),
    @NamedQuery(name = "VRecSortClasseRet.findByTotalCls",
        query = "SELECT v FROM VueRecSortClasseRet v WHERE v.totalCls = :totalCls")})
public class VueRecSortClasseRet implements Serializable {
  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @NotNull
  @Size(max = 1)
  @Column(name = "classe")
  private String classe;
  @Column(name = "dateTraitSortie")
  private Integer dateTraitSortie;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 12)
  @Column(name = "compte")
  private String compte;
  // @Max(value=?) @Min(value=?)//if you know range of your decimal fields consider using these
  // annotations to enforce field validation
  @Basic(optional = false)
  @NotNull
  @Column(name = "Commun")
  private BigDecimal commun;
  @Basic(optional = false)
  @NotNull
  @Column(name = "B727")
  private BigDecimal b727;
  @Basic(optional = false)
  @NotNull
  @Column(name = "B737")
  private BigDecimal b737;
  @Basic(optional = false)
  @NotNull
  @Column(name = "A310")
  private BigDecimal a310;
  @Basic(optional = false)
  @NotNull
  @Column(name = "TotalCls")
  private BigDecimal totalCls;

  public VueRecSortClasseRet() {}

  public String getClasse() {
    return classe;
  }

  public void setClasse(String classe) {
    this.classe = classe;
  }

  public Integer getDateTraitSortie() {
    return dateTraitSortie;
  }

  public void setDateTraitSortie(Integer dateTraitSortie) {
    this.dateTraitSortie = dateTraitSortie;
  }

  public String getCompte() {
    return compte;
  }

  public void setCompte(String compte) {
    this.compte = compte;
  }

  public BigDecimal getCommun() {
    return commun;
  }

  public void setCommun(BigDecimal commun) {
    this.commun = commun;
  }

  public BigDecimal getB727() {
    return b727;
  }

  public void setB727(BigDecimal b727) {
    this.b727 = b727;
  }

  public BigDecimal getB737() {
    return b737;
  }

  public void setB737(BigDecimal b737) {
    this.b737 = b737;
  }

  public BigDecimal getA310() {
    return a310;
  }

  public void setA310(BigDecimal a310) {
    this.a310 = a310;
  }

  public BigDecimal getTotalCls() {
    return totalCls;
  }

  public void setTotalCls(BigDecimal totalCls) {
    this.totalCls = totalCls;
  }

}
