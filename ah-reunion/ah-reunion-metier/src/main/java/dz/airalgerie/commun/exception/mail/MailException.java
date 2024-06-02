/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.commun.exception.mail;

/**
 *
 */
public class MailException extends RuntimeException {

  public MailException() {
  }

  public MailException(String message) {
    super(message);
  }

  public MailException(String message, Throwable cause) {
    super(message, cause);
  }

  public MailException(Throwable cause) {
    super(cause);
  }

}
