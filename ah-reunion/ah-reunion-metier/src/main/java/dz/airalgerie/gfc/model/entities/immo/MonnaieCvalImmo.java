/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.gfc.model.entities.immo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author user
 */
@Entity
@Table(name = "monnaiecval")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MonnaieCvalImmo.findAll", query = "SELECT m FROM MonnaieCvalImmo m"),
    @NamedQuery(name = "MonnaieCvalImmo.findById",
        query = "SELECT m FROM MonnaieCvalImmo m WHERE m.id = :id"),
    @NamedQuery(name = "MonnaieCvalImmo.findByCodeMonnaie",
        query = "SELECT m FROM MonnaieCvalImmo m WHERE m.codeMonnaie = :codeMonnaie"),
    @NamedQuery(name = "MonnaieCvalImmo.findByDateCpt",
        query = "SELECT m FROM MonnaieCvalImmo m WHERE m.dateCpt = :dateCpt"),
    @NamedQuery(name = "MonnaieCvalImmo.findByCval",
        query = "SELECT m FROM MonnaieCvalImmo m WHERE m.cval = :cval")})
public class MonnaieCvalImmo implements Serializable {
  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(name = "id")
  private Integer id;
  @Column(name = "code_monnaie")
  @NotNull
  @NotEmpty
  private Integer codeMonnaie;
  @Column(name = "date_cpt")
  @Temporal(TemporalType.DATE)
  private Date dateCpt;
  @Min(value = 0) // if you know range of your decimal fields consider using these annotations to
                  // enforce field validation
  @Column(name = "cval")
  private Double cval;

  public MonnaieCvalImmo() {}

  public MonnaieCvalImmo(Integer id) {
    this.id = id;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getCodeMonnaie() {
    return codeMonnaie;
  }

  public void setCodeMonnaie(Integer codeMonnaie) {
    this.codeMonnaie = codeMonnaie;
  }

  public Date getDateCpt() {
    return dateCpt;
  }

  public void setDateCpt(Date dateCpt) {
    this.dateCpt = dateCpt;
  }

  public Double getCval() {
    return cval;
  }

  public void setCval(Double cval) {
    this.cval = cval;
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
    if (!(object instanceof MonnaieCvalImmo)) {
      return false;
    }
    MonnaieCvalImmo other = (MonnaieCvalImmo) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "dz.airalgerie.gfc.model.entities.immo.MonnaieCvalImmo[ id=" + id + " ]";
  }

}
