/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.commun.ref.facade;

import dz.airalgerie.commun.exception.CustomException;
import dz.airalgerie.commun.facade.AbstractFacade;
import dz.airalgerie.commun.model.utils.QueryResult;
import dz.airalgerie.commun.ref.entities.RefUser;
import dz.airalgerie.commun.utils.ErpConstante;
import dz.airalgerie.commun.utils.PasswordHash;
import java.util.List;
import java.util.Map;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;

/**
 *
 * @author Sofyane MAKERRI
 */
@Stateless
public class RefUserFacade extends AbstractFacade<RefUser> {

  @PersistenceContext(unitName = ErpConstante.UnitName.REF_PU_NAME)
  private EntityManager em;

  @Override
  protected EntityManager getEntityManager() {
    return em;
  }

  public RefUserFacade() {
    super(RefUser.class);
  }

  public RefUser findByLogin(String login) {
    if (login != null && !login.isEmpty()) {
      List<RefUser> list =
          em.createQuery("SELECT u FROM RefUser u where u.login =:login", RefUser.class)
              .setParameter("login", login).getResultList();

      if (list != null && !list.isEmpty()) {
        return list.get(0);
      }

    }
    return null;
  }

  /**
   * Recherche les domaines avec pagination
   *
   * @param count     Permet de calculer le nombe total de résultats.
   * @param first     Indice du premier résultat.
   * @param pageSize  Nombre de lignes d'une page.
   * @param sortField Champ destiné au tri.
   * @param sortOrder Sens du tri.
   * @param filters   Liste des filtres à appliquer sur la recherche.
   * 
   * @return
   */
  public QueryResult<RefUser> findPaginatedUsers(boolean count, int first, int pageSize,
      String sortField, Boolean sortOrder, Map<String, Object> filters) {
    CriteriaBuilder cb = em.getCriteriaBuilder();
    CriteriaQuery<RefUser> q = cb.createQuery(RefUser.class);
    Root<RefUser> user = q.from(RefUser.class);

    Path<?> path = user;
    q.select(cb.construct(RefUser.class, path.get("matricule"), path.get("login")));

    return (QueryResult<RefUser>) findPaginated(user, q, count, first, pageSize, sortField,
        sortOrder, filters);
  }

  /**
   * Permet de vérifier si un utilisateur est déjà présent.
   *
   * @param user : Nouveau utilisateur.
   * 
   * @return
   */
  public boolean checkDuplication(RefUser user) {
    Query query = em
        .createQuery(
            "SELECT COUNT(u) FROM RefUser u WHERE u.matricule = :matricule OR u.login = :login")
        .setParameter("matricule", user.getMatricule()).setParameter("login", user.getLogin());

    Number count = (Number) query.getSingleResult();
    return count.intValue() > 0;
  }

  /**
   * Permet de reinitialiser le mot de passe d'un utilisteur.
   *
   * @param refUser User à sauvegarder.
   */
  public void resetPassword(RefUser refUser) {
    try {
      refUser.setMotDePasse(PasswordHash.hash(refUser.getMotDePasse()));
      refUser.setIsPasswordReset(true);
      this.edit(refUser);
    } catch (CustomException e) {
      throw e;
    } catch (Exception e) {
      throw new CustomException(e);
    }
  }

  public List<Integer> findByRoleName(List<String> roleNames) {
    return em.createQuery(
        "SELECT DISTINCT u.matricule FROM RefUser u LEFT JOIN u.refGroupeSet g LEFT JOIN g.refPermissionSet p WHERE (p.name IN :roleNames)",
        Integer.class).setParameter("roleNames", roleNames)
        .getResultList();
  }

  public List<Integer> findByMatriculesOrRoleName(List<Integer> matricules,
      List<String> roleNames) {
    return em.createQuery(
        "SELECT DISTINCT u.matricule FROM RefUser u LEFT JOIN u.refGroupeSet g LEFT JOIN g.refPermissionSet p WHERE ((u.matricule IN :matricules) OR (p.name IN :roleNames))",
        Integer.class).setParameter("matricules", matricules).setParameter("roleNames", roleNames)
        .getResultList();
  }
}
