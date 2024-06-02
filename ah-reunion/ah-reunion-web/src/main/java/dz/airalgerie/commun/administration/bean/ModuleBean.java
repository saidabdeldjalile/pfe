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
import dz.airalgerie.commun.ref.entities.RefModule;
import dz.airalgerie.commun.ref.model.dto.auth.RefModuleDTO;
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
@Named(value = "moduleBean")
@ViewScoped
public class ModuleBean extends AbstractBeanManager {

  private static final long serialVersionUID = 1L;

  @EJB
  private RefManagerFacade refManagerFacade;

  private AbstractLazyDataModel<RefModuleDTO> moduleModel;

  private RefModule module;
  private RefModuleDTO selectedModule;

  private boolean editMode = false;

  @Inject
  private RefHelpersBean refHelpersBean;

  @PostConstruct
  public void init() {
    findModules();
  }

  /**
   * Recherche des modules.
   */
  public void findModules() {

    moduleModel = new AbstractLazyDataModel<RefModuleDTO>() {
      private static final long serialVersionUID = 1L;

      @Override
      public QueryResult<RefModuleDTO> findResult(boolean changed, int first, int pageSize,
          String sortField, Boolean sortOrder, Map<String, Object> filters) {

        return refManagerFacade.findPaginatedModules(changed, first, pageSize, sortField, sortOrder,
            filters);
      }

    };
  }

  public void saveModule() {
    try {

      refManagerFacade.saveModule(module, !editMode, userBean.getRefUser());

      alertBean.getAlerts().addSuccess("Le module a été ajouté avec succès.");
      module = null;
      findModules();
      editMode = false;
    } catch (CustomException e) {
      alertBean.getAlerts().addError(e.getMessage());
      FacesContext.getCurrentInstance().validationFailed();
    } catch (Exception e) {
      alertBean.getAlerts().addError(e.getMessage());
      FacesContext.getCurrentInstance().validationFailed();
    }
  }

  public void deleteModule() {
    try {
      if (selectedModule != null) {
        refManagerFacade.deleteModuleById(selectedModule.getId(), userBean.getRefUser());
      }

      alertBean.getAlerts().addSuccess("Le module a été supprimé avec succès.");
      module = null;
      findModules();
    } catch (Exception e) {
      alertBean.getAlerts().addError(e.getMessage());
      FacesContext.getCurrentInstance().validationFailed();
    }
  }

  public void resetAdd() {
    editMode = false;

    module = new RefModule();

    refHelpersBean.initDomaines();
  }

  public void resetEdit() {
    editMode = true;

    if (selectedModule != null) {
      module = refManagerFacade.findModuleById(selectedModule.getId());

      refHelpersBean.setModulesList(new ArrayList<>());
      if (module.getRefModuleParent() != null) {
        refHelpersBean.getModulesList().add(module.getRefModuleParent());
      }
    }

    refHelpersBean.initDomaines();
  }

  /**
   * Creates a new instance of ModuleBean
   */
  public ModuleBean() {
    super();
  }

  public AbstractLazyDataModel<RefModuleDTO> getModuleModel() {
    return moduleModel;
  }

  public void setModuleModel(AbstractLazyDataModel<RefModuleDTO> moduleModel) {
    this.moduleModel = moduleModel;
  }

  public RefModule getModule() {
    return module;
  }

  public void setModule(RefModule module) {
    this.module = module;
  }

  public RefModuleDTO getSelectedModule() {
    return selectedModule;
  }

  public void setSelectedModule(RefModuleDTO selectedModule) {
    this.selectedModule = selectedModule;
  }

  public boolean isEditMode() {
    return editMode;
  }

  public void setEditMode(boolean editMode) {
    this.editMode = editMode;
  }

  public RefHelpersBean getRefHelpersBean() {
    return refHelpersBean;
  }

  public void setRefHelpersBean(RefHelpersBean refHelpersBean) {
    this.refHelpersBean = refHelpersBean;
  }

}
