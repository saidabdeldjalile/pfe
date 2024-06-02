/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this
 * license Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package dz.airalgerie.commun.bean.core.el.functions;

import java.time.Duration;
import org.apache.commons.lang3.time.DurationFormatUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 */
public final class DatesUtils {

  static final Logger log = LoggerFactory.getLogger(DatesUtils.class);

  private DatesUtils() {
    // Hide constructor.
  }

  /**
   * Permet de formatter une durée de temps.
   * 
   * @param duration Duration à formatter.
   * @param pattern  Pattern à utiliser.
   * @return La durée temporelle formatée.
   */
  public static String formatDuration(Duration duration, String pattern) {

    try {
      long millis = duration.toMillis();

      String value = DurationFormatUtils.formatDuration(Math.abs(millis), pattern, true);

      if (millis < 0) {
        value = "-" + value;
      }

      return value;
    } catch (Exception e) {
      log.error("Error on formating duration tima.", e);
    }

    return null;
  }

}
