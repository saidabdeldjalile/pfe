/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.grh.model.dto.commun;

import java.io.Serializable;

/**
 *
 * @author root
 */
public class DestinationDTO implements Serializable {

  private static final long serialVersionUID = 1L;

  private String from;
  private String at;

  public DestinationDTO() {
  }

  public DestinationDTO(String from, String at) {
    this.from = from;
    this.at = at;
  }

  public String getFrom() {
    return from;
  }

  public void setFrom(String from) {
    this.from = from;
  }

  public String getAt() {
    return at;
  }

  public void setAt(String at) {
    this.at = at;
  }

    @Override
    public String toString() {
        return from + " - " + at + "   ";
    }
}
