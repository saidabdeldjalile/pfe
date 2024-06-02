
package dz.airalgerie.commun.gfc.syga.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the SAGE database table.
 * 
 */
@Entity
@Table(name = "SAGE")
public class Sage implements Serializable {
  private static final long serialVersionUID = 1L;

  @Column(name = "[Code Journal SAGE]")
  private String code_Journal_SAGE;

  @Column(name = "[Code Journal Syga]")
  private double code_Journal_Syga;

  @Column(name = "code_iata")
  private int codeIata;

  @Id
  private int id;

  @Column(name = "[Libellé Ecriture]")
  private String libelleEcriture;

  @Column(name = "[N° compte General]")
  private double n__compte_General;

  @Column(name = "[N° Cpte tiers]")
  private String n__Cpte_tiers;

  @Column(name = "[N° Section]")
  private double n__Section;

  @Column(name = "Position")
  private String position;

  @Column(name = "type")
  private String type;

  public Sage() {}

  public String getCode_Journal_SAGE() {
    return this.code_Journal_SAGE;
  }

  public void setCode_Journal_SAGE(String code_Journal_SAGE) {
    this.code_Journal_SAGE = code_Journal_SAGE;
  }

  public double getCode_Journal_Syga() {
    return this.code_Journal_Syga;
  }

  public void setCode_Journal_Syga(double code_Journal_Syga) {
    this.code_Journal_Syga = code_Journal_Syga;
  }

  public int getCodeIata() {
    return this.codeIata;
  }

  public void setCodeIata(int codeIata) {
    this.codeIata = codeIata;
  }

  public int getId() {
    return this.id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getLibelleEcriture() {
    return this.libelleEcriture;
  }

  public void setLibelleEcriture(String libelleEcriture) {
    this.libelleEcriture = libelleEcriture;
  }

  public double getN__compte_General() {
    return this.n__compte_General;
  }

  public String getN__compte_General_s() {
    return String.format("%.0f", getN__compte_General());
  }

  public void setN__compte_General(double n__compte_General) {
    this.n__compte_General = n__compte_General;
  }

  public String getN__Cpte_tiers() {
    if (this.n__Cpte_tiers == null)
      return "";
    else
      return this.n__Cpte_tiers;
  }

  public void setN__Cpte_tiers(String n__Cpte_tiers) {
    this.n__Cpte_tiers = n__Cpte_tiers;
  }

  public double getN__Section() {

    return this.n__Section;
  }

  public String getN__Section_s() {

    if (getN__Section() == 0)
      return "";
    else
      return (int) getN__Section() + "";
  }

  public void setN__Section(double n__Section) {
    this.n__Section = n__Section;
  }

  public String getPosition() {
    return this.position;
  }

  public void setPosition(String position) {
    this.position = position;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

}
