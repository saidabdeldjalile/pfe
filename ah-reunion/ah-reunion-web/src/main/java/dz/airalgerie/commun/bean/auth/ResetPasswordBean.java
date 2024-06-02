/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.commun.bean.auth;

import dz.airalgerie.commun.bean.core.AbstractBeanManager;
import dz.airalgerie.commun.exception.InvalidPasswordException;
import dz.airalgerie.commun.facade.CommunManagerFacade;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.inject.Named;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 */
@Named(value = "resetPasswordBean")
@RequestScoped
public class ResetPasswordBean extends AbstractBeanManager {

  private static final long serialVersionUID = 1L;

  @EJB
  private CommunManagerFacade communManagerFacade;

  @NotNull
  @Size(min = 5, max = 50, message = "Le mot de passe doit contenir au moins 8 caractères.")
  private String oldPassword;
  @NotNull
  @Size(min = 8, max = 50, message = "Le mot de passe doit contenir au moins 8 caractères.")
  private String newPassword;
  @NotNull
  @Size(min = 8, max = 50, message = "Le mot de passe doit contenir au moins 8 caractères.")
  private String passwordConfirm;

  public void updatePassword() {

    try {
      if (!newPassword.equals(passwordConfirm)) {
        throw new InvalidPasswordException("Les mots de passe ne sont pas identiques.");
      }

      communManagerFacade.updatePassword(userBean.getRefUser(), oldPassword, newPassword);

      userBean
          .setRefUser(communManagerFacade.findByMatricule(userBean.getRefUser().getMatricule()));

      userBean.initNotifications();

      sendToastr("success", "Félicitations !", "Votre mot de passe a été modifié avec succès.");
    } catch (InvalidPasswordException e) {
      this.sendFacesMessage(e.getMessage(), FacesMessage.SEVERITY_ERROR, false);
      getFacesContext().validationFailed();
    } catch (Exception e) {
      this.sendFacesMessage(e.getMessage(), FacesMessage.SEVERITY_ERROR, false);
      getFacesContext().validationFailed();
    }
  }

  /**
   * Creates a new instance of ResetPasswordBean
   */
  public ResetPasswordBean() {
    super();
  }

  public String getOldPassword() {
    return oldPassword;
  }

  public void setOldPassword(String oldPassword) {
    this.oldPassword = oldPassword;
  }

  public String getNewPassword() {
    return newPassword;
  }

  public void setNewPassword(String newPassword) {
    this.newPassword = newPassword;
  }

  public String getPasswordConfirm() {
    return passwordConfirm;
  }

  public void setPasswordConfirm(String passwordConfirm) {
    this.passwordConfirm = passwordConfirm;
  }

}
