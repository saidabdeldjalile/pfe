/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.commun.grh.utils;

import java.io.Serializable;

/**
 *
 * @author Diaf
 */
public class UtilsBulletin implements Serializable {

  private static final long serialVersionUID = 1L;

  public static int getRubriqueBulletinValuePosition(String codeRub, String sens) {
    if (codeRub != null) {
      try {
        if ((codeRub.subSequence(0, 1).equals("0")
            && (sens == null || sens.equals("+") || sens.isEmpty())
            || (codeRub.subSequence(0, 1).equals("1") && (sens != null && sens.equals("+"))))) {
          return 1;
        } else if ((codeRub.subSequence(0, 1).equals("2")
            && (sens == null || sens.equals("+") || sens.isEmpty())
            || (codeRub.subSequence(0, 1).equals("3") && (sens != null && sens.equals("+"))))) {
          return 2;
        } else if ((codeRub.subSequence(0, 1).equals("1")
            && (sens == null || sens.equals("-") || sens.isEmpty())
            || (codeRub.subSequence(0, 1).equals("0") && (sens != null && sens.equals("-"))))) {
          return 3;
        } else {
          return 4;
        }

      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    return 0;
  }
}
