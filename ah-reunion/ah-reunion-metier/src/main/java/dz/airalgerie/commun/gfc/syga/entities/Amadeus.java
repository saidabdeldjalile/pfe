
package dz.airalgerie.commun.gfc.syga.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the Amadeus database table.
 * 
 */
@Entity
public class Amadeus implements Serializable {
  private static final long serialVersionUID = 1L;

  @Column(name = "CL")
  private String cl;

  @Column(name = "CL_CITY")
  private String clCity;

  @Column(name = "CL_NAME")
  private String clName;

  @Column(name = "NAME")
  private String name;

  @Id
  @Column(name = "SL")
  private String sl;

  public Amadeus() {}

  public String getCl() {
    return this.cl;
  }

  public void setCl(String cl) {
    this.cl = cl;
  }

  public String getClCity() {
    return this.clCity;
  }

  public void setClCity(String clCity) {
    this.clCity = clCity;
  }

  public String getClName() {
    return this.clName;
  }

  public void setClName(String clName) {
    this.clName = clName;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSl() {
    return this.sl;
  }

  public void setSl(String sl) {
    this.sl = sl;
  }

}
