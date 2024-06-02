/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */
package dz.airalgerie.commun.facade;

import dz.airalgerie.commun.exception.CustomException;
import dz.airalgerie.commun.model.utils.QueryResult;
import dz.airalgerie.commun.ref.entities.RefDomaine;
import dz.airalgerie.commun.ref.entities.RefFonction;
import dz.airalgerie.commun.ref.entities.RefGroupe;
import dz.airalgerie.commun.ref.entities.RefModule;
import dz.airalgerie.commun.ref.entities.RefPermission;
import dz.airalgerie.commun.ref.entities.RefUser;
import dz.airalgerie.commun.ref.facade.RefDomaineFacade;
import dz.airalgerie.commun.ref.facade.RefFonctionFacade;
import dz.airalgerie.commun.ref.facade.RefGroupeFacade;
import dz.airalgerie.commun.ref.facade.RefModuleFacade;
import dz.airalgerie.commun.ref.facade.RefPermissionFacade;
import dz.airalgerie.commun.ref.facade.RefUserFacade;
import dz.airalgerie.commun.ref.model.dto.auth.RefFonctionDTO;
import dz.airalgerie.commun.ref.model.dto.auth.RefModuleDTO;
import dz.airalgerie.commun.ref.model.dto.auth.RefPermissionDTO;
import dz.airalgerie.commun.ref.model.dto.auth.RefUserPermissionDTO;
import dz.airalgerie.commun.utils.PasswordHash;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 */
@Stateless
public class RefManagerFacade {

  @EJB
  private RefDomaineFacade refDomaineFacade;
  @EJB
  private RefModuleFacade refModuleFacade;
  @EJB
  private RefFonctionFacade refFonctionFacade;
  @EJB
  private RefPermissionFacade refPermissionFacade;
  @EJB
  private RefGroupeFacade refGroupeFacade;
  @EJB
  private RefUserFacade refUserFacade;
  // @EJB
  // private TraceFacade traceFacade;

  /**
   **********************************************
   * Gestion des Domaines ********************************************
   */
  /**
   * Permet de chercher un domaine à partir de son ID.
   *
   * @param id ID du domaine recherché.
   * 
   * @return L'objet domaine recherché.
   */
  public RefDomaine findDomaineById(Long id) {
    return refDomaineFacade.find(id);
  }

  /**
   * Permet de rechercher tous les domaines, ordonnés par "rang".
   *
   * @return Liste des domaines.
   */
  public List<RefDomaine> findAllOrderByRang() {
    List<RefDomaine> data = refDomaineFacade.findAllOrderByRang();

    if (data == null) {
      data = new ArrayList<>();
    }

    return data;
  }

  /**
   * Permet de rechercher tous les domaines.
   *
   * @return Liste des domaines.
   */
  public List<RefDomaine> findAllDomaines() {
    List<RefDomaine> data = refDomaineFacade.findAll();

    if (data == null) {
      data = new ArrayList<>();
    }

    return data;
  }

  /**
   * Permet de sauvegarder un domaine.
   *
   * @param domaine    Domaine à sauvegarder.
   * @param insertMode Mode d'insertion/modification.
   * @param user       LoggedUser.
   */
  public void saveDomaine(RefDomaine domaine, boolean insertMode, RefUser user) {

    try {
      refDomaineFacade.edit(domaine);

      // TODO: Implémenter le log.
    } catch (CustomException e) {
      throw e;
    } catch (Exception e) {
      throw new CustomException(e);
    }

  }

  /**
   * Permet de supprimer un domaine donné.
   *
   * @param domaine Domaine à supprimer.
   * @param user    LoggedUser.
   */
  public void deleteDomaine(RefDomaine domaine, RefUser user) {
    RefDomaine refDomaine = findDomaineById(domaine.getId());
    refDomaineFacade.remove(refDomaine);

    // TODO: Implémenter le log.
    // traceFacade.addTrace(user.getMatricule(), "DELETE DOMAINE", 1, "", null, "AUTH.REF_DOMAINE",
    // user.getMatricule());
  }

