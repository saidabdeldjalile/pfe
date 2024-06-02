/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.commun.grh.utils;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Administrateur
 */
@FacesConverter("numSSConverter")
public class NumSSConverter implements Converter {

  @Override
  public Object getAsObject(FacesContext context, UIComponent component, String value) {
    if (value == null) {
      return "";
    }
    return value.replaceAll(" - ", "");
  }

  @Override
  public String getAsString(FacesContext context, UIComponent component, Object value) {
    String returnValue = null;
    if (value != null) {
      if (value instanceof Integer) {
        if (value.equals(0)) {
          returnValue = "";
        }
      }
      if (returnValue == null) {
        returnValue =
            ((String) value).replaceFirst("(\\d{2})(\\d{4})(\\d{4})(\\d{2})", "$1 - $2 - $3 - $4");
      }
    }
    return returnValue;
  }
}
