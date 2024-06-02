/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.commun.administration.bean;

import dz.airalgerie.commun.bean.core.AbstractBeanManager;
import dz.airalgerie.commun.bean.core.AbstractLazyDataModel;
import dz.airalgerie.commun.exception.CustomException;
import dz.airalgerie.commun.facade.RefManagerFacade;
import dz.airalgerie.commun.helpers.beans.RefHelpersBean;
import dz.airalgerie.commun.model.utils.QueryResult;
import dz.airalgerie.commun.ref.entities.RefPermission;
import dz.airalgerie.commun.ref.model.dto.auth.RefPermissionDTO;
import dz.airalgerie.commun.utils.ErpConstante;
import java.util.ArrayList;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 */
@Named(value = "permissionBean")
@ViewScoped
public class PermissionBean extends AbstractBeanManager {

  private static final long serialVersionUID = 1L;

  @EJB
  private RefManagerFacade refManagerFacade;

  private AbstractLazyDataModel<RefPermissionDTO> permissionModel;

  private RefPermission permission;
  private RefPermissionDTO selectedPermission;

  private boolean editMode = false;

  @Inject
  private RefHelpersBean refHelpersBean;

  @PostConstruct
  public void init() {
    findPermissions();
  }

  public void savePermission() {
    try {

      refManagerFacade.savePermission(permission, !editMode, userBean.getRefUser());

      alertBean.getAlerts().addSuccess("La permission a été ajoutée avec succès.");
      permission = null;
      findPermissions();
      editMode = false;
    } catch (CustomException e) {
      alertBean.getAlerts().addError(e.getMessage());
      FacesContext.getCurrentInstance().validationFailed();
    } catch (Exception e) {
      alertBean.getAlerts().addError(e.getMessage());
      FacesContext.getCurrentInstance().validationFailed();
    }
  }

  public void deletePermission() {
    try {
      if (selectedPermission != null) {
        refManagerFacade.deletePermissionById(selectedPermission.getId(), userBean.getRefUser());
      }

      alertBean.getAlerts().addSuccess("La permission a été supprimée avec succès.");
      permission = null;
      findPermissions();
    } catch (Exception e) {
      alertBean.getAlerts().addError(e.getMessage());
      FacesContext.getCurrentInstance().validationFailed();
    }
  }

  public void resetAdd() {
    editMode = false;

    permission = new RefPermission();
  }

  public void resetEdit() {
    editMode = true;

    if (selectedPermission != null) {
      permission = refManagerFacade.findPermissionById(selectedPermission.getId());

      refHelpersBean.setFonctionsList(new ArrayList<>());
      if (permission.getRefFonction() != null) {
        refHelpersBean.getFonctionsList().add(permission.getRefFonction());
      }
    }
  }

  /**
   * Recherche des permissions.
   */
  public void findPermissions() {

    permissionModel = new AbstractLazyDataModel<RefPermissionDTO>() {
      private static final long serialVersionUID = 1L;

      @Override
      public QueryResult<RefPermissionDTO> findResult(boolean changed, int first, int pageSize,
          String sortField, Boolean sortOrder, Map<String, Object> filters) {

        return refManagerFacade.findPaginatedPermissions(changed, first, pageSize, sortField,
            sortOrder, filters);
      }

    };
  }

  /**
   * Creates a new instance of PermissionBean
   */
  public PermissionBean() {
    super();
  }

  public AbstractLazyDataModel<RefPermissionDTO> getPermissionModel() {
    return permissionModel;
  }

  public void setPermissionModel(AbstractLazyDataModel<RefPermissionDTO> permissionModel) {
    this.permissionModel = permissionModel;
  }

  public RefPermission getPermission() {
    return permission;
  }

  public void setPermission(RefPermission permission) {
    this.permission = permission;
  }

  public RefPermissionDTO getSelectedPermission() {
    return selectedPermission;
  }

  public void setSelectedPermission(RefPermissionDTO selectedPermission) {
    this.selectedPermission = selectedPermission;
  }

  public boolean isEditMode() {
    return editMode;
  }

  public void setEditMode(boolean editMode) {
    this.editMode = editMode;
  }

}
