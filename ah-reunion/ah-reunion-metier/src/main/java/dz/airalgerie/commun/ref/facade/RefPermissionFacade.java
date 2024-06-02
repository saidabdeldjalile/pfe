/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.commun.ref.facade;

import dz.airalgerie.commun.facade.AbstractFacade;
import dz.airalgerie.commun.model.utils.QueryResult;
import dz.airalgerie.commun.ref.entities.RefFonction;
import dz.airalgerie.commun.ref.entities.RefGroupe;
import dz.airalgerie.commun.ref.entities.RefGroupe_;
import dz.airalgerie.commun.ref.entities.RefPermission;
import dz.airalgerie.commun.ref.entities.RefPermission_;
import dz.airalgerie.commun.ref.entities.RefUser;
import dz.airalgerie.commun.ref.model.dto.auth.RefPermissionDTO;
import dz.airalgerie.commun.utils.ErpConstante;
import dz.airalgerie.commun.ref.model.dto.auth.RefUserPermissionDTO;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;

/**
 *
 * @author Sofyane MAKERRI
 */
@Stateless
public class RefPermissionFacade extends AbstractFacade<RefPermission> {

  @PersistenceContext(unitName = ErpConstante.UnitName.REF_PU_NAME)
  private EntityManager em;

  @Override
  protected EntityManager getEntityManager() {
    return em;
  }

  public RefPermissionFacade() {
    super(RefPermission.class);
  }

  public List<RefPermission> findByCodeDomaine(String codeDomaine) {
    if (codeDomaine != null && !codeDomaine.isEmpty()) {
      List<RefPermission> list = em.createQuery(
          "SELECT m FROM RefPermission m where m.isRead = true and m.refFonction.refModule.refDomaine.code =:codeDomaine ",
          RefPermission.class).setParameter("codeDomaine", codeDomaine).getResultList();

      return list;

    }
    return new ArrayList<>();
  }

  public List<RefPermission> findAllPermitted() {
    List<RefPermission> list =
        em.createQuery("SELECT m FROM RefPermission m where m.isRead = true", RefPermission.class)
            .getResultList();

    return list;
  }

  /**
   * Recherche les permissions avec pagination
   *
   * @param count     Permet de calculer le nombe total de résultats.
   * @param first     Indice du premier résultat.
   * @param pageSize  Nombre de lignes d'une page.
   * @param sortField Champ destiné au tri.
   * @param sortOrder Sens du tri.
   * @param filters   Liste des filtres à appliquer sur la recherche.
   * @return
   */
  public QueryResult<RefPermissionDTO> findPaginatedPermissions(boolean count, int first,
      int pageSize, String sortField, Boolean sortOrder, Map<String, Object> filters) {
    CriteriaBuilder cb = em.getCriteriaBuilder();
    CriteriaQuery<RefPermissionDTO> q = cb.createQuery(RefPermissionDTO.class);
    Root<RefPermission> permission = q.from(RefPermission.class);

    Join<RefPermission, RefFonction> fonction = (Join<RefPermission, RefFonction>) permission
        .fetch(RefPermission_.refFonction, JoinType.LEFT);

    Path<?> path = permission;
    q.multiselect(path.get("id"), path.get("name"), path.get("description"), fonction.get("id"),
        fonction.get("code"), path.get("viewAccess"));

    return (QueryResult<RefPermissionDTO>) findPaginated(permission, q, count, first, pageSize,
        sortField, sortOrder, filters);
  }

  /**
   * Permet de faire une recherche par autocomplétion des permissions.
   *
   * @param query Paramètre recherché.
   * 
   * @return Liste des modules correspondants au termes.
   */
  public List<RefPermission> findAutoCompleteBylibelle(String query) {
    return em.createQuery("SELECT p FROM RefPermission p WHERE p.name LIKE :name")
        .setParameter("name", "%" + query + "%").setMaxResults(20).getResultList();
  }

  /**
   * Permet de rechercher les utilisateurs par permission, avec pagination.
   *
   * @param count     Permet de calculer le nombe total de résultats.
   * @param first     Indice du premier résultat.
   * @param pageSize  Nombre de lignes d'une page.
   * @param sortField Champ destiné au tri.
   * @param sortOrder Sens du tri.
   * @param filters   Liste des filtres à appliquer sur la recherche.
   * @return
   */
  public QueryResult<RefUserPermissionDTO> findPermissionByFilters(boolean count, int first,
      int pageSize, String sortField, Boolean sortOrder, Map<String, Object> filters) {
    CriteriaBuilder cb = em.getCriteriaBuilder();
    CriteriaQuery<RefUserPermissionDTO> q = cb.createQuery(RefUserPermissionDTO.class);
    Root<RefPermission> RefPermission = q.from(RefPermission.class);

    Join<RefPermission, RefGroupe> group = (Join<RefPermission, RefGroupe>) RefPermission
        .fetch(RefPermission_.refGroupeSet, JoinType.INNER);

    Join<RefGroupe, RefUser> user =
        (Join<RefGroupe, RefUser>) group.fetch(RefGroupe_.refUserSet, JoinType.INNER);

    Path<?> path = RefPermission;
    q.select(cb.construct(RefUserPermissionDTO.class, user.get("login"), path.get("name"),
        user.get("directionAutorisee")));
    return (QueryResult<RefUserPermissionDTO>) findPaginated(RefPermission, q, count, first,
        pageSize, sortField, sortOrder, filters);
  }

  /**
   * Permet de calculer le nombre des utilisateurs.
   *
   * @param id Paramètre recherché.
   * @return Liste des modules correspondants au termes.
   */
  public int findCountPermission(long id) {
    return (int) em.createNativeQuery(
        "  SELECT COUNT(*)\n" + "  FROM [REF].[AUTH].[USERS_GROUPE] WHERE ID_GROUPE in (\n" + "\n"
            + "  SELECT GP.ID_GROUPE   FROM AUTH.PERMISSION P \n"
            + "  INNER JOIN AUTH.GROUPE_PERMISSION GP ON P.ID = GP.ID_PERMISSION  \n"
            + "  WHERE (ID = ?1)\n" + "  )")
        .setParameter(1, id).getSingleResult();
  }

  /**
   * Permet de faire une recherche des permissions par fonction
   *
   * @param Fonction Paramètre recherché.
   * @return
   */
  public List<RefPermission> findPermissionByFunction(String Fonction) {
    return em.createQuery("SELECT m FROM RefPermission m WHERE m.refFonction.code = :code")
        .setParameter("code", Fonction).getResultList();
  }
}
