/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.commun.helpers.beans;

import dz.airalgerie.commun.bean.core.AbstractBeanManager;
import dz.airalgerie.commun.facade.RefManagerFacade;
import dz.airalgerie.commun.ref.entities.RefDomaine;
import dz.airalgerie.commun.ref.entities.RefFonction;
import dz.airalgerie.commun.ref.entities.RefGroupe;
import dz.airalgerie.commun.ref.entities.RefModule;
import dz.airalgerie.commun.ref.entities.RefPermission;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 */
@Named(value = "refHelpersBean")
@SessionScoped
public class RefHelpersBean extends AbstractBeanManager {

  private static final long serialVersionUID = 1L;

  @EJB
  private RefManagerFacade refManagerFacade;

  private List<RefModule> modulesList;
  private List<RefFonction> fonctionsList;
  private List<RefDomaine> domainesList;
  private List<RefPermission> permissionsList;
  private List<RefGroupe> groupesList;

  /**
   * Permet de chercher la liste des domaines.
   */
  public void initDomaines() {
    if (domainesList == null) {
      domainesList = refManagerFacade.findAllOrderByRang();
    }
  }

  /**
   * Permet de faire une recherche par autocomplétion des modules.
   *
   * @param query Paramètre recherché.
   * 
   * @return Liste des modules correspondants au termes.
   */
  public List<RefModule> autoCompleteModules(String query) {
    modulesList = refManagerFacade.findAutoCompleteModules(query);
    if (modulesList == null) {
      modulesList = new ArrayList<>();
    }

    return modulesList;
  }

  /**
   * Permet de faire une recherche par autocomplétion des fonctions.
   *
   * @param query Paramètre recherché.
   * 
   * @return Liste des modules correspondants au termes.
   */
  public List<RefFonction> autoCompleteFonctions(String query) {
    fonctionsList = refManagerFacade.findAutoCompleteFonctions(query);
    if (fonctionsList == null) {
      fonctionsList = new ArrayList<>();
    }

    return fonctionsList;
  }

  /**
   * Permet de faire une recherche par autocomplétion des permissions.
   *
   * @param query Paramètre recherché.
   * 
   * @return Liste des modules correspondants au termes.
   */
  public List<RefPermission> autoCompletePermissions(String query) {
    permissionsList = refManagerFacade.findAutoCompletePermissions(query);
    if (permissionsList == null) {
      permissionsList = new ArrayList<>();
    }

    return permissionsList;
  }

  /**
   * Permet de faire une recherche par autocomplétion des groupes.
   *
   * @param query Paramètre recherché.
   * 
   * @return Liste des groupes correspondants au termes.
   */
  public List<RefGroupe> autoCompleteGroupes(String query) {
    groupesList = refManagerFacade.findAutoCompleteGroupes(query);
    if (groupesList == null) {
      groupesList = new ArrayList<>();
    }

    return groupesList;
  }

  /**
   * Creates a new instance of RefHelpersBean
   */
  public RefHelpersBean() {
    super();
  }

  public List<RefModule> getModulesList() {
    return modulesList;
  }

  public void setModulesList(List<RefModule> modulesList) {
    this.modulesList = modulesList;
  }

  public List<RefFonction> getFonctionsList() {
    return fonctionsList;
  }

  public void setFonctionsList(List<RefFonction> fonctionsList) {
    this.fonctionsList = fonctionsList;
  }

  public List<RefDomaine> getDomainesList() {
    return domainesList;
  }

  public void setDomainesList(List<RefDomaine> domainesList) {
    this.domainesList = domainesList;
  }

  public List<RefPermission> getPermissionsList() {
    return permissionsList;
  }

  public void setPermissionsList(List<RefPermission> permissionsList) {
    this.permissionsList = permissionsList;
  }

  public List<RefGroupe> getGroupesList() {
    return groupesList;
  }

  public void setGroupesList(List<RefGroupe> groupesList) {
    this.groupesList = groupesList;
  }
}

