/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.grh.model.entities.rem;

import dz.airalgerie.commun.grh.utils.Utils;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Nabila
 */
@Entity
@Table(name = "RUB_MENSUEL_T", schema = Utils.dbSchema)
public class RubMensuel implements Comparable<RubMensuel>, Serializable {

  private static final long serialVersionUID = 1L;
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  @Basic(optional = false)
  @NotNull
  @Column(name = "ID_RMENS")
  private Integer idRmens;
  @Basic(optional = false)
  @NotNull
  @Column(name = "MATRICULE")
  private Integer matricule;
  @Basic(optional = false)
  @NotNull
  @Column(name = "DATE_TRT")
  private int dateTrt;
  @Basic(optional = false)
  @NotNull
  @Column(name = "DATE_PAI")
  private int datePai;
  @JoinColumn(name = "CODE_RUB", referencedColumnName = "CODE_RUB")
  @ManyToOne(optional = false, fetch = FetchType.LAZY)
  private Rubrique codeRub;
  @Column(name = "SENS")
  private Character sens;
  @Column(name = "TYP_ENRG")
  private Integer typEnrg;
  // @Max(value=?) @Min(value=?)//if you know range of your decimal fields consider using these
  // annotations to enforce field validation
  @Column(name = "VAL_UNITE")
  private BigDecimal valUnite;
  @Column(name = "VAL_BASE")
  private BigDecimal valBase;
  @Column(name = "VAL_MONTANT")
  private BigDecimal valMontant;
  @Column(name = "DATE_SAI")
  @Temporal(TemporalType.TIMESTAMP)
  private Date dateSai;
  @Column(name = "IS_SAISIE")
  private boolean isSaisie;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumns({
      @JoinColumn(name = "DATE_PAI", referencedColumnName = "DATE_PAI", insertable = false,
          updatable = false),
      @JoinColumn(name = "DATE_TRT", referencedColumnName = "DATE_TRT", insertable = false,
          updatable = false),
      @JoinColumn(name = "MATRICULE", referencedColumnName = "MATRICULE", insertable = false,
          updatable = false)})

  private ElementPaie elementPaie;

  public RubMensuel() {}

  public RubMensuel(Integer idRmens) {
    this.idRmens = idRmens;
  }

  public RubMensuel(Integer matricule, int dateTrt, int datePai) {
    this.matricule = matricule;
    this.dateTrt = dateTrt;
    this.datePai = datePai;
  }

  public RubMensuel(Integer idRmens, Integer matricule, int dateTrt, int datePai) {
    this.idRmens = idRmens;
    this.matricule = matricule;
    this.dateTrt = dateTrt;
    this.datePai = datePai;
  }

  public RubMensuel(Integer matricule, int dateTrt, int datePai, Character sens, Integer typEnrg,
      BigDecimal valUnite, BigDecimal valBase, BigDecimal valMontant) {
    this.matricule = matricule;
    this.dateTrt = dateTrt;
    this.datePai = datePai;
    this.sens = sens;
    this.typEnrg = typEnrg;
    this.valUnite = valUnite;
    this.valBase = valBase;
    this.valMontant = valMontant;
  }

  // public RubMensuel(int matricule, int dateTrt, int datePai) {
  // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated
  // methods, choose Tools | Templates.
  // }
  public Integer getIdRmens() {
    return idRmens;
  }

  public void setIdRmens(Integer idRmens) {
    this.idRmens = idRmens;
  }

  public Integer getMatricule() {
    return matricule;
  }

  public void setMatricule(Integer matricule) {
    this.matricule = matricule;
  }

  public int getDateTrt() {
    return dateTrt;
  }

  public void setDateTrt(int dateTrt) {
    this.dateTrt = dateTrt;
  }

  public int getDatePai() {
    return datePai;
  }

  public void setDatePai(int datePai) {
    this.datePai = datePai;
  }

  public Character getSens() {
    return sens;
  }

  public void setSens(Character sens) {
    this.sens = sens;
  }

  public Integer getTypEnrg() {
    return typEnrg;
  }

  public void setTypEnrg(Integer typEnrg) {
    this.typEnrg = typEnrg;
  }

  public BigDecimal getValUnite() {
    return valUnite;
  }

  public void setValUnite(BigDecimal valUnite) {
    this.valUnite = valUnite;
  }

  public BigDecimal getValBase() {
    return valBase;
  }

  public void setValBase(BigDecimal valBase) {
    this.valBase = valBase;
  }

  public BigDecimal getValMontant() {
    return valMontant;
  }

  public void setValMontant(BigDecimal valMontant) {
    this.valMontant = valMontant;
  }

  public Date getDateSai() {
    return dateSai;
  }

  public void setDateSai(Date dateSai) {
    this.dateSai = dateSai;
  }

  public Rubrique getCodeRub() {
    if (codeRub == null) {
      codeRub = new Rubrique();
    }
    return codeRub;
  }

  public void setCodeRub(Rubrique codeRub) {
    this.codeRub = codeRub;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (idRmens != null ? idRmens.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof RubMensuel)) {
      return false;
    }
    RubMensuel other = (RubMensuel) object;
    if ((this.idRmens == null && other.idRmens != null)
        || (this.idRmens != null && !this.idRmens.equals(other.idRmens))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "Entity.RubMensuel[ idRmens=" + idRmens + " ]";
  }

  public ElementPaie getElementPaie() {
    return elementPaie;
  }

  public void setElementPaie(ElementPaie elementPaie) {
    this.elementPaie = elementPaie;
  }

  public boolean isIsSaisie() {
    return isSaisie;
  }

  public void setIsSaisie(boolean isSaisie) {
    this.isSaisie = isSaisie;
  }

  @Override
  public int compareTo(RubMensuel o) {
    return this.getCodeRub().getCodeRub().compareTo(o.getCodeRub().getCodeRub());
  }

  @Override
  public RubMensuel clone() throws CloneNotSupportedException {
    return (RubMensuel) super.clone(); // To change body of generated methods, choose Tools |
                                       // Templates.
  }

}
