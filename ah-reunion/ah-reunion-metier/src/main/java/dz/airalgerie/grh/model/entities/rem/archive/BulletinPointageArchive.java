/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.grh.model.entities.rem.archive;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author Diaf
 */

@Entity
@Table(name = "BULLETIN_POINTAGE", schema = "T_BP")
public class BulletinPointageArchive implements Serializable {

  private static final long serialVersionUID = 1L;
  @EmbeddedId
  private BulletinPointageArchivePK bulletinPointagePK;

  @Column(name = "NBR_JOUR")
  private Integer NBR_JOUR;

  public BulletinPointageArchive() {}

  public BulletinPointageArchive(BulletinPointageArchivePK bulletinPointagePK) {
    this.bulletinPointagePK = bulletinPointagePK;
  }

  public BulletinPointageArchivePK getBulletinPointagePK() {
    return bulletinPointagePK;
  }

  public void setBulletinPointagePK(BulletinPointageArchivePK bulletinPointagePK) {
    this.bulletinPointagePK = bulletinPointagePK;
  }

  public Integer getNBR_JOUR() {
    return NBR_JOUR;
  }

  public void setNBR_JOUR(Integer NBR_JOUR) {
    this.NBR_JOUR = NBR_JOUR;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (bulletinPointagePK != null ? bulletinPointagePK.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof BulletinPointageArchive)) {
      return false;
    }
    BulletinPointageArchive other = (BulletinPointageArchive) object;
    if ((this.bulletinPointagePK == null && other.bulletinPointagePK != null)
        || (this.bulletinPointagePK != null
            && !this.bulletinPointagePK.equals(other.bulletinPointagePK))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "ENTITY.BulletinPointageArchive[ id=" + bulletinPointagePK + " ]";
  }

}
