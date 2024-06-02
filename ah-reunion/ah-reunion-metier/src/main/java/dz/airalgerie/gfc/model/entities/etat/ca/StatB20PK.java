/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.gfc.model.entities.etat.ca;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

/**
 *
 * @author Administrateur
 */

@Embeddable
public class StatB20PK implements Serializable {

  @Column(name = "ID")
  @GeneratedValue(strategy = GenerationType.IDENTITY)

  private Integer id;

  public StatB20PK() {}

  public StatB20PK(int id) {
    this.id = id;

  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

}
