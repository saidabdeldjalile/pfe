/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.commun.ref.facade;

import dz.airalgerie.commun.facade.AbstractFacade;
import dz.airalgerie.commun.model.utils.QueryResult;
import dz.airalgerie.commun.ref.entities.RefGroupe;
import dz.airalgerie.commun.utils.ErpConstante;
import java.util.List;
import java.util.Map;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;

/**
 *
 */
@Stateless
public class RefGroupeFacade extends AbstractFacade<RefGroupe> {

  @PersistenceContext(unitName = ErpConstante.UnitName.REF_PU_NAME)
  private EntityManager em;

  @Override
  protected EntityManager getEntityManager() {
    return em;
  }

  public RefGroupeFacade() {
    super(RefGroupe.class);
  }

  /**
   * Recherche les groupes avec pagination
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
  public QueryResult<RefGroupe> findPaginatedGroupes(boolean count, int first, int pageSize,
      String sortField, Boolean sortOrder, Map<String, Object> filters) {
    CriteriaBuilder cb = em.getCriteriaBuilder();
    CriteriaQuery<RefGroupe> q = cb.createQuery(RefGroupe.class);
    Root<RefGroupe> groupe = q.from(RefGroupe.class);

    Path<?> path = groupe;
    q.select(
        cb.construct(RefGroupe.class, path.get("id"), path.get("name"), path.get("description")));

    return (QueryResult<RefGroupe>) findPaginated(groupe, q, count, first, pageSize, sortField,
        sortOrder, filters);
  }

  /**
   * Permet de faire une recherche par autocomplétion des groupes.
   *
   * @param query Paramètre recherché.
   * 
   * @return Liste des modules correspondants au termes.
   */
  public List<RefGroupe> findAutoCompleteBylibelle(String query) {
    return em.createQuery("SELECT g FROM RefGroupe g WHERE g.name LIKE :name")
        .setParameter("name", "%" + query + "%").setMaxResults(20).getResultList();
  }

  /**
   * Recherche un groupe suivant le nom
   *
   * @param name nom de groupe
   * @return
   */
  public RefGroupe findGroupeByName(String name) {
    if (name != null && !name.isEmpty()) {
      List<RefGroupe> list =
          em.createQuery("SELECT u FROM RefGroupe u where u.name =:name", RefGroupe.class)
              .setParameter("name", name).getResultList();

      if (list != null && !list.isEmpty()) {
        return list.get(0);
      }

    }
    return null;
  }



}
