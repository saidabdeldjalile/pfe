/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.gfc.model.entities.immo;

import dz.airalgerie.gfc.model.entities.commun.UniteImmo;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Administrateur
 */
@Entity
@Table(name = "DOSSIERREFORME")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dossierreforme.findAll", query = "SELECT d FROM Dossierreforme d")})
public class Dossierreforme implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @NotNull
  @Column(name = "DOSSIERREFORMEID")
  private Long dossierreformeid;
  @Column(name = "CREATED")
  @Temporal(TemporalType.TIMESTAMP)
  private Date created;
  @Size(max = 50)
  @Column(name = "STATUT")
  private String statut;
  @Column(name = "DATEREFORME")
  @Temporal(TemporalType.TIMESTAMP)
  private Date datereforme;
  @Column(name = "DATEDEMANDE")
  @Temporal(TemporalType.TIMESTAMP)
  private Date datedemande;
  @JoinColumn(name = "UNITE", referencedColumnName = "UNITEID")
  @ManyToOne(fetch = FetchType.LAZY)
  private UniteImmo unite;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "dossierreforme", fetch = FetchType.LAZY)
  private List<RaisonReforme> raisonReformeList;

  public Dossierreforme() {}

  public Dossierreforme(Long dossierreformeid) {
    this.dossierreformeid = dossierreformeid;
  }

  public Long getDossierreformeid() {
    return dossierreformeid;
  }

  public void setDossierreformeid(Long dossierreformeid) {
    this.dossierreformeid = dossierreformeid;
  }

  public Date getCreated() {
    return created;
  }

  public void setCreated(Date created) {
    this.created = created;
  }

  public String getStatut() {
    return statut;
  }

  public void setStatut(String statut) {
    this.statut = statut;
  }

  public Date getDatereforme() {
    return datereforme;
  }

  public void setDatereforme(Date datereforme) {
    this.datereforme = datereforme;
  }

  public Date getDatedemande() {
    return datedemande;
  }

  public void setDatedemande(Date datedemande) {
    this.datedemande = datedemande;
  }

  public UniteImmo getUnite() {
    return unite;
  }

  public void setUnite(UniteImmo unite) {
    this.unite = unite;
  }

  @XmlTransient
  public List<RaisonReforme> getRaisonReformeList() {
    return raisonReformeList;
  }

  public void setRaisonReformeList(List<RaisonReforme> raisonReformeList) {
    this.raisonReformeList = raisonReformeList;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (dossierreformeid != null ? dossierreformeid.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Dossierreforme)) {
      return false;
    }
    Dossierreforme other = (Dossierreforme) object;
    if ((this.dossierreformeid == null && other.dossierreformeid != null)
        || (this.dossierreformeid != null
            && !this.dossierreformeid.equals(other.dossierreformeid))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "dz.airalgerie.scf.model.entity.immo.Dossierreforme[ dossierreformeid="
        + dossierreformeid + " ]";
  }

}
