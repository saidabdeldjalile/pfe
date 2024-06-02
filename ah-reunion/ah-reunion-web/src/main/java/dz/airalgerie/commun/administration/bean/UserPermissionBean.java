/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.commun.administration.bean;

import dz.airalgerie.commun.bean.core.AbstractLazyDataModel;
import dz.airalgerie.commun.facade.RefManagerFacade;
import dz.airalgerie.commun.model.utils.QueryCriteria;
import dz.airalgerie.commun.model.utils.QueryResult;
import dz.airalgerie.commun.ref.entities.RefDomaine;
import dz.airalgerie.commun.ref.entities.RefFonction;
import dz.airalgerie.commun.ref.entities.RefModule;
import dz.airalgerie.commun.ref.entities.RefPermission;
import dz.airalgerie.commun.ref.model.dto.auth.RefUserPermissionDTO;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author hp
 */
@Named(value = "UserPermission")
@ViewScoped
public class UserPermissionBean implements Serializable {
  @EJB
  private RefManagerFacade refManagerFacade;
  private List<RefDomaine> domaines;
  private List<RefModule> modules;
  private List<RefFonction> functions;
  private List<RefPermission> permissions;
  private String domaineSelect;
  private String moduleSelect;
  private String functionSelect;
  private long permissionSelect;
  private AbstractLazyDataModel<RefUserPermissionDTO> permissionModel = null;

  public List<RefDomaine> getDomaines() {
    if (domaines == null) {
      domaines = refManagerFacade.findAllDomaines();
    }
    return domaines;
  }

  public void setDomaines(List<RefDomaine> domaines) {
    this.domaines = domaines;
  }

  public List<RefModule> getModules() {
    modules = refManagerFacade.findModulesDomaine(domaineSelect);
    return modules;
  }

  public void setModules(List<RefModule> modules) {
    this.modules = modules;
  }

  public String getDomaineSelect() {
    return domaineSelect;
  }

  public void setDomaineSelect(String domaineSelect) {
    this.domaineSelect = domaineSelect;
  }

  public String getModuleSelect() {
    return moduleSelect;
  }

  public void setModuleSelect(String moduleSelect) {
    this.moduleSelect = moduleSelect;
  }

  public String getFunctionSelect() {
    return functionSelect;
  }

  public void setFunctionSelect(String FunctionSelect) {
    this.functionSelect = FunctionSelect;
  }

  public long getPermissionSelect() {
    return permissionSelect;
  }

  public void setPermissionSelect(long permissionSelect) {
    this.permissionSelect = permissionSelect;
  }

  public List<RefFonction> getFunctions() {
    functions = refManagerFacade.findFunctionDomaine(moduleSelect);
    return functions;
  }

  public void setFunctions(List<RefFonction> functions) {
    this.functions = functions;
  }

  public List<RefPermission> getPermissions() {
    permissions = refManagerFacade.findPermissionDomaine(functionSelect);
    return permissions;
  }

  public void setPermissions(List<RefPermission> permissions) {
    this.permissions = permissions;
  }

  public AbstractLazyDataModel<RefUserPermissionDTO> getPermissionModel() {
    if (permissionModel != null) {
      int count = refManagerFacade.findCountPermission(permissionSelect);
      permissionModel.setRowCount(count);
    }
    return permissionModel;
  }

  public void setPermissionModel(AbstractLazyDataModel<RefUserPermissionDTO> permissionModel) {
    this.permissionModel = permissionModel;
  }

  /**
   * Permet de rechercher les utilisateurs par permission, avec pagination.
   */
  public void findUserPermission() {
    permissionModel = new AbstractLazyDataModel<RefUserPermissionDTO>() {
      @Override
      public QueryResult<RefUserPermissionDTO> findResult(boolean changed, int first, int pageSize,
          String sortField, Boolean sortOrder, Map<String, Object> filters) {
        QueryCriteria q = new QueryCriteria(permissionSelect, QueryCriteria.EQUALS);
        filters.put("id", q);
        return refManagerFacade.findPermissionByFilters(changed, first, pageSize, sortField,
            sortOrder, filters);
      }
    };
  }
}
