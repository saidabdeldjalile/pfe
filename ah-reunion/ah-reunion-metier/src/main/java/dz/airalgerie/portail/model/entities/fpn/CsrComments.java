/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.portail.model.entities.fpn;

import dz.airalgerie.commun.utils.ErpConstante;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 */
@Entity
@Table(schema = ErpConstante.DbSchemaName.AGS_FPN, name = "CSR_COMMENTS")
@NamedQueries({@NamedQuery(name = "CsrComments.findAll", query = "SELECT c FROM CsrComments c")})
public class CsrComments implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(name = "ID")
  private Integer id;
  @JoinColumn(name = "MATRICULE", referencedColumnName = "MATRICULE")
  @ManyToOne(fetch = FetchType.LAZY)
  private PersonnelAgs personnelAgs;
  @Basic(optional = false)
  @NotNull
  @Lob
  @Size(min = 1, max = 2147483647)
  @Column(name = "MESSAGE")
  private String message;
  @Basic(optional = false)
  @NotNull
  @Column(name = "CREATED_AT")
  private LocalDateTime createdAt;
  @JoinColumn(name = "CSR_ID", referencedColumnName = "ID")
  @ManyToOne(optional = false, fetch = FetchType.LAZY)
  private Csr csr;
  @OneToMany(mappedBy = "csrCommentsParent", fetch = FetchType.LAZY)
  private List<CsrComments> csrCommentsList;
  @JoinColumn(name = "CSR_COMMENT_ID", referencedColumnName = "ID")
  @ManyToOne(fetch = FetchType.LAZY)
  private CsrComments csrCommentsParent;

  public CsrComments() {
  }

  public CsrComments(Integer id) {
    this.id = id;
  }

  public CsrComments(Integer id, PersonnelAgs personnelAgs, String message,
      LocalDateTime createdAt) {
    this.id = id;
    this.personnelAgs = personnelAgs;
    this.message = message;
    this.createdAt = createdAt;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public PersonnelAgs getPersonnelAgs() {
    return personnelAgs;
  }

  public void setPersonnelAgs(PersonnelAgs personnelAgs) {
    this.personnelAgs = personnelAgs;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public LocalDateTime getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(LocalDateTime createdAt) {
    this.createdAt = createdAt;
  }

  public Csr getCsr() {
    return csr;
  }

  public void setCsr(Csr csr) {
    this.csr = csr;
  }

  public List<CsrComments> getCsrCommentsList() {
    return csrCommentsList;
  }

  public void setCsrCommentsList(List<CsrComments> csrCommentsList) {
    this.csrCommentsList = csrCommentsList;
  }

  public CsrComments getCsrCommentsParent() {
    return csrCommentsParent;
  }

  public void setCsrCommentsParent(CsrComments csrCommentsParent) {
    this.csrCommentsParent = csrCommentsParent;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (id != null ? id.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof CsrComments)) {
      return false;
    }
    CsrComments other = (CsrComments) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "dz.airalgerie.portail.model.entities.fpn.CsrComments[ id=" + id + " ]";
  }

}
