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
@Table(schema = "GP", name = "AEROPORT")
@XmlRootElement
@NamedQueries({@NamedQuery(name = "Aeroport.findAll", query = "SELECT a FROM Aeroport a"),
    @NamedQuery(name = "Aeroport.findByAeroDesc",
        query = "SELECT a FROM Aeroport a WHERE a.aeroDesc = :aeroDesc"),
    @NamedQuery(name = "Aeroport.findByCodeIata",
        query = "SELECT a FROM Aeroport a WHERE a.codeIata = :codeIata"),
    @NamedQuery(name = "Aeroport.findByCodeOaci",
        query = "SELECT a FROM Aeroport a WHERE a.codeOaci = :codeOaci"),
    @NamedQuery(name = "Aeroport.findByAeroCountry",
        query = "SELECT a FROM Aeroport a WHERE a.aeroCountry = :aeroCountry")})
public class Aeroport implements Serializable {

  private static final long serialVersionUID = 1L;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 100)
  @Column(name = "AERO_DESC")
  private String aeroDesc;
  @Id
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 3)
  @Column(name = "CODE_IATA")
  private String codeIata;
  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 4)
  @Column(name = "CODE_OACI")
  private String codeOaci;
  @Size(max = 100)
  @Column(name = "AERO_COUNTRY")
  private String aeroCountry;
  @Column(name = "LIMIT")
  private Integer limit;
  @Column(name = "ANC")
  private Integer anc;
  @Column(name = "AVAILABLE")
  private boolean available;
  @Column(name = "R1")
  private Integer r1;
  @Column(name = "R2")
  private Integer r2;
  @Column(name = "R3")
  private Integer r3;

  public Aeroport() {
  }

  public Aeroport(String codeIata) {
    this.codeIata = codeIata;
  }

  public Aeroport(String codeIata, String aeroDesc, String codeOaci) {
    this.codeIata = codeIata;
    this.aeroDesc = aeroDesc;
    this.codeOaci = codeOaci;
  }

  public String getAeroDesc() {
    return aeroDesc;
  }

  public void setAeroDesc(String aeroDesc) {
    this.aeroDesc = aeroDesc;
  }

  public String getCodeIata() {
    return codeIata;
  }

  public void setCodeIata(String codeIata) {
    this.codeIata = codeIata;
  }

  public String getCodeOaci() {
    return codeOaci;
  }

  public void setCodeOaci(String codeOaci) {
    this.codeOaci = codeOaci;
  }

  public String getAeroCountry() {
    return aeroCountry;
  }

  public void setAeroCountry(String aeroCountry) {
    this.aeroCountry = aeroCountry;
  }

  public Integer getLimit() {
    return limit;
  }

  public void setLimit(Integer limit) {
    this.limit = limit;
  }

  public Integer getAnc() {
    return anc;
  }

  public void setAnc(Integer anc) {
    this.anc = anc;
  }

  public boolean isAvailable() {
    return available;
  }

  public void setAvailable(boolean available) {
    this.available = available;
  }

  public Integer getR1() {
    return r1;
  }

  public void setR1(Integer r1) {
    this.r1 = r1;
  }

  public Integer getR2() {
    return r2;
  }

  public void setR2(Integer r2) {
    this.r2 = r2;
  }

  public Integer getR3() {
    return r3;
  }

  public void setR3(Integer r3) {
    this.r3 = r3;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (codeIata != null ? codeIata.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Aeroport)) {
      return false;
    }
    Aeroport other = (Aeroport) object;
    if ((this.codeIata == null && other.codeIata != null)
        || (this.codeIata != null && !this.codeIata.equals(other.codeIata))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "" + aeroDesc + " (" + codeIata + ") ";
  }

}
