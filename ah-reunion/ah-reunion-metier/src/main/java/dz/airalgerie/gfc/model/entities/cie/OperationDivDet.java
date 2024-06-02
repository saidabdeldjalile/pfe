/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.gfc.model.entities.cie;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrateur
 */
@Entity
@Table(name = "OPERATION_DIV_DET", catalog = "CPTA", schema = "CE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OperationDivDet.findAll", query = "SELECT o FROM OperationDivDet o"),
    @NamedQuery(name = "OperationDivDet.findByNumLign",
        query = "SELECT o FROM OperationDivDet o WHERE o.operationDivDetPK.numLign = :numLign"),
    @NamedQuery(name = "OperationDivDet.findByDateCpta",
        query = "SELECT o FROM OperationDivDet o WHERE o.operationDivDetPK.dateCpta = :dateCpta"),
    @NamedQuery(name = "OperationDivDet.findByGrpChap",
        query = "SELECT o FROM OperationDivDet o WHERE o.operationDivDetPK.grpChap = :grpChap"),
    @NamedQuery(name = "OperationDivDet.findByCpteImp",
        query = "SELECT o FROM OperationDivDet o WHERE o.cpteImp = :cpteImp"),
    @NamedQuery(name = "OperationDivDet.findByLibImp",
        query = "SELECT o FROM OperationDivDet o WHERE o.libImp = :libImp"),
    @NamedQuery(name = "OperationDivDet.findByCodeMon",
        query = "SELECT o FROM OperationDivDet o WHERE o.codeMon = :codeMon"),
    @NamedQuery(name = "OperationDivDet.findByMntImp",
        query = "SELECT o FROM OperationDivDet o WHERE o.mntImp = :mntImp"),
    @NamedQuery(name = "OperationDivDet.findByCodeImp",
        query = "SELECT o FROM OperationDivDet o WHERE o.codeImp = :codeImp")})
public class OperationDivDet implements Serializable {

  private static final long serialVersionUID = 1L;
  @EmbeddedId
  protected OperationDivDetPK operationDivDetPK;
  @Size(max = 12)
  @Column(name = "CPTE_IMP", length = 12)
  private String cpteImp;
  @Size(max = 30)
  @Column(name = "LIB_IMP", length = 30)
  private String libImp;
  @Size(max = 3)
  @Column(name = "CODE_MON", length = 3)
  private String codeMon;
  // @Max(value=?) @Min(value=?)//if you know range of your decimal fields consider using these
  // annotations to enforce field validation
  @Column(name = "MNT_IMP", precision = 12, scale = 3)
  private BigDecimal mntImp;
  @Size(max = 1)
  @Column(name = "CODE_IMP", length = 1)
  private String codeImp;
  @JoinColumns({
      @JoinColumn(name = "DATE_CPTA", referencedColumnName = "DATE_CPTA", nullable = false,
          insertable = false, updatable = false),
      @JoinColumn(name = "GRP_CHAP", referencedColumnName = "GRP_CHAP", nullable = false,
          insertable = false, updatable = false)})
  @ManyToOne(optional = false)
  private OperationDiv operationDiv;

  public OperationDivDet() {}

  public OperationDivDet(OperationDivDetPK operationDivDetPK) {
    this.operationDivDetPK = operationDivDetPK;
  }

  public OperationDivDet(int numLign, int dateCpta, String grpChap) {
    this.operationDivDetPK = new OperationDivDetPK(numLign, dateCpta, grpChap);
  }

  public OperationDivDetPK getOperationDivDetPK() {
    if (operationDivDetPK == null)
      operationDivDetPK = new OperationDivDetPK();
    return operationDivDetPK;
  }

  public void setOperationDivDetPK(OperationDivDetPK operationDivDetPK) {
    this.operationDivDetPK = operationDivDetPK;
  }

  public String getCpteImp() {
    return cpteImp;
  }

  public void setCpteImp(String cpteImp) {
    this.cpteImp = cpteImp;
  }

  public String getLibImp() {
    return libImp;
  }

  public void setLibImp(String libImp) {
    this.libImp = libImp;
  }

  public String getCodeMon() {

    return codeMon;
  }

  public void setCodeMon(String codeMon) {
    this.codeMon = codeMon;
  }

  public BigDecimal getMntImp() {
    return mntImp;
  }

  public void setMntImp(BigDecimal mntImp) {
    this.mntImp = mntImp;
  }

  public String getCodeImp() {
    return codeImp;
  }

  public void setCodeImp(String codeImp) {
    this.codeImp = codeImp;
  }

  public OperationDiv getOperationDiv() {
    return operationDiv;
  }

  public void setOperationDiv(OperationDiv operationDiv) {
    this.operationDiv = operationDiv;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (operationDivDetPK != null ? operationDivDetPK.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof OperationDivDet)) {
      return false;
    }
    OperationDivDet other = (OperationDivDet) object;
    if ((this.operationDivDetPK == null && other.operationDivDetPK != null)
        || (this.operationDivDetPK != null
            && !this.operationDivDetPK.equals(other.operationDivDetPK))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "entity.OperationDivDet[ operationDivDetPK=" + operationDivDetPK + " ]";
  }

}
