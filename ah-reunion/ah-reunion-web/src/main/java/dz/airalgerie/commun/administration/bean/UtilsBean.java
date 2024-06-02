/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.commun.administration.bean;

import java.io.Serializable;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author userAH
 */
@Named(value = "utilsBean")
@ViewScoped
public class UtilsBean implements Serializable {

  private static final long serialVersionUID = 1L;

  public void preRenderView() {
    FacesContext.getCurrentInstance().getExternalContext().getSession(true);
  }

  /**
   * Creates a new instance of utilsBeans
   */
  public UtilsBean() {
    // Bean consturtor.
  }

}
