/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.gfc.model.entities.cie;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Administrateur
 */
@Entity
@Table(name = "OPERATION_DIV", catalog = "CPTA", schema = "CE")
@XmlRootElement
@NamedQueries({@NamedQuery(name = "OperationDiv.findAll", query = "SELECT o FROM OperationDiv o"),
    @NamedQuery(name = "OperationDiv.findByDateCpta",
        query = "SELECT o FROM OperationDiv o WHERE o.operationDivPK.dateCpta = :dateCpta"),
    @NamedQuery(name = "OperationDiv.findByGrpChap",
        query = "SELECT o FROM OperationDiv o WHERE o.operationDivPK.grpChap = :grpChap"),
    @NamedQuery(name = "OperationDiv.findByCodeConst",
        query = "SELECT o FROM OperationDiv o WHERE o.codeConst = :codeConst"),
    @NamedQuery(name = "OperationDiv.findByValAlph",
        query = "SELECT o FROM OperationDiv o WHERE o.valAlph = :valAlph"),
    @NamedQuery(name = "OperationDiv.findByValNum",
        query = "SELECT o FROM OperationDiv o WHERE o.valNum = :valNum")})
public class OperationDiv implements Serializable {

  private static final long serialVersionUID = 1L;
  @EmbeddedId
  protected OperationDivPK operationDivPK;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 10)
  @Column(name = "CODE_CONST", nullable = false, length = 10)
  private String codeConst;
  @Size(max = 30)
  @Column(name = "VAL_ALPH", length = 30)
  private String valAlph;
  @Size(max = 15)
  @Column(name = "VAL_NUM", length = 15)
  private String valNum;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "operationDiv")
  private Collection<OperationDivDet> operationDivDetCollection;

  public OperationDiv() {}

  public OperationDiv(OperationDivPK operationDivPK) {
    this.operationDivPK = operationDivPK;
  }

  public OperationDiv(OperationDivPK operationDivPK, String codeConst) {
    this.operationDivPK = operationDivPK;
    this.codeConst = codeConst;
  }

  public OperationDiv(int dateCpta, String grpChap) {
    this.operationDivPK = new OperationDivPK(dateCpta, grpChap);
  }

  public OperationDivPK getOperationDivPK() {
    if (operationDivPK == null)
      operationDivPK = new OperationDivPK();
    return operationDivPK;
  }

  public void setOperationDivPK(OperationDivPK operationDivPK) {
    this.operationDivPK = operationDivPK;
  }

  public String getCodeConst() {
    return codeConst;
  }

  public void setCodeConst(String codeConst) {
    this.codeConst = codeConst;
  }

  public String getValAlph() {
    return valAlph;
  }

  public void setValAlph(String valAlph) {
    this.valAlph = valAlph;
  }

  public String getValNum() {
    return valNum;
  }

  public void setValNum(String valNum) {
    this.valNum = valNum;
  }

  @XmlTransient
  public Collection<OperationDivDet> getOperationDivDetCollection() {
    return operationDivDetCollection;
  }

  public void setOperationDivDetCollection(Collection<OperationDivDet> operationDivDetCollection) {
    this.operationDivDetCollection = operationDivDetCollection;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (operationDivPK != null ? operationDivPK.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof OperationDiv)) {
      return false;
    }
    OperationDiv other = (OperationDiv) object;
    if ((this.operationDivPK == null && other.operationDivPK != null)
        || (this.operationDivPK != null && !this.operationDivPK.equals(other.operationDivPK))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "entity.OperationDiv[ operationDivPK=" + operationDivPK + " ]";
  }

}
