/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.commun.gfc.stockcsv.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author kemikem
 */
@Entity
@Table(name = "REPAIRE", schema = "dbo")
@XmlRootElement
@NamedQueries({@NamedQuery(name = "Repaire.findAll", query = "SELECT r FROM Repaire r"),
    @NamedQuery(name = "Repaire.findByCoderep",
        query = "SELECT r FROM Repaire r WHERE r.repairePK.coderep = :coderep"),
    @NamedQuery(name = "Repaire.findByCodemag",
        query = "SELECT r FROM Repaire r WHERE r.repairePK.codemag = :codemag"),
    @NamedQuery(name = "Repaire.findByLibeller",
        query = "SELECT r FROM Repaire r WHERE r.libeller = :libeller")})
public class Repaire implements Serializable {

  private static final long serialVersionUID = 1L;
  @EmbeddedId
  protected RepairePK repairePK;
  @Size(max = 60)
  @Column(name = "LIBELLER")
  private String libeller;
  @JoinColumn(name = "CODEMAG", referencedColumnName = "CODEMAG", insertable = false,
      updatable = false)
  @ManyToOne(optional = false)
  private Magazine magazine;

  public Repaire() {}

  public Repaire(RepairePK repairePK) {
    this.repairePK = repairePK;
  }

  public Repaire(String coderep, int codemag) {
    this.repairePK = new RepairePK(coderep, codemag);
  }

  public RepairePK getRepairePK() {
    return repairePK;
  }

  public void setRepairePK(RepairePK repairePK) {
    this.repairePK = repairePK;
  }

  public String getLibeller() {
    return libeller;
  }

  public void setLibeller(String libeller) {
    this.libeller = libeller;
  }

  public Magazine getMagazine() {
    return magazine;
  }

  public void setMagazine(Magazine magazine) {
    this.magazine = magazine;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (repairePK != null ? repairePK.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Repaire)) {
      return false;
    }
    Repaire other = (Repaire) object;
    if ((this.repairePK == null && other.repairePK != null)
        || (this.repairePK != null && !this.repairePK.equals(other.repairePK))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "Entite.Repaire[ repairePK=" + repairePK + " ]";
  }

}
