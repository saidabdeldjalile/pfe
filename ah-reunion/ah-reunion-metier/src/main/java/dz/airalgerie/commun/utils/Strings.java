/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.commun.utils;

import java.util.Objects;

/**
 *
 */
public class Strings {

  /**
   * Renvoie <i>VRAI</i> lorsque la chaine est NULL ou vide.
   * 
   * @param string Chaine de caractères à tester.
   * @return TRUE ou FALSE.
   */
  public static boolean isNullOrBlank(final String string) {
    return string == null || string.trim().isEmpty();
  }

  /**
   * Renvoie <i>VRAI</i> lorsque {@code string1} est égal à {@code string2}.
   * 
   * @param string1 chaine 1.
   * @param string2 chaine 2.
   * @return TRUE ou FALSE.
   */
  public static boolean equalsIgnoreCaseWithTrim(final String string1, final String string2) {
    if (string1 == null || string2 == null) {
      return Objects.equals(string1, string2);
    }
    return string1.trim().equalsIgnoreCase(string2.trim());
  }

}
