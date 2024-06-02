/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.gfc.model.view.ca;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrateur
 */
@Entity
@Table(name = "V_cout_escal_RESEAU", schema = "CA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VcoutescalRESEAU.findAll", query = "SELECT v FROM VcoutescalRESEAU v"),
    @NamedQuery(name = "VcoutescalRESEAU.findById",
        query = "SELECT v FROM VcoutescalRESEAU v WHERE v.id = :id"),
    @NamedQuery(name = "VcoutescalRESEAU.findByDateTrt",
        query = "SELECT v FROM VcoutescalRESEAU v WHERE v.dateTrt = :dateTrt"),
    @NamedQuery(name = "VcoutescalRESEAU.findByReseau",
        query = "SELECT v FROM VcoutescalRESEAU v WHERE v.reseau = :reseau"),
    @NamedQuery(name = "VcoutescalRESEAU.findByCoutFSCAL",
        query = "SELECT v FROM VcoutescalRESEAU v WHERE v.coutFSCAL = :coutFSCAL")})
public class VcoutescalRESEAU implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @Column(name = "id")
  private BigInteger id;
  @Basic(optional = false)
  @NotNull
  @Column(name = "DATE_TRT")
  private int dateTrt;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 50)
  @Column(name = "RESEAU")
  private String reseau;
  // @Max(value=?) @Min(value=?)//if you know range of your decimal fields consider using these
  // annotations to enforce field validation
  @Column(name = "cout_FSCAL")
  private BigDecimal coutFSCAL;

  public VcoutescalRESEAU() {}

  public BigInteger getId() {
    return id;
  }

  public void setId(BigInteger id) {
    this.id = id;
  }

  public int getDateTrt() {
    return dateTrt;
  }

  public void setDateTrt(int dateTrt) {
    this.dateTrt = dateTrt;
  }

  public String getReseau() {
    return reseau;
  }

  public void setReseau(String reseau) {
    this.reseau = reseau;
  }

  public BigDecimal getCoutFSCAL() {
    return coutFSCAL;
  }

  public void setCoutFSCAL(BigDecimal coutFSCAL) {
    this.coutFSCAL = coutFSCAL;
  }

}
