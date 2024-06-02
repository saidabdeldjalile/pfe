/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.commun.exception.mail;

/**
 *
 */
public class InvalidAddressException extends MailException {

  public InvalidAddressException() {
    super();
  }

  public InvalidAddressException(String message) {
    super(message);
  }

  public InvalidAddressException(String message, Throwable cause) {
    super(message, cause);
  }

  public InvalidAddressException(Throwable cause) {
    super(cause);
  }

}
