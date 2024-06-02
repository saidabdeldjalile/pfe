/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.commun.utils;

import java.io.Serializable;

/**
 *
 */
public class Notification implements Serializable {

  private static final long serialVersionUID = 1L;

  public static final String INFO_CLASS = "primary";
  public static final String ERROR_CLASS = "danger";
  public static final String SUCCESS_CLASS = "success";
  public static final String WARNING_CLASS = "warning";

  public static final String INFO_ICON = "info";
  public static final String ERROR_ICON = "close";
  public static final String SUCCESS_ICON = "check";
  public static final String WARNING_ICON = "exclamation";

  private String message;
  private String styleClass;
  private String icon;

  public Notification() {}

  public Notification(String message) {
    this.message = message;
  }

  public Notification(String message, String styleClass, String icon) {
    this.message = message;
    this.styleClass = styleClass;
    this.icon = icon;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public String getStyleClass() {
    return styleClass;
  }

  public void setStyleClass(String styleClass) {
    this.styleClass = styleClass;
  }

  public String getIcon() {
    return icon;
  }

  public void setIcon(String icon) {
    this.icon = icon;
  }

}
