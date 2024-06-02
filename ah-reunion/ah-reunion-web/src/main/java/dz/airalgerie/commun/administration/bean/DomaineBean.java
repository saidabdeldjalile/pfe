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
import dz.airalgerie.commun.ref.entities.RefDomaine;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 */
@Named(value = "domaineBean")
@ViewScoped
public class DomaineBean extends AbstractBeanManager {

  private static final long serialVersionUID = 1L;

  @EJB
  private RefManagerFacade refManagerFacade;

  private AbstractLazyDataModel<RefDomaine> domaineModel;

  private RefDomaine domaine;

  private boolean editMode = false;

  @PostConstruct
  public void init() {
    findDomaines();
  }

  /**
   * Recherche des domaines.
   */
  public void findDomaines() {

    domaineModel = new AbstractLazyDataModel<RefDomaine>() {
      private static final long serialVersionUID = 1L;

      @Override
      public QueryResult<RefDomaine> findResult(boolean changed, int first, int pageSize,
          String sortField, Boolean sortOrder, Map<String, Object> filters) {

        return refManagerFacade.findPaginatedDomaines(changed, first, pageSize, sortField,
            sortOrder, filters);
      }

    };
  }

  public void saveDomaine() {
    try {
      refManagerFacade.saveDomaine(domaine, !editMode, userBean.getRefUser());

      alertBean.getAlerts().addSuccess("Le domaine a été ajouté avec succès.");
      domaine = null;
      findDomaines();
      editMode = false;
    } catch (CustomException e) {
      alertBean.getAlerts().addError(e.getMessage());
      FacesContext.getCurrentInstance().validationFailed();
    } catch (Exception e) {
      alertBean.getAlerts().addError(e.getMessage());
      FacesContext.getCurrentInstance().validationFailed();
    }
  }

  public void deleteDomaine() {
    try {  
      if (domaine != null) {
        refManagerFacade.deleteDomaine(domaine, userBean.getRefUser());
      }

      alertBean.getAlerts().addSuccess("Le domaine a été supprimé avec succès.");
      domaine = null;
      findDomaines();
    } catch (Exception e) {
      alertBean.getAlerts().addError(e.getMessage());
      FacesContext.getCurrentInstance().validationFailed();
    }
  }

  public void resetAdd() {
    editMode = false;

    domaine = new RefDomaine();
  }

  public void resetEdit() {
    editMode = true;
  }

  /**
   * Creates a new instance of DomaineBean
   */
  public DomaineBean() {
    super();
  }

  public AbstractLazyDataModel<RefDomaine> getDomaineModel() {
    return domaineModel;
  }

  public void setDomaineModel(AbstractLazyDataModel<RefDomaine> domaineModel) {
    this.domaineModel = domaineModel;
  }

  public RefDomaine getDomaine() {
    return domaine;
  }

  public void setDomaine(RefDomaine domaine) {
    this.domaine = domaine;
  }

  public boolean isEditMode() {
    return editMode;
  }

  public void setEditMode(boolean editMode) {
    this.editMode = editMode;
  }

}