  /**
   * Permet de rechercher tous les domaines, avec pagination.
   *
   * @param changed   Indique si un changement a été effectué et qu'un calcul du nombre de résultats
   *                  doit se faire
   * @param first     Indice du premier résultat de la recherche
   * @param pageSize  Nombre d'enregistrement à chercher par page
   * @param sortField Champ de tri
   * @param sortOrder Ordre de tri
   * @param filters   Filtres à appliquer à la recherche
   * @return
   */
  public QueryResult<RefDomaine> findPaginatedDomaines(boolean changed, int first, int pageSize,
      String sortField, Boolean sortOrder, Map<String, Object> filters) {
    return refDomaineFacade.findPaginatedDomaines(changed, first, pageSize, sortField, sortOrder,
        filters);
  }

  /**
   **********************************************
   * Gestion des Modules *******************************************
   */
  /**
   * Permet de chercher un module à partir de son ID.
   *
   * @param id ID du module recherché.
   * 
   * @return L'objet module recherché.
   */
  public RefModule findModuleById(Long id) {
    return refModuleFacade.find(id);
  }

  /**
   * Permet de rechercher tous les domaines, avec pagination.
   *
   * @param changed   Indique si un changement a été effectué et qu'un calcul du nombre de résultats
   *                  doit se faire
   * @param first     Indice du premier résultat de la recherche
   * @param pageSize  Nombre d'enregistrement à chercher par page
   * @param sortField Champ de tri
   * @param sortOrder Ordre de tri
   * @param filters   Filtres à appliquer à la recherche
   * @return
   */
  public QueryResult<RefModuleDTO> findPaginatedModules(boolean changed, int first, int pageSize,
      String sortField, Boolean sortOrder, Map<String, Object> filters) {
    return refModuleFacade.findPaginatedModules(changed, first, pageSize, sortField, sortOrder,
        filters);
  }

  /**
   * Permet de faire une recherche par autocomplétion des modules.
   *
   * @param query Paramètre recherché.
   * 
   * @return Liste des modules correspondants au termes.
   */
  public List<RefModule> findAutoCompleteModules(String query) {
    List<RefModule> result = refModuleFacade.findAutoCompleteBylibelle(query);

    if (result == null) {
      result = new ArrayList<>();
    }

    return result;
  }

  /**
   * Permet de sauvegarder un module.
   *
   * @param module     Module à sauvegarder.
   * @param insertMode Mode d'insertion/modification.
   * @param user       LoggedUser.
   */
  public void saveModule(RefModule module, boolean insertMode, RefUser user) {

    try {
      if (module.getRefModuleParent() != null) {
        module.setRefDomaine(module.getRefModuleParent().getRefDomaine());
      }

      refModuleFacade.edit(module);

      // TODO: Implémenter le log.
    } catch (CustomException e) {
      throw e;
    } catch (Exception e) {
      throw new CustomException(e);
    }

  }

  /**
   * Permet de supprimer un module donné.
   *
   * @param module Module à supprimer.
   * @param user   LoggedUser.
   */
  public void deleteModule(RefModule module, RefUser user) {
    refModuleFacade.remove(module);

    // TODO: Implémenter le log.
  }

  /**
   * Permet de supprimer un module donné par ID.
   *
   * @param id   ID du module à supprimer.
   * @param user LoggedUser.
   */
  public void deleteModuleById(Long id, RefUser user) {
    RefModule refModule = findModuleById(id);
    deleteModule(refModule, user);

    // TODO: Implémenter le log.
  }

  /**
   * Permet de faire une recherche des modules par domaine
   *
   * @param Domaine Domaine recherché.
   * @return
   */
  public List<RefModule> findModulesDomaine(String Domaine) {
    List<RefModule> result = refModuleFacade.findModuleByDomaine(Domaine);

    if (result == null) {
      result = new ArrayList<>();
    }

    return result;
  }

  /**
   * Permet de faire une recherche des fonctions par modules
   *
   * @param Module Module recherché.
   * @return
   */
  public List<RefFonction> findFunctionDomaine(String Module) {
    List<RefFonction> result = refFonctionFacade.findFunctionByModule(Module);

    if (result == null) {
      result = new ArrayList<>();
    }

    return result;
  }

