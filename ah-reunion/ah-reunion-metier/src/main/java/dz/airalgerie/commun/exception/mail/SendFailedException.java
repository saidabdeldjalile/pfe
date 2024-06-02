/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.commun.exception.mail;

/**
 *
 */
public class SendFailedException extends MailException {

  public SendFailedException() {
  }

  public SendFailedException(String message) {
    super(message);
  }

  public SendFailedException(String message, Throwable cause) {
    super(message, cause);
  }

  public SendFailedException(Throwable cause) {
    super(cause);
  }

}
