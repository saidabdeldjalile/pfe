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
import dz.airalgerie.commun.ref.entities.RefPermission;
import dz.airalgerie.commun.utils.ErpConstante;
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
@Named(value = "groupeBean")
@ViewScoped
public class GroupeBean extends AbstractBeanManager {

  private static final long serialVersionUID = 1L;

  @EJB
  private RefManagerFacade refManagerFacade;

  private AbstractLazyDataModel<RefGroupe> groupeModel;

  private RefGroupe groupe;
  private RefPermission permission;

  private boolean editMode = false;

  @PostConstruct
  public void init() {
    findGroupes();
  }

  /**
   * Recherche des groupes.
   */
  public void findGroupes() {

    groupeModel = new AbstractLazyDataModel<RefGroupe>() {
      private static final long serialVersionUID = 1L;

      @Override
      public QueryResult<RefGroupe> findResult(boolean changed, int first, int pageSize,
          String sortField, Boolean sortOrder, Map<String, Object> filters) {

        return refManagerFacade.findPaginatedGroupes(changed, first, pageSize, sortField, sortOrder,
            filters);
      }

    };
  }

  public void saveGroupe() {
    try {

      refManagerFacade.saveGroupe(groupe, !editMode, userBean.getRefUser());

      alertBean.getAlerts().addSuccess("Le groupe a été ajouté avec succès.");
      groupe = null;
      findGroupes();
      editMode = false;
    } catch (CustomException e) {
      alertBean.getAlerts().addError(e.getMessage());
      FacesContext.getCurrentInstance().validationFailed();
    } catch (Exception e) {
      alertBean.getAlerts().addError(e.getMessage());
      FacesContext.getCurrentInstance().validationFailed();
    }
  }

  public void deleteGroupe() {
    try {
      if (groupe != null) {
        refManagerFacade.deleteGroupe(groupe, userBean.getRefUser());
      }

      alertBean.getAlerts().addSuccess("Le groupe a été supprimé avec succès.");
      groupe = null;
      findGroupes();
    } catch (Exception e) {
      alertBean.getAlerts().addError(e.getMessage());
      FacesContext.getCurrentInstance().validationFailed();
    }
  }

  public void resetAdd() {
    editMode = false;

    groupe = new RefGroupe();
    groupe.setRefPermissionSet(new HashSet<>());
  }

  public void resetEdit() {
    try {
      editMode = true;

      groupe = refManagerFacade.findGroupeById(groupe.getId());
    } catch (Exception e) {
      alertBean.getAlerts().addError(e.getMessage());
      FacesContext.getCurrentInstance().validationFailed();
    }
  }

  public void resetAddPermission() {
    permission = null;
  }

  public void addPermession() {
    try {
      groupe.addPermission(permission);
    } catch (Exception e) {
      alertBean.getAlerts().addError(e.getMessage());
      FacesContext.getCurrentInstance().validationFailed();
    }
  }

  public void deletePermession() {
    try {
      groupe.deletePermission(permission);
    } catch (Exception e) {
      alertBean.getAlerts().addError(e.getMessage());
      FacesContext.getCurrentInstance().validationFailed();
    }
  }

  /**
   * Creates a new instance of GroupeBean
   */
  public GroupeBean() {
    super();
  }

  public AbstractLazyDataModel<RefGroupe> getGroupeModel() {
    return groupeModel;
  }

  public void setGroupeModel(AbstractLazyDataModel<RefGroupe> groupeModel) {
    this.groupeModel = groupeModel;
  }

  public RefGroupe getGroupe() {
    return groupe;
  }

  public void setGroupe(RefGroupe groupe) {
    this.groupe = groupe;
  }

  public RefPermission getPermission() {
    return permission;
  }

  public void setPermission(RefPermission permission) {
    this.permission = permission;
  }

  public boolean isEditMode() {
    return editMode;
  }

  public void setEditMode(boolean editMode) {
    this.editMode = editMode;
  }

}