  /**
   * Permet de faire une recherche des permission par fonction
   *
   * @param Fonction Fonction recherché.
   * @return
   */
  public List<RefPermission> findPermissionDomaine(String Fonction) {
    List<RefPermission> result = refPermissionFacade.findPermissionByFunction(Fonction);

    if (result == null) {
      result = new ArrayList<>();
    }

    return result;
  }


  /**
   * Permet de rechercher les utilisateurs par permission, avec pagination.
   *
   * @param count     Indique si un changement a été effectué et qu'un calcul du nombre de résultats
   *                  doit se faire
   * @param first     Indice du premier résultat de la recherche
   * @param pageSize  Nombre d'enregistrement à chercher par page
   * @param sortField Champ de tri
   * @param sortOrder Ordre de tri
   * @param filters   Filtres à appliquer à la recherche
   * @return
   */
  public QueryResult<RefUserPermissionDTO> findPermissionByFilters(boolean count, int first,
      int pageSize, String sortField, Boolean sortOrder, Map<String, Object> filters) {
    return refPermissionFacade.findPermissionByFilters(count, first, pageSize, sortField, sortOrder,
        filters);
  }

  /**
   * Permet de calculer le nombre des utilisateurs
   *
   * @param id permission recherché.
   * @return
   */
  public int findCountPermission(long id) {
    int result = refPermissionFacade.findCountPermission(id);
    return result;
  }


  /**
   **********************************************
   * Gestion des Fonctions ******************************************
   */
  /**
   * Permet de chercher une fonction à partir de son ID.
   *
   * @param id ID de la fonction recherché.
   * 
   * @return L'objet fonction recherché.
   */
  public RefFonction findFonctionById(Long id) {
    return refFonctionFacade.find(id);
  }

  /**
   * Permet de rechercher toutes les fonctions, avec pagination.
   *
   * @param changed   Indique si un changement a été effectué et qu'un calcul du nombre de résultats
   *                  doit se faire
   * @param first     Indice du premier résultat de la recherche
   * @param pageSize  Nombre d'enregistrement à chercher par page
   * @param sortField Champ de tri
   * @param sortOrder Ordre de tri
   * @param filters   Filtres à appliquer à la recherche
   * @return
   */
  public QueryResult<RefFonctionDTO> findPaginatedFonctions(boolean changed, int first,
      int pageSize, String sortField, Boolean sortOrder, Map<String, Object> filters) {
    return refFonctionFacade.findPaginatedFonctions(changed, first, pageSize, sortField, sortOrder,
        filters);
  }

  /**
   * Permet de faire une recherche par autocomplétion des fonctions.
   *
   * @param query Paramètre recherché.
   * 
   * @return Liste des modules correspondants au termes.
   */
  public List<RefFonction> findAutoCompleteFonctions(String query) {
    List<RefFonction> result = refFonctionFacade.findAutoCompleteBylibelle(query);

    if (result == null) {
      result = new ArrayList<>();
    }

    return result;
  }

  /**
   * Permet de sauvegarder une fonction.
   *
   * @param fonction   Fonction à sauvegarder.
   * @param insertMode Mode d'insertion/modification.
   * @param user       LoggedUser.
   */
  public void saveFonction(RefFonction fonction, boolean insertMode, RefUser user) {

    try {

      refFonctionFacade.edit(fonction);

      // TODO: Implémenter le log.
    } catch (CustomException e) {
      throw e;
    } catch (Exception e) {
      throw new CustomException(e);
    }

  }

  /**
   * Permet de supprimer une fonction donnée.
   *
   * @param fonction Fonction à supprimer.
   * @param user     LoggedUser.
   */
  public void deleteFonction(RefFonction fonction, RefUser user) {
    refFonctionFacade.remove(fonction);

    // TODO: Implémenter le log.
  }

  /**
   * Permet de supprimer une fonction donnée par ID.
   *
   * @param id   ID de la fonction à supprimer.
   * @param user LoggedUser.
   */
  public void deleteFonctionById(Long id, RefUser user) {
    RefFonction refFonction = findFonctionById(id);
    deleteFonction(refFonction, user);
  }

