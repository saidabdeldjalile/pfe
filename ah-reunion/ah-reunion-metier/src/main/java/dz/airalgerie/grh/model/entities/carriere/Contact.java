/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.grh.model.entities.carriere;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Diaf
 */
@Entity
@Table(schema = "CAR", name = "CONTACT")
public class Contact implements Serializable {
  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @NotNull
  @Column(name = "MATRICULE")
  private Integer matricule;

  @Basic(optional = false)
  @Size(min = 0, max = 100)
  @Column(name = "QUATRE_CHIFFRE")
  private String QUATRE_CHIFFRE;

  @Basic(optional = false)
  @Size(min = 0, max = 100)
  @Column(name = "MOBILE")
  private String MOBILE;

  @Basic(optional = false)
  @Size(min = 0, max = 100)
  @Column(name = "LIGNE_IP")
  private String LIGNE_IP;

  @Basic(optional = false)
  @Size(min = 0, max = 100)
  @Column(name = "FAX")
  private String FAX;

  @Basic(optional = false)
  @Size(min = 0, max = 100)
  @Column(name = "LIGNE_DIRECTE")
  private String LIGNE_DIRECTE;

  @Basic(optional = false)
  @Size(min = 0, max = 100)
  @Column(name = "MAIL")
  private String MAIL;

  @Basic(optional = false)
  @Size(min = 0, max = 100)
  @Column(name = "ADRESSE")
  private String ADRESSE;

  @JoinColumn(name = "MATRICULE", referencedColumnName = "MATRICULE", insertable = false,
      updatable = false)
  @OneToOne(optional = false, fetch = FetchType.LAZY)
  private Signalitique signalitique;

  public Signalitique getSignalitique() {
    return signalitique;
  }

  public void setSignalitique(Signalitique signalitique) {
    this.signalitique = signalitique;
  }

  public Integer getMatricule() {
    return matricule;
  }

  public void setMatricule(Integer matricule) {
    this.matricule = matricule;
  }

  public String getQUATRE_CHIFFRE() {
    return QUATRE_CHIFFRE;
  }

  public void setQUATRE_CHIFFRE(String QUATRE_CHIFFRE) {
    this.QUATRE_CHIFFRE = QUATRE_CHIFFRE;
  }

  public String getMOBILE() {
    return MOBILE;
  }

  public void setMOBILE(String MOBILE) {
    this.MOBILE = MOBILE;
  }

  public String getLIGNE_IP() {
    return LIGNE_IP;
  }

  public void setLIGNE_IP(String LIGNE_IP) {
    this.LIGNE_IP = LIGNE_IP;
  }

  public String getFAX() {
    return FAX;
  }

  public void setFAX(String FAX) {
    this.FAX = FAX;
  }

  public String getLIGNE_DIRECTE() {
    return LIGNE_DIRECTE;
  }

  public void setLIGNE_DIRECTE(String LIGNE_DIRECTE) {
    this.LIGNE_DIRECTE = LIGNE_DIRECTE;
  }

  public String getMAIL() {
    return MAIL;
  }

  public void setMAIL(String MAIL) {
    this.MAIL = MAIL;
  }

  public String getADRESSE() {
    return ADRESSE;
  }

  public void setADRESSE(String ADRESSE) {
    this.ADRESSE = ADRESSE;
  }

}
