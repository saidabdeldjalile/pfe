/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.grh.model.entities.rem;

import dz.airalgerie.commun.grh.utils.Utils;
import dz.airalgerie.grh.model.entities.commun.Personnel;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Nabila
 */
@Entity
@Table(name = "ELEMENT_PAIE_T", schema = Utils.dbSchema)

public class ElementPaie implements Serializable {

  private static final long serialVersionUID = 1L;
  @EmbeddedId
  protected ElementPaiePK elementPaiePK;
  @Column(name = "CODE_PAI")
  private String codePai;
  // @Max(value=?) @Min(value=?)//if you know range of your decimal fields consider using these
  // annotations to enforce field validation
  @Column(name = "DATE_STC")
  private int DateSTC;
  @Column(name = "ACT_M_C")
  private BigDecimal actMC;
  @Column(name = "ACT_M_1")
  private BigDecimal actM1;
  @Column(name = "ACT_M_2")
  private BigDecimal actM2;
  @Column(name = "DATE_SAI")
  @Temporal(TemporalType.TIMESTAMP)
  private Date dateSai;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)

  @JoinColumn(name = "MATRICULE", referencedColumnName = "MATRICULE", insertable = false,
      updatable = false)

  private Personnel personnel;

  @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "elementPaie")
  private List<Element> ElementList;

  @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "elementPaie")
  @OrderBy("codeRub ASC")
  private List<RubMensuel> RubMonList;

  public ElementPaie() {}

  public ElementPaie(ElementPaiePK elementPaiePK) {
    this.elementPaiePK = elementPaiePK;
  }

  public ElementPaie(Integer matricule, int dateTrt, int datePai) {
    this.elementPaiePK = new ElementPaiePK(matricule, dateTrt, datePai);
  }

  public ElementPaiePK getElementPaiePK() {
    return elementPaiePK;
  }

  public void setElementPaiePK(ElementPaiePK elementPaiePK) {
    this.elementPaiePK = elementPaiePK;
  }

  public String getCodePai() {
    return codePai;
  }

  public void setCodePai(String codePai) {
    this.codePai = codePai;
  }

  public BigDecimal getActMC() {
    return actMC;
  }

  public void setActMC(BigDecimal actMC) {
    this.actMC = actMC;
  }

  public BigDecimal getActM1() {
    return actM1;
  }

  public void setActM1(BigDecimal actM1) {
    this.actM1 = actM1;
  }

  public BigDecimal getActM2() {
    return actM2;
  }

  public void setActM2(BigDecimal actM2) {
    this.actM2 = actM2;
  }

  public Date getDateSai() {
    return dateSai;
  }

  public void setDateSai(Date dateSai) {
    this.dateSai = dateSai;
  }

  public int getDateSTC() {
    return DateSTC;
  }

  public void setDateSTC(int DateSTC) {
    this.DateSTC = DateSTC;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (elementPaiePK != null ? elementPaiePK.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof ElementPaie)) {
      return false;
    }
    ElementPaie other = (ElementPaie) object;
    if ((this.elementPaiePK == null && other.elementPaiePK != null)
        || (this.elementPaiePK != null && !this.elementPaiePK.equals(other.elementPaiePK))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "Entity.ElementPaie[ elementPaiePK=" + elementPaiePK + " ]";
  }

  public Personnel getPersonnel() {
    return personnel;
  }

  public void setPersonnel(Personnel personnel) {
    this.personnel = personnel;
  }

  public List<Element> getElementList() {
    return ElementList;
  }

  public void setElementList(List<Element> ElementList) {
    this.ElementList = ElementList;
  }

  public List<RubMensuel> getRubMonList() {
    return RubMonList;
  }

  public void setRubMonList(List<RubMensuel> RubMonList) {
    this.RubMonList = RubMonList;
  }

}
