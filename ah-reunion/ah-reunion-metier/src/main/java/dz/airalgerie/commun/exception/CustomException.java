/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.commun.exception;

import javax.ejb.ApplicationException;
import javax.ejb.EJBException;

/**
 *
 * @author Administrateur
 */
@ApplicationException(rollback = true)
public class CustomException extends EJBException {

  private static final long serialVersionUID = 1L;

  public CustomException() {
    super();
  }

  public CustomException(String msg) {
    super(msg);
  }

  public CustomException(Exception e) {
    super(e);
  }

}
