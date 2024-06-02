/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.commun.gfc.stock.entities;

import java.io.Serializable;
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
 * @author user
 */
@Entity
@Table(name = "STK.interchangeable")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Interchangeable.findAll", query = "SELECT i FROM Interchangeable i"),
    @NamedQuery(name = "Interchangeable.findByPnArt",
        query = "SELECT i FROM Interchangeable i WHERE i.interchangeablePK.pnArt = :pnArt"),
    @NamedQuery(name = "Interchangeable.findByCodeAppareilart",
        query = "SELECT i FROM Interchangeable i WHERE i.interchangeablePK.codeAppareilart = :codeAppareilart"),
    @NamedQuery(name = "Interchangeable.findByPnInter",
        query = "SELECT i FROM Interchangeable i WHERE i.interchangeablePK.pnInter = :pnInter"),
    @NamedQuery(name = "Interchangeable.findByCodeAppareilinter",
        query = "SELECT i FROM Interchangeable i WHERE i.interchangeablePK.codeAppareilinter = :codeAppareilinter"),
    @NamedQuery(name = "Interchangeable.findByObservation",
        query = "SELECT i FROM Interchangeable i WHERE i.observation = :observation")})
public class Interchangeable implements Serializable {
  private static final long serialVersionUID = 1L;
  @EmbeddedId
  protected InterchangeablePK interchangeablePK;
  @Size(max = 100)
  @Column(name = "observation")
  private String observation;
  @JoinColumns({
      @JoinColumn(name = "pn_inter", referencedColumnName = "pn", insertable = false,
          updatable = false),
      @JoinColumn(name = "codeAppareil_inter", referencedColumnName = "codeAppareil",
          insertable = false, updatable = false)})
  @ManyToOne(optional = false)
  private Article article;
  @JoinColumns({
      @JoinColumn(name = "pn_art", referencedColumnName = "pn", insertable = false,
          updatable = false),
      @JoinColumn(name = "codeAppareil_art", referencedColumnName = "codeAppareil",
          insertable = false, updatable = false)})
  @ManyToOne(optional = false)
  private Article article1;

  public Interchangeable() {}

  public Interchangeable(InterchangeablePK interchangeablePK) {
    this.interchangeablePK = interchangeablePK;
  }

  public Interchangeable(String pnArt, String codeAppareilart, String pnInter,
      String codeAppareilinter) {
    this.interchangeablePK =
        new InterchangeablePK(pnArt, codeAppareilart, pnInter, codeAppareilinter);
  }

  public InterchangeablePK getInterchangeablePK() {
    return interchangeablePK;
  }

  public void setInterchangeablePK(InterchangeablePK interchangeablePK) {
    this.interchangeablePK = interchangeablePK;
  }

  public String getObservation() {
    return observation;
  }

  public void setObservation(String observation) {
    this.observation = observation;
  }

  public Article getArticle() {
    return article;
  }

  public void setArticle(Article article) {
    this.article = article;
  }

  public Article getArticle1() {
    return article1;
  }

  public void setArticle1(Article article1) {
    this.article1 = article1;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (interchangeablePK != null ? interchangeablePK.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Interchangeable)) {
      return false;
    }
    Interchangeable other = (Interchangeable) object;
    if ((this.interchangeablePK == null && other.interchangeablePK != null)
        || (this.interchangeablePK != null
            && !this.interchangeablePK.equals(other.interchangeablePK))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "dz.ah.stock.dmra.entities.Interchangeable[ interchangeablePK=" + interchangeablePK
        + " ]";
  }

}
