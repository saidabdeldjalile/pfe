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
@Table(name = "STK.V_REC_SORT_CLASSE_ACT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VRecSortClasseAct.findAll", query = "SELECT v FROM VueRecSortClasseAct v"),
    @NamedQuery(name = "VRecSortClasseAct.findByClasse",
        query = "SELECT v FROM VueRecSortClasseAct v WHERE v.classe = :classe"),
    @NamedQuery(name = "VRecSortClasseAct.findByDateTraitSortie",
        query = "SELECT v FROM VueRecSortClasseAct v WHERE v.dateTraitSortie = :dateTraitSortie"),
    @NamedQuery(name = "VRecSortClasseAct.findByCompte",
        query = "SELECT v FROM VueRecSortClasseAct v WHERE v.compte = :compte"),
    @NamedQuery(name = "VRecSortClasseAct.findByB767",
        query = "SELECT v FROM VueRecSortClasseAct v WHERE v.b767 = :b767"),
    @NamedQuery(name = "VRecSortClasseAct.findByNg",
        query = "SELECT v FROM VueRecSortClasseAct v WHERE v.ng = :ng"),
    @NamedQuery(name = "VRecSortClasseAct.findByNoae",
        query = "SELECT v FROM VueRecSortClasseAct v WHERE v.noae = :noae"),
    @NamedQuery(name = "VRecSortClasseAct.findByTotalCls",
        query = "SELECT v FROM VueRecSortClasseAct v WHERE v.totalCls = :totalCls")})
public class VueRecSortClasseAct implements Serializable {
  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @NotNull
  @Size(max = 1)
  @Column(name = "classe")
  private String classe;
  @Column(name = "dateTraitSortie")
  private Integer dateTraitSortie;
  @Size(max = 12)
  @Column(name = "compte")
  private String compte;
  // @Max(value=?) @Min(value=?)//if you know range of your decimal fields consider using these
  // annotations to enforce field validation
  @Basic(optional = false)
  @NotNull
  @Column(name = "B767")
  private BigDecimal b767;
  @Basic(optional = false)
  @NotNull
  @Column(name = "NG")
  private BigDecimal ng;
  @Basic(optional = false)
  @NotNull
  @Column(name = "NOAE")
  private BigDecimal noae;
  @Basic(optional = false)
  @NotNull
  @Column(name = "TotalCls")
  private BigDecimal totalCls;

  public VueRecSortClasseAct() {}

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

  public BigDecimal getB767() {
    return b767;
  }

  public void setB767(BigDecimal b767) {
    this.b767 = b767;
  }

  public BigDecimal getNg() {
    return ng;
  }

  public void setNg(BigDecimal ng) {
    this.ng = ng;
  }

  public BigDecimal getNoae() {
    return noae;
  }

  public void setNoae(BigDecimal noae) {
    this.noae = noae;
  }

  public BigDecimal getTotalCls() {
    return totalCls;
  }

  public void setTotalCls(BigDecimal totalCls) {
    this.totalCls = totalCls;
  }

}