  /**
   **********************************************
   * Gestion des Permissions ******************************************
   */
  /**
   * Permet de chercher une permission à partir de son ID.
   *
   * @param id ID de la permission recherché.
   * 
   * @return L'objet permission recherché.
   */
  public RefPermission findPermissionById(Long id) {
    return refPermissionFacade.find(id);
  }

  /**
   * Permet de rechercher toutes les permissions, avec pagination.
   *
   * @param changed   Indique si un changement a été effectué et qu'un calcul du nombre de résultats
   *                  doit se faire
   * @param first     Indice du premier résultat de la recherche
   * @param pageSize  Nombre d'enregistrement à chercher par page
   * @param sortField Champ de tri
   * @param sortOrder Ordre de tri
   * @param filters   Filtres à appliquer à la recherche
   * @return
   */
  public QueryResult<RefPermissionDTO> findPaginatedPermissions(boolean changed, int first,
      int pageSize, String sortField, Boolean sortOrder, Map<String, Object> filters) {
    return refPermissionFacade.findPaginatedPermissions(changed, first, pageSize, sortField,
        sortOrder, filters);
  }

  /**
   * Permet de faire une recherche par autocomplétion des permissions.
   *
   * @param query Paramètre recherché.
   * 
   * @return Liste des permissions correspondants au termes.
   */
  public List<RefPermission> findAutoCompletePermissions(String query) {
    List<RefPermission> result = refPermissionFacade.findAutoCompleteBylibelle(query);

    if (result == null) {
      result = new ArrayList<>();
    }

    return result;
  }

  /**
   * Permet de sauvegarder une permission.
   *
   * @param permission Permission à sauvegarder.
   * @param insertMode Mode d'insertion/modification.
   * @param user       LoggedUser.
   */
  public void savePermission(RefPermission permission, boolean insertMode, RefUser user) {

    try {

      refPermissionFacade.edit(permission);

      // TODO: Implémenter le log.
    } catch (CustomException e) {
      throw e;
    } catch (Exception e) {
      throw new CustomException(e);
    }

  }

  /**
   * Permet de supprimer une permission donnée.
   *
   * @param permission Permission à supprimer.
   * @param user       LoggedUser.
   */
  public void deletePermission(RefPermission permission, RefUser user) {
    refPermissionFacade.remove(permission);

    // TODO: Implémenter le log.
  }

  /**
   * Permet de supprimer une permission donnée par ID.
   *
   * @param id   ID de la permission à supprimer.
   * @param user LoggedUser.
   */
  public void deletePermissionById(Long id, RefUser user) {
    RefPermission refPermission = findPermissionById(id);
    deletePermission(refPermission, user);
  }

  /**
   **********************************************
   * Gestion des Groupes ******************************************
   */
  /**
   * Permet de chercher un groupe à partir de son ID.
   *
   * @param id ID du groupe recherché.
   * 
   * @return L'objet groupe recherché.
   */
  public RefGroupe findGroupeById(Long id) {
    return refGroupeFacade.find(id);
  }

  /**
   * Permet de rechercher toutes les groupes, avec pagination.
   *
   * @param changed   Indique si un changement a été effectué et qu'un calcul du nombre de résultats
   *                  doit se faire
   * @param first     Indice du premier résultat de la recherche
   * @param pageSize  Nombre d'enregistrement à chercher par page
   * @param sortField Champ de tri
   * @param sortOrder Ordre de tri
   * @param filters   Filtres à appliquer à la recherche
   * @return
   */
  public QueryResult<RefGroupe> findPaginatedGroupes(boolean changed, int first, int pageSize,
      String sortField, Boolean sortOrder, Map<String, Object> filters) {
    return refGroupeFacade.findPaginatedGroupes(changed, first, pageSize, sortField, sortOrder,
        filters);
  }

