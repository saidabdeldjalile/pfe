/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.ref.model.entities.decision;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author kehli
 */

@Entity
@Table(name = "DECISION", schema = "COM")
@XmlRootElement
public class Decision implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID")
  private Integer id;

  @Basic(optional = false)
  @NotNull
  @Size(max = 50)
  @Column(name = "TYPE")
  private String type;

  @Column(name = "DATE_DECISION")
  @Basic(optional = false)
  @NotNull
  @Temporal(TemporalType.DATE)
  private Date dateDecision;

  @Basic(optional = false)
  @NotNull
  @Size(max = 20)
  @Column(name = "REFERENCE")
  private String reference;

  @Basic(optional = false)
  @NotNull
  @Size(max = 150)
  @Column(name = "OBJET")
  private String objet;

  @Size(max = 4)
  @Column(name = "UNITE")
  private String unite;

  @Size(max = 150)
  @Column(name = "FILENAME")
  private String fileName;

  @Column(name = "MATRICULE")
  private int matricule;

  @Column(name = "DATE_SAISIE")
  @Temporal(TemporalType.TIMESTAMP)
  private Date dateSaisie;

  public Decision() {}

  public Decision(Integer id, String type, Date dateDecision, String reference, String objet,
      String unite, String fileName, int matricule, Date dateSaisie) {
    this.id = id;
    this.type = type;
    this.dateDecision = dateDecision;
    this.reference = reference;
    this.objet = objet;
    this.unite = unite;
    this.fileName = fileName;
    this.matricule = matricule;
    this.dateSaisie = dateSaisie;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getReference() {
    return reference;
  }

  public void setReference(String reference) {
    this.reference = reference;
  }

  public Date getDateDecision() {
    return dateDecision;
  }

  public void setDateDecision(Date dateDecision) {
    this.dateDecision = dateDecision;
  }

  public String getObjet() {
    return objet;
  }

  public void setObjet(String objet) {
    this.objet = objet;
  }

  public String getFileName() {
    return fileName;
  }

  public void setFileName(String fileName) {
    this.fileName = fileName;
  }

  public int getMatricule() {
    return matricule;
  }

  public void setMatricule(int matricule) {
    this.matricule = matricule;
  }

  public Date getDateSaisie() {
    return dateSaisie;
  }

  public void setDateSaisie(Date dateSaisie) {
    this.dateSaisie = dateSaisie;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getUnite() {
    return unite;
  }

  public void setUnite(String unite) {
    this.unite = unite;
  }

}
