/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.grh.model.entities.rem;

import dz.airalgerie.commun.grh.utils.Utils;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author kemikem
 */
@Entity
@Table(name = "BULLETIN_POINTAGE", schema = Utils.dbSchema)
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BulletinPointage.findAll", query = "SELECT b FROM BulletinPointage b"),
    @NamedQuery(name = "BulletinPointage.findByMatricule",
        query = "SELECT b FROM BulletinPointage b WHERE b.bulletinPointagePK.matricule = :matricule"),
    @NamedQuery(name = "BulletinPointage.findByDatePai",
        query = "SELECT b FROM BulletinPointage b WHERE b.bulletinPointagePK.datePai = :datePai"),
    @NamedQuery(name = "BulletinPointage.findByDateTrt",
        query = "SELECT b FROM BulletinPointage b WHERE b.bulletinPointagePK.dateTrt = :dateTrt"),
    @NamedQuery(name = "BulletinPointage.findByBulPrim",
        query = "SELECT b FROM BulletinPointage b WHERE b.bulletinPointagePK.bulPrim = :bulPrim"),
    @NamedQuery(name = "BulletinPointage.findByCodPoin",
        query = "SELECT b FROM BulletinPointage b WHERE b.bulletinPointagePK.codPoin = :codPoin"),
    @NamedQuery(name = "BulletinPointage.findByLibPoin",
        query = "SELECT b FROM BulletinPointage b WHERE b.libPoin = :libPoin"),
    @NamedQuery(name = "BulletinPointage.findByNbrJour",
        query = "SELECT b FROM BulletinPointage b WHERE b.nbrJour = :nbrJour"),
    @NamedQuery(name = "BulletinPointage.findByCodeFil",
        query = "SELECT b FROM BulletinPointage b WHERE b.bulletinPointagePK.codeFil = :codeFil")})
public class BulletinPointage implements Serializable {

  private static final long serialVersionUID = 1L;
  @EmbeddedId
  protected BulletinPointagePK bulletinPointagePK;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 50)
  @Column(name = "LIB_POIN")
  private String libPoin;
  @Basic(optional = false)
  @NotNull
  @Column(name = "NBR_JOUR")
  private int nbrJour;
  @JoinColumns({
      @JoinColumn(name = "MATRICULE", referencedColumnName = "MATRICULE", insertable = false,
          updatable = false),
      @JoinColumn(name = "DATE_PAI", referencedColumnName = "DATE_PAI", insertable = false,
          updatable = false),
      @JoinColumn(name = "DATE_TRT", referencedColumnName = "DATE_TRT", insertable = false,
          updatable = false),
      @JoinColumn(name = "BUL_PRIM", referencedColumnName = "BUL_PRIM", insertable = false,
          updatable = false),
      @JoinColumn(name = "CODE_FIL", referencedColumnName = "CODE_FIL", insertable = false,
          updatable = false)})
  @ManyToOne(optional = false)
  private Bulletin bulletin;

  public BulletinPointage() {}

  public BulletinPointage(BulletinPointagePK bulletinPointagePK) {
    this.bulletinPointagePK = bulletinPointagePK;
  }

  public BulletinPointage(BulletinPointagePK bulletinPointagePK, String libPoin, int nbrJour) {
    this.bulletinPointagePK = bulletinPointagePK;
    this.libPoin = libPoin;
    this.nbrJour = nbrJour;
  }

  public BulletinPointage(int matricule, int datePai, int dateTrt, boolean bulPrim, int codPoin,
      Character codeFil) {
    this.bulletinPointagePK =
        new BulletinPointagePK(matricule, datePai, dateTrt, bulPrim, codPoin, codeFil);
  }

  public BulletinPointagePK getBulletinPointagePK() {
    return bulletinPointagePK;
  }

  public void setBulletinPointagePK(BulletinPointagePK bulletinPointagePK) {
    this.bulletinPointagePK = bulletinPointagePK;
  }

  public String getLibPoin() {
    return libPoin;
  }

  public void setLibPoin(String libPoin) {
    this.libPoin = libPoin;
  }

  public int getNbrJour() {
    return nbrJour;
  }

  public void setNbrJour(int nbrJour) {
    this.nbrJour = nbrJour;
  }

  public Bulletin getBulletin() {
    return bulletin;
  }

  public void setBulletin(Bulletin bulletin) {
    this.bulletin = bulletin;
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
    if (!(object instanceof BulletinPointage)) {
      return false;
    }
    BulletinPointage other = (BulletinPointage) object;
    if ((this.bulletinPointagePK == null && other.bulletinPointagePK != null)
        || (this.bulletinPointagePK != null
            && !this.bulletinPointagePK.equals(other.bulletinPointagePK))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "ENTITY.SAISIE.BulletinPointage[ bulletinPointagePK=" + bulletinPointagePK + " ]";
  }

}
