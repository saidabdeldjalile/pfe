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
@Table(name = "STK.V_REC_SORT_MotAMASIS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VueRecSortMot.findAll", query = "SELECT v FROM VueRecSortMotAMASIS v"),
    @NamedQuery(name = "VueRecSortMot.findByCodeAppareil",
        query = "SELECT v FROM VueRecSortMotAMASIS v WHERE v.codeAppareil = :codeAppareil"),
    @NamedQuery(name = "VueRecSortMot.findByDateTraitSortie",
        query = "SELECT v FROM VueRecSortMotAMASIS v WHERE v.dateTraitSortie = :dateTraitSortie"),
    @NamedQuery(name = "VueRecSortMot.findByCompte",
        query = "SELECT v FROM VueRecSortMotAMASIS v WHERE v.compte = :compte"),
    @NamedQuery(name = "VueRecSortMot.findByApp",
        query = "SELECT v FROM VueRecSortMotAMASIS v WHERE v.app = :app"),
    @NamedQuery(name = "VueRecSortMot.findByTotalApp",
        query = "SELECT v FROM VueRecSortMotAMASIS v WHERE v.totalApp = :totalApp")})
public class VueRecSortMotAMASIS implements Serializable {
  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @NotNull
  @Size(max = 5)
  @Column(name = "codeAppareil")
  private String codeAppareil;
  @Column(name = "dateTraitSortie")
  private Integer dateTraitSortie;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 12)
  @Column(name = "compte")
  private String compte;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 11)
  @Column(name = "app")
  private String app;
  // @Max(value=?) @Min(value=?)//if you know range of your decimal fields consider using these
  // annotations to enforce field validation
  @Basic(optional = false)
  @NotNull
  @Column(name = "TotalApp")
  private BigDecimal totalApp;

  public VueRecSortMotAMASIS() {}

  public String getCodeAppareil() {
    return codeAppareil;
  }

  public void setCodeAppareil(String codeAppareil) {
    this.codeAppareil = codeAppareil;
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

  public String getApp() {
    return app;
  }

  public void setApp(String app) {
    this.app = app;
  }

  public BigDecimal getTotalApp() {
    return totalApp;
  }

  public void setTotalApp(BigDecimal totalApp) {
    this.totalApp = totalApp;
  }

}