  /**
   * Permet de faire une recherche par autocomplétion des groupes.
   *
   * @param query Paramètre recherché.
   * 
   * @return Liste des groupes correspondants au termes.
   */
  public List<RefGroupe> findAutoCompleteGroupes(String query) {
    List<RefGroupe> result = refGroupeFacade.findAutoCompleteBylibelle(query);

    if (result == null) {
      result = new ArrayList<>();
    }

    return result;
  }

  /**
   * Permet de sauvegarder un groupe.
   *
   * @param groupe     Groupe à sauvegarder.
   * @param insertMode Mode d'insertion/modification.
   * @param user       LoggedUser.
   */
  public void saveGroupe(RefGroupe groupe, boolean insertMode, RefUser user) {

    try {

      refGroupeFacade.edit(groupe);

      // TODO: Implémenter le log.
    } catch (CustomException e) {
      throw e;
    } catch (Exception e) {
      throw new CustomException(e);
    }

  }

  /**
   * Permet de supprimer un groupe donné.
   *
   * @param groupe Groupe à supprimer.
   * @param user   LoggedUser.
   */
  public void deleteGroupe(RefGroupe groupe, RefUser user) {
    refGroupeFacade.remove(groupe);

    // TODO: Implémenter le log.
  }

  /**
   * Permet de supprimer un groupe donné par ID.
   *
   * @param id   ID du groupe à supprimer.
   * @param user LoggedUser.
   */
  public void deleteGroupeById(Long id, RefUser user) {
    RefGroupe refGroupe = findGroupeById(id);
    deleteGroupe(refGroupe, user);
  }

  /**
   **********************************************
   * Gestion des Users ******************************************
   */
  /**
   * Permet de chercher un user à partir de son matricule.
   *
   * @param matricule Matricule du user recherché.
   * 
   * @return L'objet user recherché.
   */
  public RefUser findUserByMatricule(Integer matricule) {
    return refUserFacade.find(matricule);
  }

  /**
   * Permet de rechercher toutes les users, avec pagination.
   *
   * @param changed   Indique si un changement a été effectué et qu'un calcul du nombre de résultats
   *                  doit se faire
   * @param first     Indice du premier résultat de la recherche
   * @param pageSize  Nombre d'enregistrement à chercher par page
   * @param sortField Champ de tri
   * @param sortOrder Ordre de tri
   * @param filters   Filtres à appliquer à la recherche
   * @return
   */
  public QueryResult<RefUser> findPaginatedUsers(boolean changed, int first, int pageSize,
      String sortField, Boolean sortOrder, Map<String, Object> filters) {
    return refUserFacade.findPaginatedUsers(changed, first, pageSize, sortField, sortOrder,
        filters);
  }

  /**
   * Permet de sauvegarder un user.
   *
   * @param refUser       User à sauvegarder.
   * @param insertMode    Mode d'insertion/modification.
   * @param resetPassword Indique si le mot doit être hasher ou pas.
   * @param user          LoggedUser.
   */
  public void saveUser(RefUser refUser, boolean insertMode, boolean resetPassword, RefUser user) {

    try {

      if (insertMode) {
        if (refUserFacade.checkDuplication(refUser)) {
          throw new CustomException(
              "L'utilisateur existe déjà. Vérifier le matricule ou le login.");
        }
      }

      if (resetPassword) {
        refUser.setMotDePasse(PasswordHash.hash(refUser.getMotDePasse()));
        refUser.setIsPasswordReset(true);
      }

      refUserFacade.edit(refUser);

      // TODO: Implémenter le log.
    } catch (CustomException e) {
      throw e;
    } catch (Exception e) {
      throw new CustomException(e);
    }

  }

  /**
   * Permet de supprimer un groupe donné.
   *
   * @param refUser User à supprimer.
   * @param user    LoggedUser.
   */
  public void deleteUser(RefUser refUser, RefUser user) {
    refUserFacade.remove(refUser);

    // TODO: Implémenter le log.
  }

  /**
   * Permet de supprimer un user donné par ID.
   *
   * @param matricule Matricule du user à supprimer.
   * @param user      LoggedUser.
   */
  public void deleteUserById(Integer matricule, RefUser user) {
    RefUser refUser = findUserByMatricule(matricule);
    deleteUser(refUser, user);
  }
}
