/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.commun.grh.maladie.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author user
 */
@Entity
@Table(name = "MLD.SOCIAL")
@XmlRootElement
@NamedQueries({@NamedQuery(name = "Social.findAll", query = "SELECT s FROM Social s"),
    @NamedQuery(name = "Social.findByMatricule",
        query = "SELECT s FROM Social s WHERE s.socialPK.matricule = :matricule"),
    @NamedQuery(name = "Social.findByDatePai",
        query = "SELECT s FROM Social s WHERE s.socialPK.datePai = :datePai"),
    @NamedQuery(name = "Social.findByNumCheque",
        query = "SELECT s FROM Social s WHERE s.socialPK.numCheque = :numCheque"),
    @NamedQuery(name = "Social.findByNumBdx",
        query = "SELECT s FROM Social s WHERE s.socialPK.numBdx = :numBdx"),
    @NamedQuery(name = "Social.findByCodeRub",
        query = "SELECT s FROM Social s WHERE s.socialPK.codeRub = :codeRub"),
    @NamedQuery(name = "Social.findByNumMgt",
        query = "SELECT s FROM Social s WHERE s.numMgt = :numMgt"),
    @NamedQuery(name = "Social.findByNumSs",
        query = "SELECT s FROM Social s WHERE s.numSs = :numSs"),
    @NamedQuery(name = "Social.findByDateSaise",
        query = "SELECT s FROM Social s WHERE s.dateSaise = :dateSaise")})
public class Social implements Serializable {
  private static final long serialVersionUID = 1L;
  @EmbeddedId
  protected SocialPK socialPK;
  @Size(max = 30)
  @Column(name = "NUM_MGT")
  private String numMgt;
  @Size(max = 30)
  @Column(name = "NUM_SS")
  private String numSs;
  @Column(name = "DATE_SAISE")
  @Temporal(TemporalType.DATE)
  private Date dateSaise;

  public Social() {}

  public Social(SocialPK socialPK) {
    this.socialPK = socialPK;
  }

  public Social(int matricule, int datePai, String numCheque, String numBdx, String codeRub) {
    this.socialPK = new SocialPK(matricule, datePai, numCheque, numBdx, codeRub);
  }

  public SocialPK getSocialPK() {
    return socialPK;
  }

  public void setSocialPK(SocialPK socialPK) {
    this.socialPK = socialPK;
  }

  public String getNumMgt() {
    return numMgt;
  }

  public void setNumMgt(String numMgt) {
    this.numMgt = numMgt;
  }

  public String getNumSs() {
    return numSs;
  }

  public void setNumSs(String numSs) {
    this.numSs = numSs;
  }

  public Date getDateSaise() {
    return dateSaise;
  }

  public void setDateSaise(Date dateSaise) {
    this.dateSaise = dateSaise;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (socialPK != null ? socialPK.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Social)) {
      return false;
    }
    Social other = (Social) object;
    if ((this.socialPK == null && other.socialPK != null)
        || (this.socialPK != null && !this.socialPK.equals(other.socialPK))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "dz.ah.MLD.entities.Social[ socialPK=" + socialPK + " ]";
  }

}
