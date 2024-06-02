/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.commun.administration.bean;

import dz.airalgerie.commun.bean.core.AbstractBeanManager;
import dz.airalgerie.commun.bean.core.AbstractLazyDataModel;
import dz.airalgerie.commun.exception.CustomException;
import dz.airalgerie.commun.facade.RefManagerFacade;
import dz.airalgerie.commun.model.utils.QueryResult;
import dz.airalgerie.commun.ref.entities.RefGroupe;
import dz.airalgerie.commun.ref.entities.RefUser;
import dz.airalgerie.commun.utils.ErpConstante;
import dz.airalgerie.commun.utils.PasswordHash;
import dz.airalgerie.commun.utils.UserRole;
import java.util.HashSet;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 */
@Named(value = "appUserBean")
@ViewScoped
public class AppUserBean extends AbstractBeanManager {

  private static final long serialVersionUID = 1L;

  @EJB
  private RefManagerFacade refManagerFacade;

  private AbstractLazyDataModel<RefUser> userModel;

  private RefUser user;
  private RefGroupe groupe;

  private boolean editMode = false;
  private boolean resetPassword = false;

  private String value;

  private Integer valueMode;

  private UserRole[] userRoles;

  @PostConstruct
  public void init() {
    findUsers();
  }

  /**
   * Recherche des utilisateurs.
   */
  public void findUsers() {

    userModel = new AbstractLazyDataModel<RefUser>() {
      private static final long serialVersionUID = 1L;

      @Override
      public QueryResult<RefUser> findResult(boolean changed, int first, int pageSize,
          String sortField, Boolean sortOrder, Map<String, Object> filters) {

        return refManagerFacade.findPaginatedUsers(changed, first, pageSize, sortField, sortOrder,
            filters);
      }

    };
  }

  /**
   * Permet la sauvegrde des modifications pour un user.
   */
  public void saveUser() {
    try {
      String message = "";
      String password = "";
      if (resetPassword) {
        password = PasswordHash.generatePassword();
        user.setMotDePasse(password);
      }
      if (!editMode) {
        message = "L'utilisateur a été ajouté avec succès. User : <b>" + user.getLogin()
            + "</b> Mot de passe : <b>" + user.getMotDePasse() + "</b>";
      } else if (resetPassword) {
        message = "Le mot de passe de l'utilisateur <b>" + user.getLogin()
            + "</b> a été été réinitialisé avec succès. Nouveau mot de passe : <b>"
            + user.getMotDePasse() + "</b>";
      } else {
        message = "L'utilisateur a été modifié avec succès.";
      }
      refManagerFacade.saveUser(user, !editMode, resetPassword, userBean.getRefUser());

      alertBean.getAlerts().addSuccess(message);
      user = null;
      findUsers();
      editMode = false;
    } catch (CustomException e) {
      alertBean.getAlerts().addError(e.getMessage());
      FacesContext.getCurrentInstance().validationFailed();
    } catch (Exception e) {
      alertBean.getAlerts().addError(e.getMessage());
      FacesContext.getCurrentInstance().validationFailed();
    }
  }

  /**
   * Permet la suppression d'un utilisateur.
   */
  public void deleteUser() {
    try {
      if (user != null) {
        user = refManagerFacade.findUserByMatricule(user.getMatricule());
        refManagerFacade.deleteUser(user, userBean.getRefUser());
      }

      alertBean.getAlerts().addSuccess("Le user a été supprimé avec succès.");
      user = null;
      findUsers();
    } catch (Exception e) {
      alertBean.getAlerts().addError(e.getMessage());
      FacesContext.getCurrentInstance().validationFailed();
    }
  }

  /**
   * Initialise la réinitialisation de mot de passe.
   */
  public void resetPassword() {
    resetEdit();
    resetPassword = true;
  }

  /**
   * Initialise l'ajout d'utilisateur.
   */
  public void resetAdd() {
    editMode = false;
    resetPassword = true;
    valueMode = 0;

    user = new RefUser();
    user.initConstraints();
    user.setRefGroupeSet(new HashSet<>());
  }

  /**
   * Initialise la modification d'utilisateur.
   */
  public void resetEdit() {
    editMode = true;
    resetPassword = false;
    valueMode = 0;

    user = refManagerFacade.findUserByMatricule(user.getMatricule());
  }

  /**
   * Initialise l'ajout de contrainte.
   */
  public void resetValue() {
    value = "";
  }

  /**
   * Permet d'ajouter une contrainte.
   */
  public void addValue() {
    switch (valueMode) {
      case 1:
        user.getFilialeAutorisee().add(value);
        break;
      case 2:
        user.getDirectionAutorisee().add(value);
        break;
      case 3:
        user.getGroupeAutorise().add(value);
        break;
      case 4:
        user.getTechAutorisee().add(value);
        break;
      case 5:
        user.getAgenceAutorisee().add(value);
        break;
      case 6:
        user.getJournalAutorise().add(value);
        break;
    }
  }

  /**
   * Permet la suppression de contrainte.
   */
  public void deleteValue() {
    switch (valueMode) {
      case 1:
        user.getFilialeAutorisee().remove(value);
        break;
      case 2:
        user.getDirectionAutorisee().remove(value);
        break;
      case 3:
        user.getGroupeAutorise().remove(value);
        break;
      case 4:
        user.getTechAutorisee().remove(value);
        break;
      case 5:
        user.getAgenceAutorisee().remove(value);
        break;
      case 6:
        user.getJournalAutorise().remove(value);
        break;
    }
  }

  /**
   * Initialise l'ajout de groupe.
   */
  public void resetAddGroupe() {
    groupe = null;

    if (user.getRefGroupeSet() == null) {
      user.setRefGroupeSet(new HashSet<>());
    }
  }

  /**
   * Permet d'ajouter un groupe.
   */
  public void addGroupe() {
    try {
      user.addGroupe(groupe);
      resetAddGroupe();
    } catch (Exception e) {
      alertBean.getAlerts().addError(e.getMessage());
      FacesContext.getCurrentInstance().validationFailed();
    }
  }

  /**
   * Permet la suppression de groupe.
   */
  public void deleteGroupe() {
    try {
      user.deleteGroupe(groupe);
    } catch (Exception e) {
      alertBean.getAlerts().addError(e.getMessage());
      FacesContext.getCurrentInstance().validationFailed();
    }
  }

  /**
   * Creates a new instance of AppUserBean
   */
  public AppUserBean() {
    super();
  }

  public AbstractLazyDataModel<RefUser> getUserModel() {
    return userModel;
  }

  public void setUserModel(AbstractLazyDataModel<RefUser> userModel) {
    this.userModel = userModel;
  }

  public RefUser getUser() {
    return user;
  }

  public void setUser(RefUser user) {
    this.user = user;
  }

  public RefGroupe getGroupe() {
    return groupe;
  }

  public void setGroupe(RefGroupe groupe) {
    this.groupe = groupe;
  }

  public boolean isEditMode() {
    return editMode;
  }

  public void setEditMode(boolean editMode) {
    this.editMode = editMode;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  public Integer getValueMode() {
    return valueMode;
  }

  public void setValueMode(Integer valueMode) {
    this.valueMode = valueMode;
  }

  public UserRole[] getUserRoles() {
    return UserRole.values();
  }

}
