/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.grh.model.entities.rem;

import dz.airalgerie.commun.grh.utils.Utils;
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
 * @author Nabila
 */
@Entity
@Table(name = "CONSTANTE", schema = Utils.dbSchema)

public class Constante implements Serializable {

  private static final long serialVersionUID = 1L;
  @EmbeddedId
  protected ConstantePK constantePK;
  // @Max(value=?) @Min(value=?)//if you know range of your decimal fields consider using these
  // annotations to enforce field validation
  @Column(name = "VAL_NUM")
  private BigDecimal valNum;
  @Column(name = "VAL_TAUX")
  private BigDecimal valTaux;
  @Size(max = 50)
  @Column(name = "VAL_ALPH")
  private String valAlph;
  @JoinColumn(name = "CODE_RUB", referencedColumnName = "CODE_RUB", insertable = false,
      updatable = false)
  @ManyToOne(optional = false, fetch = FetchType.LAZY)
  private Rubrique rubrique;

  public Constante() {}

  public Constante(ConstantePK constantePK) {
    this.constantePK = constantePK;
  }

  public Constante(String codeRub, int codeVal, int dateDeb, int dateFin) {
    this.constantePK = new ConstantePK(codeRub, codeVal, dateDeb, dateFin);
  }

  public ConstantePK getConstantePK() {

    return constantePK;
  }

  public void setConstantePK(ConstantePK constantePK) {
    this.constantePK = constantePK;
  }

  public BigDecimal getValNum() {
    return valNum;
  }

  public void setValNum(BigDecimal valNum) {
    this.valNum = valNum;
  }

  public BigDecimal getValTaux() {
    return valTaux;
  }

  public void setValTaux(BigDecimal valTaux) {
    this.valTaux = valTaux;
  }

  public String getValAlph() {
    return valAlph;
  }

  public void setValAlph(String valAlph) {
    this.valAlph = valAlph;
  }

  public Rubrique getRubrique() {
    return rubrique;
  }

  public void setRubrique(Rubrique rubrique) {
    this.rubrique = rubrique;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (constantePK != null ? constantePK.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Constante)) {
      return false;
    }
    Constante other = (Constante) object;
    if ((this.constantePK == null && other.constantePK != null)
        || (this.constantePK != null && !this.constantePK.equals(other.constantePK))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "Entity.Constante[ constantePK=" + constantePK + " ]";
  }

}
