/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.gfc.model.entities.cg;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author kehli
 */
@Entity
@Table(name = "PAGE_JOURNAL", schema = "CF")
@XmlRootElement
public class PageJournal implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @NotNull
  @Column(name = "ID")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  @NotNull
  @Column(name = "DATE_TRT")
  private Integer dateTrt;
  @NotNull
  @Size(max = 2)
  @Column(name = "NUM_JOURANL")
  private String numJournal;
  @NotNull
  @Column(name = "NUM_PAGE")
  private Integer numPage;
  @NotNull
  @Column(name = "MATRICULE")
  private Integer matricule;

  public PageJournal() {
    this.id = 0;
  }

  public PageJournal(Integer id, Integer dateTrt, String numJournal, Integer numPage,
      Integer matricule) {
    this.id = id;
    this.dateTrt = dateTrt;
    this.numJournal = numJournal;
    this.numPage = numPage;
    this.matricule = matricule;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getDateTrt() {
    return dateTrt;
  }

  public void setDateTrt(Integer dateTrt) {
    this.dateTrt = dateTrt;
  }

  public String getNumJournal() {
    return numJournal;
  }

  public void setNumJournal(String numJournal) {
    this.numJournal = numJournal;
  }

  public Integer getNumPage() {
    return numPage;
  }

  public void setNumPage(Integer numPage) {
    this.numPage = numPage;
  }

  public Integer getMatricule() {
    return matricule;
  }

  public void setMatricule(Integer matricule) {
    this.matricule = matricule;
  }

}
