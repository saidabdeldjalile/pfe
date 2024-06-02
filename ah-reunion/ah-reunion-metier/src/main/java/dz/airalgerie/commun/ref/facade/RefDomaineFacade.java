/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.commun.ref.facade;

import dz.airalgerie.commun.facade.AbstractFacade;
import dz.airalgerie.commun.model.utils.QueryResult;
import dz.airalgerie.commun.ref.entities.RefDomaine;
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
 * @author Sofyane MAKERRI
 */
@Stateless
public class RefDomaineFacade extends AbstractFacade<RefDomaine> {

  @PersistenceContext(unitName = ErpConstante.UnitName.REF_PU_NAME)
  private EntityManager em;

  @Override
  protected EntityManager getEntityManager() {
    return em;
  }

  public RefDomaineFacade() {
    super(RefDomaine.class);
  }

  public List<RefDomaine> findAllOrderByRang() {
    return em.createQuery("SELECT d FROM RefDomaine d ORDER BY d.rang ASC", RefDomaine.class)
        .getResultList();
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
  public QueryResult<RefDomaine> findPaginatedDomaines(boolean count, int first, int pageSize,
      String sortField, Boolean sortOrder, Map<String, Object> filters) {
    CriteriaBuilder cb = em.getCriteriaBuilder();
    CriteriaQuery<RefDomaine> q = cb.createQuery(RefDomaine.class);
    Root<RefDomaine> domaine = q.from(RefDomaine.class);

    Path<?> path = domaine;
    q.select(cb.construct(RefDomaine.class, path.get("id"), path.get("code"), path.get("nom"),
        path.get("rang"), path.get("icon"), path.get("url"), path.get("statut")));

    return (QueryResult<RefDomaine>) findPaginated(domaine, q, count, first, pageSize, sortField,
        sortOrder, filters);
  }

  /**
   * Recherche les URLS par code de Domaine
   *
   * @param name code de Domaine
   * 
   * @return
   */
  public String findUrlByDomaine(String name) {
    return (String) em.createQuery("SELECT df.url FROM RefDomaine df where df.code = :name")
        .setParameter("name", name).getSingleResult();
  }

}
