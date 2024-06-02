/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.commun.exception;

/**
 *
 */
public class InvalidPasswordException extends CustomException {

  private static final long serialVersionUID = 1L;

  public InvalidPasswordException() {
    super();
  }

  public InvalidPasswordException(String msg) {
    super(msg);
  }

  public InvalidPasswordException(Exception e) {
    super(e);
  }

}
