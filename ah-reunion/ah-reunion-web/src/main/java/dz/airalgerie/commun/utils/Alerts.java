/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.commun.utils;

import static dz.airalgerie.commun.utils.ErpConstante.GlobalResources.RESOURCES_PACKAGE;
import java.io.Serializable;
import java.text.MessageFormat;
import java.util.ResourceBundle;
import org.omnifaces.util.Faces;

/**
 *
 * @author Administrateur
 */
public class Alerts implements Serializable {

  private static final long serialVersionUID = 1L;

  private final String SUCCESS_MESSAGE = "Succès !";
  private final String ERROR_MESSAGE = "Erreur !";
  private final String WARNING_MESSAGE = "Attention !";

  private final String ERROR_CLASS = "danger";
  private final String SUCCESS_CLASS = "success";
  private final String WARNING_CLASS = "warning";
  private final String INFO_CLASS = "info";

  private String message;
  private String type;
  private String summary;
  private String styleClass;
  private String icon;
  private String iconStyleClass;
  private boolean active;

  public Alerts() {
    this.hide();
  }

  public Alerts(String message) {
    type = "Danger";
    this.message = message;
    this.styleClass = ERROR_CLASS;
    this.iconStyleClass = this.styleClass;
  }

  public Alerts(String message, String type, String summary) {
    this.message = message;
    this.type = type;
    this.summary = summary;
    this.styleClass = ERROR_CLASS;
    this.iconStyleClass = this.styleClass;
  }

  public Alerts(String message, String type, String summary, String styleClass) {
    this.message = message;
    this.type = type;
    this.summary = summary;
    this.styleClass = styleClass;
    this.iconStyleClass = this.styleClass;
  }

  public Alerts(String message, String type, String summary, String styleClass, String icon) {
    this.message = message;
    this.type = type;
    this.summary = summary;
    this.styleClass = styleClass;
    this.icon = icon;
    this.iconStyleClass = this.styleClass;
  }

  public void addWarning(String message) {
    this.addWarning(message, WARNING_MESSAGE);
  }
  
  public void addWarning(String message, String summary, Object... params) {
    this.setMessage(formatMessage(message, params));
    this.setType("warning");
    this.setSummary(summary);
    this.setStyleClass(WARNING_CLASS);
    this.setIcon("info");
    this.setIconStyleClass(WARNING_CLASS);
    this.show();
  }

  public void addSuccess(String message) {
    this.addSuccess(message, SUCCESS_MESSAGE);
  }

  public void addSuccess(String message, String summary, Object... params) {
    this.setMessage(formatMessage(message, params));
    this.setType("success");
    this.setSummary(summary);
    this.setStyleClass(SUCCESS_CLASS);
    this.setIcon("check");
    this.setIconStyleClass(SUCCESS_CLASS);
    this.show();
  }

  public void addError(String message) {
    this.addError(message, ERROR_MESSAGE);
  }

  public void addError(String message, String summary, Object... params) {
    this.setMessage(formatMessage(message, params));
    this.setType("danger");
    this.setSummary(summary);
    this.setStyleClass(ERROR_CLASS);
    this.setIcon("close");
    this.setIconStyleClass(ERROR_CLASS);
    this.show();
  }

  public void addInformation(String message, String summary, Object... params) {
    this.setMessage(formatMessage(message, params));
    this.setType("info");
    this.setSummary(summary);
    this.setStyleClass(INFO_CLASS);
    this.setIcon("info");
    this.setIconStyleClass("primary");
    this.show();
  }

  /**
   * Permet de rechercher un message par son code et le formatter au besoin.
   * 
   * @param message Message ou code du message à afficher.
   * @param params  Paramètres à remplacer sur le message.
   * @return Le message demandé.
   */
  public static String formatMessage(String message, Object... params) {
    ResourceBundle bundle = ResourceBundle.getBundle(RESOURCES_PACKAGE, Faces.getLocale());
    if (bundle.containsKey(message)) {
      message = bundle.getString(message);
    }

    return params.length > 0 ? MessageFormat.format(message, params) : message;
  }

  public void hide() {
    this.setActive(false);
  }

  public void show() {
    this.setActive(true);
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getSummary() {
    return summary;
  }

  public void setSummary(String summary) {
    this.summary = summary;
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

  public String getIconStyleClass() {
    return iconStyleClass;
  }

  public void setIconStyleClass(String iconStyleClass) {
    this.iconStyleClass = iconStyleClass;
  }

  public boolean isActive() {
    return active;
  }

  public void setActive(boolean active) {
    this.active = active;
  }

}
