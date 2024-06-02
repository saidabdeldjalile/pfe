/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.commun.exception;

/**
 *
 * @author AGHA Riadh
 */
public class InvalideInscriptionPortaillException extends CustomException {

  private static final long serialVersionUID = 1L;

  public InvalideInscriptionPortaillException() {
    super();
  }

  public InvalideInscriptionPortaillException(String msg) {
    super(msg);
  }

  public InvalideInscriptionPortaillException(Exception e) {
    super(e);
  }

}
