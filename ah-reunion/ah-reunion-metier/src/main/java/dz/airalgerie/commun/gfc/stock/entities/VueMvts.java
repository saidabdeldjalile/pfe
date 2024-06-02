/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.commun.gfc.stock.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
 * @author user
 */
@Entity
@Table(name = "STK.V_MVTS")
@XmlRootElement
@NamedQueries({@NamedQuery(name = "VMvts.findAll", query = "SELECT v FROM VueMvts v"),
    @NamedQuery(name = "VMvts.findByTypeMVT",
        query = "SELECT v FROM VueMvts v WHERE v.typeMVT = :typeMVT"),
    @NamedQuery(name = "VMvts.findByNumBon",
        query = "SELECT v FROM VueMvts v WHERE v.numBon = :numBon"),
    @NamedQuery(name = "VMvts.findByPn", query = "SELECT v FROM VueMvts v WHERE v.pn = :pn"),
    @NamedQuery(name = "VMvts.findByCodeAppareil",
        query = "SELECT v FROM VueMvts v WHERE v.codeAppareil = :codeAppareil"),
    @NamedQuery(name = "VMvts.findByDateTrait",
        query = "SELECT v FROM VueMvts v WHERE v.dateTrait = :dateTrait"),
    @NamedQuery(name = "VMvts.findByQuantite",
        query = "SELECT v FROM VueMvts v WHERE v.quantite = :quantite"),
    @NamedQuery(name = "VMvts.findByValeur",
        query = "SELECT v FROM VueMvts v WHERE v.valeur = :valeur")})
public class VueMvts implements Serializable {

  private static final long serialVersionUID = 1L;
  @EmbeddedId
  private VueMvtsPK vueMvtsPK;
  @Column(name = "typeMVT")
  private Integer typeMVT;
  @Basic(optional = false)
  @NotNull
  @Size(max = 6)
  @Column(name = "numBon")
  private String numBon;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 25)
  @Column(name = "pn")
  private String pn;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 5)
  @Column(name = "codeAppareil")
  private String codeAppareil;
  @Basic(optional = false)
  @NotNull
  @Column(name = "dateTrait")
  private int dateTrait;
  // @Max(value=?) @Min(value=?)//if you know range of your decimal fields consider using these
  // annotations to enforce field validation
  @Basic(optional = false)
  @NotNull
  @Column(name = "quantite")
  private BigDecimal quantite;
  @Basic(optional = false)
  @NotNull
  @Column(name = "valeur")
  private BigDecimal valeur;
  @NotNull
  @Column(name = "dateMVT")
  @Temporal(TemporalType.DATE)
  private Date dateMVT;

  public VueMvts() {}

  public Integer getTypeMVT() {
    return typeMVT;
  }

  public void setTypeMVT(Integer typeMVT) {
    this.typeMVT = typeMVT;
  }

  public String getNumBon() {
    return numBon;
  }

  public void setNumBon(String numBon) {
    this.numBon = numBon;
  }

  public String getPn() {
    return pn;
  }

  public void setPn(String pn) {
    this.pn = pn;
  }

  public String getCodeAppareil() {
    return codeAppareil;
  }

  public void setCodeAppareil(String codeAppareil) {
    this.codeAppareil = codeAppareil;
  }

  public BigDecimal getQuantite() {
    return quantite;
  }

  public void setQuantite(BigDecimal quantite) {
    this.quantite = quantite;
  }

  public BigDecimal getValeur() {
    return valeur;
  }

  public void setValeur(BigDecimal valeur) {
    this.valeur = valeur;
  }

  public int getDateTrait() {
    return dateTrait;
  }

  public void setDateTrait(int dateTrait) {
    this.dateTrait = dateTrait;
  }

  public Date getDateMVT() {
    return dateMVT;
  }

  public void setDateMVT(Date dateMVT) {
    this.dateMVT = dateMVT;
  }

  public VueMvtsPK getVueMvtsPK() {
    return vueMvtsPK;
  }

  public void setVueMvtsPK(VueMvtsPK vueMvtsPK) {
    this.vueMvtsPK = vueMvtsPK;
  }

}
