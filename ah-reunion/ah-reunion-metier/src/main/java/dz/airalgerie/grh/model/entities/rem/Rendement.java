/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.grh.model.entities.rem;

import dz.airalgerie.commun.grh.utils.Utils;
import dz.airalgerie.commun.model.entities.commun.DirectionGrh;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Nabila
 */
@Entity
@Table(name = "RENDEMENT_T", schema = Utils.dbSchema)
@XmlRootElement
@NamedQueries({@NamedQuery(name = "Rendement.findAll", query = "SELECT r FROM Rendement r")})
public class Rendement implements Serializable {

  private static final long serialVersionUID = 1L;
  @EmbeddedId
  protected RendementPK rendementPK;
  // @Max(value=?) @Min(value=?)//if you know range of your decimal fields consider using these
  // annotations to enforce field validation
  @Column(name = "PRIM_EFFORT")
  private BigDecimal primEffort;
  @Size(max = 50)
  @Column(name = "CPT_ANAL")
  private String cptAnal;
  @Column(name = "APREC_GLE")
  private BigDecimal aprecGle;
  @Column(name = "MONTANT_PR")
  private BigDecimal montantPr;
  @Column(name = "TX_PNDR")
  private Double txPndr;
  @Column(name = "MOYE_PR")
  private BigDecimal moyePr;

  @JoinColumn(name = "CODE_DIR")
  @ManyToOne(fetch = FetchType.LAZY)
  @MapsId("codeDir")
  private DirectionGrh direction;

  public Rendement() {}

  public Rendement(RendementPK rendementPK) {
    this.rendementPK = rendementPK;
  }

  public Rendement(String codeDir, int dateTrt) {
    this.rendementPK = new RendementPK(codeDir, dateTrt);
  }

  public RendementPK getRendementPK() {
    return rendementPK;
  }

  public void setRendementPK(RendementPK rendementPK) {
    this.rendementPK = rendementPK;
  }

  public BigDecimal getPrimEffort() {
    return primEffort;
  }

  public void setPrimEffort(BigDecimal primEffort) {
    this.primEffort = primEffort;
  }

  public String getCptAnal() {
    return cptAnal;
  }

  public void setCptAnal(String cptAnal) {
    this.cptAnal = cptAnal;
  }

  public BigDecimal getAprecGle() {
    return aprecGle;
  }

  public void setAprecGle(BigDecimal aprecGle) {
    this.aprecGle = aprecGle;
  }

  public BigDecimal getMontantPr() {
    return montantPr;
  }

  public void setMontantPr(BigDecimal montantPr) {
    this.montantPr = montantPr;
  }

  public Double getTxPndr() {
    return txPndr;
  }

  public void setTxPndr(Double txPndr) {
    this.txPndr = txPndr;
  }

  public BigDecimal getMoyePr() {
    return moyePr;
  }

  public void setMoyePr(BigDecimal moyePr) {
    this.moyePr = moyePr;
  }

  public DirectionGrh getDirection() {
    return direction;
  }

  public void setDirection(DirectionGrh direction) {
    this.direction = direction;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (rendementPK != null ? rendementPK.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Rendement)) {
      return false;
    }
    Rendement other = (Rendement) object;
    if ((this.rendementPK == null && other.rendementPK != null)
        || (this.rendementPK != null && !this.rendementPK.equals(other.rendementPK))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "Entity.Rendement[ rendementPK=" + rendementPK + " ]";
  }

}
