/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this
 * license Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package dz.airalgerie.portail.model.entities.tkt;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author AGHA Riadh
 */
@Entity
@Table(schema = "PRG", name = "MODE_REMBOURSEMENT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ModeRemboursement.findAll", query = "SELECT m FROM ModeRemboursement m"),
    @NamedQuery(name = "ModeRemboursement.findByModeRemboursement",
        query = "SELECT m FROM ModeRemboursement m WHERE m.modeRemboursement = :modeRemboursement"),
    @NamedQuery(name = "ModeRemboursement.findByLibelle",
        query = "SELECT m FROM ModeRemboursement m WHERE m.libelle = :libelle")})
public class ModeRemboursement implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 2)
  @Column(name = "MODE_REMBOURSEMENT")
  private String modeRemboursement;
  @Size(max = 50)
  @Column(name = "LIBELLE")
  private String libelle;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "modeRemboursement", fetch = FetchType.LAZY)
  private List<CompensationTKT> compensationList;

  public ModeRemboursement() {
  }

  public ModeRemboursement(String modeRemboursement) {
    this.modeRemboursement = modeRemboursement;
  }

  public String getModeRemboursement() {
    return modeRemboursement;
  }

  public void setModeRemboursement(String modeRemboursement) {
    this.modeRemboursement = modeRemboursement;
  }

  public String getLibelle() {
    return libelle;
  }

  public void setLibelle(String libelle) {
    this.libelle = libelle;
  }

  public List<CompensationTKT> getCompensationList() {
    return compensationList;
  }

  public void setCompensationList(List<CompensationTKT> compensationList) {
    this.compensationList = compensationList;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (modeRemboursement != null ? modeRemboursement.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof ModeRemboursement)) {
      return false;
    }
    ModeRemboursement other = (ModeRemboursement) object;
    if ((this.modeRemboursement == null && other.modeRemboursement != null)
        || (this.modeRemboursement != null
            && !this.modeRemboursement.equals(other.modeRemboursement))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "dz.airalgerie.portail.model.entities.tkt.ModeRemboursement[ modeRemboursement="
        + modeRemboursement + " ]";
  }

}
