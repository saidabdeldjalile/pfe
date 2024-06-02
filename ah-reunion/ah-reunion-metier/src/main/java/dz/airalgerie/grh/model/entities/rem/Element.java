/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.grh.model.entities.rem;

import dz.airalgerie.commun.grh.utils.Utils;
import dz.airalgerie.grh.model.dto.rem.PaieInfosReport;
import dz.airalgerie.grh.model.dto.rem.PaiePnReport;
import dz.airalgerie.grh.model.dto.rem.PaieReport;
import dz.airalgerie.grh.model.dto.rem.PaieRubsReport;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.SqlResultSetMappings;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Nabila
 */
@Entity
@Table(name = "ELEMENT_T", schema = Utils.dbSchema)
@SqlResultSetMappings({
    @SqlResultSetMapping(name = "PaieInfosReportMapping",
        classes = @ConstructorResult(targetClass = PaieInfosReport.class,
            columns = {@ColumnResult(name = "MATRICULE", type = int.class),
                @ColumnResult(name = "NOM", type = String.class),
                @ColumnResult(name = "DATE_PAI", type = int.class),
                @ColumnResult(name = "CODE_PAI", type = String.class),
                @ColumnResult(name = "GRP_CHAP", type = String.class),
                @ColumnResult(name = "CODE_TECH", type = String.class),
                @ColumnResult(name = "FONCTION", type = String.class),
                @ColumnResult(name = "NET_APAY", type = BigDecimal.class)})),
    @SqlResultSetMapping(name = "PaiePnReportMapping",
        classes = @ConstructorResult(targetClass = PaiePnReport.class,
            columns = {@ColumnResult(name = "MATRICULE", type = int.class),
                @ColumnResult(name = "NOM", type = String.class),
                @ColumnResult(name = "GRP_CHAP", type = String.class),
                @ColumnResult(name = "CODE_TECH", type = String.class),
                @ColumnResult(name = "DATE_PAIE", type = int.class),
                @ColumnResult(name = "PRESENCE", type = BigDecimal.class),
                @ColumnResult(name = "CONGE", type = BigDecimal.class),
                @ColumnResult(name = "CUMUL", type = BigDecimal.class),
                @ColumnResult(name = "HV_LIGNE", type = BigDecimal.class)})),
    @SqlResultSetMapping(name = "PaieReportMapping",
        classes = @ConstructorResult(targetClass = PaieReport.class,
            columns = {@ColumnResult(name = "MATRICULE", type = Integer.class),
                @ColumnResult(name = "NOM", type = String.class),
                @ColumnResult(name = "DATE_TRT", type = int.class),
                @ColumnResult(name = "GRP_CHAP", type = String.class),
                @ColumnResult(name = "NB", type = Integer.class)})),
    @SqlResultSetMapping(name = "PaieRubsReportMapping",
        classes = @ConstructorResult(targetClass = PaieRubsReport.class,
            columns = {@ColumnResult(name = "ID", type = int.class),
                @ColumnResult(name = "MATRICULE", type = int.class),
                @ColumnResult(name = "NOM", type = String.class),
                @ColumnResult(name = "DATE_PAI", type = int.class),
                @ColumnResult(name = "CODE_PAI", type = String.class),
                @ColumnResult(name = "GRP_CHAP", type = String.class),
                @ColumnResult(name = "CODE_TECH", type = String.class),
                @ColumnResult(name = "FONCTION", type = String.class),
                @ColumnResult(name = "CODE_RUB", type = String.class),
                @ColumnResult(name = "SENS", type = String.class),
                @ColumnResult(name = "VAL_UNITE", type = BigDecimal.class),
                @ColumnResult(name = "VAL_BASE", type = BigDecimal.class),
                @ColumnResult(name = "VAL_MONTANT", type = BigDecimal.class)})),
    @SqlResultSetMapping(name = "PaieRubsReportMappingDateTrt",
        classes = @ConstructorResult(targetClass = PaieRubsReport.class,
            columns = {@ColumnResult(name = "ID", type = int.class),
                @ColumnResult(name = "MATRICULE", type = int.class),
                @ColumnResult(name = "NOM", type = String.class),
                @ColumnResult(name = "DATE_TRT", type = int.class),
                @ColumnResult(name = "DATE_PAI", type = int.class),
                @ColumnResult(name = "CODE_PAI", type = String.class),
                @ColumnResult(name = "GRP_CHAP", type = String.class),
                @ColumnResult(name = "CODE_TECH", type = String.class),
                @ColumnResult(name = "FONCTION", type = String.class),
                @ColumnResult(name = "CODE_RUB", type = String.class),
                @ColumnResult(name = "SENS", type = String.class),
                @ColumnResult(name = "VAL_UNITE", type = BigDecimal.class),
                @ColumnResult(name = "VAL_BASE", type = BigDecimal.class),
                @ColumnResult(name = "VAL_MONTANT", type = BigDecimal.class)}))})
public class Element implements Serializable {

  private static final long serialVersionUID = 1L;
  @EmbeddedId
  protected ElementPK elementPK;
  // @Max(value=?) @Min(value=?)//if you know range of your decimal fields consider using these
  // annotations to enforce field validation
  @Basic(optional = false)
  @NotNull
  @Column(name = "VALEUR")
  private BigDecimal valeur;
  @JoinColumn(name = "CODE_ACT", referencedColumnName = "CODE_ACT", insertable = false,
      updatable = false)
  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  private Activite activite;
  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumns({
      @JoinColumn(name = "DATE_PAI", referencedColumnName = "DATE_PAI", insertable = false,
          updatable = false),
      @JoinColumn(name = "DATE_TRT", referencedColumnName = "DATE_TRT", insertable = false,
          updatable = false),
      @JoinColumn(name = "MATRICULE", referencedColumnName = "MATRICULE", insertable = false,
          updatable = false)})
  private ElementPaie elementPaie;

  public Element() {}

  public Element(ElementPK elementPK) {
    this.elementPK = elementPK;
  }

  public Element(ElementPK elementPK, BigDecimal valeur) {
    this.elementPK = elementPK;
    this.valeur = valeur;
  }

  public Element(Integer matricule, int dateTrt, int datePai, int codeAct) {
    this.elementPK = new ElementPK(matricule, dateTrt, datePai, codeAct);
  }

  public ElementPK getElementPK() {
    return elementPK;
  }

  public void setElementPK(ElementPK elementPK) {
    this.elementPK = elementPK;
  }

  public BigDecimal getValeur() {
    return valeur;
  }

  public void setValeur(BigDecimal valeur) {
    this.valeur = valeur;
  }

  public Activite getActivite() {
    return activite;
  }

  public void setActivite(Activite activite) {
    this.activite = activite;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (elementPK != null ? elementPK.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Element)) {
      return false;
    }
    Element other = (Element) object;
    if ((this.elementPK == null && other.elementPK != null)
        || (this.elementPK != null && !this.elementPK.equals(other.elementPK))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "Entity.Element[ elementPK=" + elementPK + " ]";
  }

  public ElementPaie getElementPaie() {
    return elementPaie;
  }

  public void setElementPaie(ElementPaie elementPaie) {
    this.elementPaie = elementPaie;
  }

}
