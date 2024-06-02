/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.grh.model.entities.carriere;

/**
 * @author DEV
 */
/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */
import java.io.Serializable;

/**
 *
 * @author DEV
 */
public class Ent implements Serializable {

  private String name;
  private int date;

  public Ent() {}

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getDate() {
    return date;
  }

  public void setDate(int date) {
    this.date = date;
  }
}
