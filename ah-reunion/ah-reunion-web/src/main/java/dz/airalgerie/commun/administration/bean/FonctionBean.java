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
import dz.airalgerie.commun.ref.entities.RefFonction;
import dz.airalgerie.commun.ref.model.dto.auth.RefFonctionDTO;
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
@Named(value = "fonctionBean")
@ViewScoped
public class FonctionBean extends AbstractBeanManager {

  private static final long serialVersionUID = 1L;

  @EJB
  private RefManagerFacade refManagerFacade;

  private AbstractLazyDataModel<RefFonctionDTO> fonctionModel;

  private RefFonction fonction;
  private RefFonctionDTO selectedFonction;

  private boolean editMode = false;

  @Inject
  private RefHelpersBean refHelpersBean;

  @PostConstruct
  public void init() {
    findFonctions();
  }

  /**
   * Recherche des fonctions.
   */
  public void findFonctions() {

    fonctionModel = new AbstractLazyDataModel<RefFonctionDTO>() {
      private static final long serialVersionUID = 1L;

      @Override
      public QueryResult<RefFonctionDTO> findResult(boolean changed, int first, int pageSize,
          String sortField, Boolean sortOrder, Map<String, Object> filters) {

        return refManagerFacade.findPaginatedFonctions(changed, first, pageSize, sortField,
            sortOrder, filters);
      }

    };
  }

  public void saveFonction() {
    try {

      refManagerFacade.saveFonction(fonction, !editMode, userBean.getRefUser());

      alertBean.getAlerts().addSuccess("La fonction a été ajoutée avec succès.");
      fonction = null;
      findFonctions();
      editMode = false;
    } catch (CustomException e) {
      alertBean.getAlerts().addError(e.getMessage());
      FacesContext.getCurrentInstance().validationFailed();
    } catch (Exception e) {
      alertBean.getAlerts().addError(e.getMessage());
      FacesContext.getCurrentInstance().validationFailed();
    }
  }

  public void deleteFonction() {
    try {
      if (selectedFonction != null) {
        refManagerFacade.deleteFonctionById(selectedFonction.getId(), userBean.getRefUser());
      }

      alertBean.getAlerts().addSuccess("La fonction a été supprimée avec succès.");
      fonction = null;
      findFonctions();
    } catch (Exception e) {
      alertBean.getAlerts().addError(e.getMessage());
      FacesContext.getCurrentInstance().validationFailed();
    }
  }

  public void resetAdd() {
    editMode = false;

    fonction = new RefFonction();
  }

  public void resetEdit() {
    editMode = true;

    if (selectedFonction != null) {
      fonction = refManagerFacade.findFonctionById(selectedFonction.getId());

      refHelpersBean.setModulesList(new ArrayList<>());
      if (fonction.getRefModule() != null) {
        refHelpersBean.getModulesList().add(fonction.getRefModule());
      }
    }
  }

  /**
   * Creates a new instance of FonctionBean
   */
  public FonctionBean() {
    super();
  }

  public AbstractLazyDataModel<RefFonctionDTO> getFonctionModel() {
    return fonctionModel;
  }

  public void setFonctionModel(AbstractLazyDataModel<RefFonctionDTO> fonctionModel) {
    this.fonctionModel = fonctionModel;
  }

  public RefFonction getFonction() {
    return fonction;
  }

  public void setFonction(RefFonction fonction) {
    this.fonction = fonction;
  }

  public RefFonctionDTO getSelectedFonction() {
    return selectedFonction;
  }

  public void setSelectedFonction(RefFonctionDTO selectedFonction) {
    this.selectedFonction = selectedFonction;
  }

  public boolean isEditMode() {
    return editMode;
  }

  public void setEditMode(boolean editMode) {
    this.editMode = editMode;
  }

}
