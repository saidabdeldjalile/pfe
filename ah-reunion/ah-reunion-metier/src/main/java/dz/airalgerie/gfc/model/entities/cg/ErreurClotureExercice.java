/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.gfc.model.entities.cg;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author kehli
 */
@Entity
@Table(name = "ERR_TRT_CLOTURE", schema = "CG")
public class ErreurClotureExercice implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @Basic(optional = false)
  @NotNull
  @Column(name = "ID")
  private Integer id;

  @Column(name = "ANNEE_TRT")
  private Integer anneeTrt;

  @Size(max = 250)
  @Column(name = "MESSAGE")
  private String message;

  @Column(name = "DATE_ERR")
  @Temporal(TemporalType.TIMESTAMP)
  private Date dateErreur;

  public ErreurClotureExercice() {}

  public ErreurClotureExercice(Integer id, Integer anneeTrt, String message, Date dateErreur) {
    this.id = id;
    this.anneeTrt = anneeTrt;
    this.message = message;
    this.dateErreur = dateErreur;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getAnneeTrt() {
    return anneeTrt;
  }

  public void setAnneeTrt(Integer anneeTrt) {
    this.anneeTrt = anneeTrt;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public Date getDateErreur() {
    return dateErreur;
  }

  public void setDateErreur(Date dateErreur) {
    this.dateErreur = dateErreur;
  }


}
