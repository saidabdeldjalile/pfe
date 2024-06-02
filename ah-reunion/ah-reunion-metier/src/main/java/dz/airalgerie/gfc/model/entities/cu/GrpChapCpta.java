/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.gfc.model.entities.cu;

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

/**
 *
 * @author Root
 */
@Entity
@Table(schema = "COM", name = "V_GRP_CHAP")
@NamedQueries({@NamedQuery(name = "GrpChapCpta.findAll", query = "SELECT v FROM GrpChapCpta v"),
    @NamedQuery(name = "GrpChapCpta.findByGrpChap",
        query = "SELECT v FROM GrpChapCpta v WHERE v.grpChap = :grpChap"),
    @NamedQuery(name = "GrpChapCpta.findByLibelle",
        query = "SELECT v FROM GrpChapCpta v WHERE v.libelle = :libelle"),
    @NamedQuery(name = "GrpChapCpta.findByDescDir",
        query = "SELECT v FROM GrpChapCpta v WHERE v.descDir = :descDir")})
public class GrpChapCpta implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 4)
  @Column(name = "GRP_CHAP")
  private String grpChap;
  @Id
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 150)
  @Column(name = "LIBELLE")
  private String libelle;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 50)
  @Column(name = "DESC_DIR")
  private String descDir;

  public GrpChapCpta() {
  }

  public String getGrpChap() {
    return grpChap;
  }

  public void setGrpChap(String grpChap) {
    this.grpChap = grpChap;
  }

  public String getLibelle() {
    return libelle;
  }

  public void setLibelle(String libelle) {
    this.libelle = libelle;
  }

  public String getDescDir() {
    return descDir;
  }

  public void setDescDir(String descDir) {
    this.descDir = descDir;
  }

  @Override
  public String toString() {
    return grpChap + " - " + libelle;
  }
  
}
