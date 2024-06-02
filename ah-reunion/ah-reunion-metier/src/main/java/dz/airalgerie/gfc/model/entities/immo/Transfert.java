/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.gfc.model.entities.immo;

import java.io.Serializable;
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
 * @author Administrateur
 */
@Entity
@Table(name = "TRANSFERT")
@XmlRootElement
@NamedQueries({@NamedQuery(name = "Transfert.findAll", query = "SELECT t FROM Transfert t")})
public class Transfert implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @NotNull
  @Column(name = "TRANSFERTID")
  private Long transfertid;
  @Column(name = "DOSSIERTRANSFERTID")
  private Long dossiertransfertid;
  @Size(max = 20)
  @Column(name = "STATUT")
  private String statut;
  @Size(max = 255)
  @Column(name = "CODENOM")
  private String codenom;
  // @JoinColumn(name = "USERID", referencedColumnName = "USERID")
  // @ManyToOne(optional = false, fetch = FetchType.LAZY)
  // private Appuser appuser;

  public Transfert() {}

  public Transfert(Long transfertid) {
    this.transfertid = transfertid;
  }

  public Long getTransfertid() {
    return transfertid;
  }

  public void setTransfertid(Long transfertid) {
    this.transfertid = transfertid;
  }

  public Long getDossiertransfertid() {
    return dossiertransfertid;
  }

  public void setDossiertransfertid(Long dossiertransfertid) {
    this.dossiertransfertid = dossiertransfertid;
  }

  public String getStatut() {
    return statut;
  }

  public void setStatut(String statut) {
    this.statut = statut;
  }

  public String getCodenom() {
    return codenom;
  }

  public void setCodenom(String codenom) {
    this.codenom = codenom;
  }

  // public Appuser getAppuser() {
  // return appuser;
  // }
  //
  // public void setAppuser(Appuser appuser) {
  // this.appuser = appuser;
  // }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (transfertid != null ? transfertid.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {

    if (!(object instanceof Transfert)) {
      return false;
    }
    Transfert other = (Transfert) object;
    if ((this.transfertid == null && other.transfertid != null)
        || (this.transfertid != null && !this.transfertid.equals(other.transfertid))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "dz.airalgerie.scf.model.entity.immo.Transfert[ transfertid=" + transfertid + " ]";
  }

}
