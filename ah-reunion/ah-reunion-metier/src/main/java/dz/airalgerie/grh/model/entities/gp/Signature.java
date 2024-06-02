/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.grh.model.entities.gp;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrateur
 */
@Entity
@Table(schema = "GP", name = "SIGNATURE")
@XmlRootElement
@NamedQueries({@NamedQuery(name = "Signature.findAll", query = "SELECT s FROM Signature s"),
    @NamedQuery(name = "Signature.findById", query = "SELECT s FROM Signature s WHERE s.id = :id"),
    @NamedQuery(name = "Signature.findByName",
        query = "SELECT s FROM Signature s WHERE s.name = :name")})
public class Signature implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @NotNull
  @Column(name = "ID")
  private Integer id;
  @Size(max = 50)
  @Column(name = "NAME")
  private String name;
  @JoinColumn(name = "IMAGE_ID", referencedColumnName = "ID")
  @OneToOne
  private ImageEnt imageId;

  public Signature() {}

  public Signature(Integer id) {
    this.id = id;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public ImageEnt getImageId() {
    return imageId;
  }

  public void setImageId(ImageEnt imageId) {
    this.imageId = imageId;
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
    if (!(object instanceof Signature)) {
      return false;
    }
    Signature other = (Signature) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "dz.airalgerie.gpmanagement.entities.Signature[ id=" + id + " ]";
  }

}
