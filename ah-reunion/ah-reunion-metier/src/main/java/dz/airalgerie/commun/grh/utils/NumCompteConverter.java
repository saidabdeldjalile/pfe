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
@FacesConverter("numCompteConverter")
public class NumCompteConverter implements Converter {

  @Override
  public Object getAsObject(FacesContext context, UIComponent component, String value) {
    throw new UnsupportedOperationException("Not supported yet."); // To change body of generated
                                                                   // methods, choose Tools |
                                                                   // Templates.
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
            ((String) value).replaceFirst("(\\d{3})(\\d{5})(\\d{10})(\\d{2})", "$1 - $2 - $3 - $4");
      }
    }
    return returnValue;
  }

}
