/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.commun.bean.core.utils;

import dz.airalgerie.commun.utils.Alerts;
import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author user
 */
@Named(value = "alertBean")
@RequestScoped
public class AlertBean implements Serializable {

  private static final long serialVersionUID = 1L;

  private Alerts alerts = new Alerts();

  /**
   * Creates a new instance of AlertBean
   */
  public AlertBean() {
    // Bean consturtor.
  }

  public Alerts getAlerts() {
    return alerts;
  }

  public void setAlerts(Alerts alerts) {
    this.alerts = alerts;
  }

}
