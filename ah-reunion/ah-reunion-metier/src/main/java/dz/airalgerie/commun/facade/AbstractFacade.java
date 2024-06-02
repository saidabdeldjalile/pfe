/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.commun.facade;

import dz.airalgerie.commun.model.utils.QueryCriteria;
import dz.airalgerie.commun.model.utils.QueryResult;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaBuilder.In;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 *
 * @author Administrateur
 */
public abstract class AbstractFacade<T> {

  private Class<T> entityClass;

  public AbstractFacade(Class<T> entityClass) {
    this.entityClass = entityClass;
  }

  protected abstract EntityManager getEntityManager();

  public void create(T entity) {
    getEntityManager().persist(entity);
  }

  public void edit(T entity) {
    getEntityManager().merge(entity);
  }

  public T editEntity(T entity) {
    return getEntityManager().merge(entity);
  }

  public void remove(T entity) {
    getEntityManager().remove(getEntityManager().merge(entity));
  }

  public T find(Object id) {
    return getEntityManager().find(entityClass, id);
  }

  public List<T> findAll() {
    javax.persistence.criteria.CriteriaQuery cq =
        getEntityManager().getCriteriaBuilder().createQuery();
    cq.select(cq.from(entityClass));
    return getEntityManager().createQuery(cq).getResultList();
  }

  public List<T> findRange(int[] range) {
    javax.persistence.criteria.CriteriaQuery cq =
        getEntityManager().getCriteriaBuilder().createQuery();
    cq.select(cq.from(entityClass));
    javax.persistence.Query q = getEntityManager().createQuery(cq);
    q.setMaxResults(range[1] - range[0] + 1);
    q.setFirstResult(range[0]);
    return q.getResultList();
  }

  public int count() {
    javax.persistence.criteria.CriteriaQuery cq =
        getEntityManager().getCriteriaBuilder().createQuery();
    javax.persistence.criteria.Root<T> rt = cq.from(entityClass);
    cq.select(getEntityManager().getCriteriaBuilder().count(rt));
    javax.persistence.Query q = getEntityManager().createQuery(cq);
    return ((Long) q.getSingleResult()).intValue();
  }

  /**
   * Permet de construire le chemin d'arborescence pour un champ.
   * 
   * @param path  Instance de l'objet Path.
   * @param field Le champ à chercher.
   * 
   * @return
   */
  public Path<?> path(Path<?> path, String field) {
    String[] splitKey = field.split("\\.");
    for (String key : splitKey) {
      path = path.get(key);
    }

    return path;
  }

  /**
   * Permet d'appliquer les filtres et l'ordre sur une requête.
   *
   * @param cb        Instance de CriteriaBuilder.
   * @param q         Instance de CriteriaQuery.
   * @param sortField Champ destiné au tri.
   * @param sortOrder Sens du tri.
   * @param path      Instance de l'object Path.
   * @param filters   Liste des filtres à appliquer sur la recherche.
   * 
   * @return
   */
  public CriteriaQuery<T> filterAndOrderQuery(CriteriaBuilder cb, CriteriaQuery<?> q,
      String sortField, Boolean sortOrder, Path<?> path, Map<String, Object> filters) {
    return (CriteriaQuery<T>) genericFilterAndOrder(cb, q, sortField, sortOrder, path, filters);
  }

  /**
   * Permet d'appliquer les filtres et l'ordre sur une requête pour un <b><u>count</u></b>.
   *
   * @param cb        Instance de CriteriaBuilder.
   * @param q         Instance de CriteriaQuery.
   * @param sortField Champ destiné au tri.
   * @param sortOrder Sens du tri.
   * @param path      Instance de l'object Path.
   * @param filters   Liste des filtres à appliquer sur la recherche.
   * 
   * @return
   */
  public CriteriaQuery<?> filterAndOrderGeneric(CriteriaBuilder cb, CriteriaQuery<?> q,
      String sortField, Boolean sortOrder, Path<?> path, Map<String, Object> filters) {
    return genericFilterAndOrder(cb, q, sortField, sortOrder, path, filters);
  }

  /**
   * Permet d'appliquer les filtres et l'ordre sur une requête pour un <b><u>count</u></b>.
   *
   * @param cb        Instance de CriteriaBuilder.
   * @param q         Instance de CriteriaQuery.
   * @param sortField Champ destiné au tri.
   * @param sortOrder Sens du tri.
   * @param path      Instance de l'object Path.
   * @param filters   Liste des filtres à appliquer sur la recherche.
   * 
   * @return
   */
  public CriteriaQuery<Long> filterAndOrderCount(CriteriaBuilder cb, CriteriaQuery<Long> q,
      String sortField, Boolean sortOrder, Path<?> path, Map<String, Object> filters) {
    return (CriteriaQuery<Long>) (CriteriaQuery<T>) genericFilterAndOrder(cb, q, sortField,
        sortOrder, path, filters);
  }

  /**
   * Permet d'appliquer les filtres et l'ordre sur une requête.
   *
   * @param cb        Instance de CriteriaBuilder.
   * @param q         Instance de CriteriaQuery.
   * @param sortField Champ destiné au tri.
   * @param sortOrder Sens du tri.
   * @param path      Instance de l'object Path.
   * @param filters   Liste des filtres à appliquer sur la recherche.
   * 
   * @return
   */
  private CriteriaQuery<?> genericFilterAndOrder(CriteriaBuilder cb, CriteriaQuery<?> q,
      String sortField, Boolean sortOrder, Path<?> path, Map<String, Object> filters) {
    Path<?> p;

    if (sortField != null) {
      List<Order> orders = new ArrayList<>();
      String[] fields = sortField.split(",");
      for (String field : fields) {
        p = path;
        field = field.trim();
        p = this.path(p, field);
        if (sortOrder != null) {
          if (sortOrder) {
            orders.add(cb.asc(p));
          } else {
            orders.add(cb.desc(p));
          }
        }
      }
      if (!orders.isEmpty()) {
        q.orderBy(orders);
      }
    }

    // Filters
    Predicate filterCondition = cb.conjunction();
    Predicate tempPredicate;
    if (filters != null) {
      for (Map.Entry<String, Object> filter : filters.entrySet()) {
        if (!filter.getValue().equals("")) {
          Object value = filter.getValue();
          p = path;
          p = this.path(p, filter.getKey());

          if (value instanceof QueryCriteria) {
            QueryCriteria cValue = (QueryCriteria) value;

            switch (((QueryCriteria) value).getType()) {
              case QueryCriteria.EQUALS:
                filterCondition = cb.and(filterCondition,
                    cb.equal(p.as(String.class), ((QueryCriteria) value).getValue()));
                break;
              case QueryCriteria.GREATER:
                if (cValue.getValue() instanceof Date) {
                  tempPredicate = cb.greaterThan(p.as(Date.class), (Date) cValue.getValue());
                  filterCondition = cb.and(filterCondition, tempPredicate);
                } else if (cValue.getValue() instanceof LocalDate) {
                  tempPredicate =
                      cb.greaterThan(p.as(LocalDate.class), (LocalDate) cValue.getValue());
                  filterCondition = cb.and(filterCondition, tempPredicate);
                } else if (cValue.getValue() instanceof LocalDateTime) {
                  tempPredicate =
                      cb.greaterThan(p.as(LocalDateTime.class), (LocalDateTime) cValue.getValue());
                  filterCondition = cb.and(filterCondition, tempPredicate);
                } else {
                  filterCondition = cb.and(filterCondition,
                      cb.gt(p.as(Number.class), (Number) cValue.getValue()));
                }
                break;
              case QueryCriteria.LOWER:
                if (cValue.getValue() instanceof Date) {
                  tempPredicate = cb.lessThan(p.as(Date.class), (Date) cValue.getValue());
                  filterCondition = cb.and(filterCondition, tempPredicate);
                } else if (cValue.getValue() instanceof LocalDate) {
                  tempPredicate = cb.lessThan(p.as(LocalDate.class), (LocalDate) cValue.getValue());
                  filterCondition = cb.and(filterCondition, tempPredicate);
                } else if (cValue.getValue() instanceof LocalDateTime) {
                  tempPredicate =
                      cb.lessThan(p.as(LocalDateTime.class), (LocalDateTime) cValue.getValue());
                  filterCondition = cb.and(filterCondition, tempPredicate);
                } else {
                  filterCondition = cb.and(filterCondition,
                      cb.lt(p.as(Number.class), (Number) cValue.getValue()));
                }
                break;
              case QueryCriteria.BETWEEN:
                if (cValue.getValue() instanceof Date) {
                  tempPredicate = cb.between(p.as(Date.class), (Date) cValue.getValue(),
                      (Date) cValue.getValueB());
                  filterCondition = cb.and(filterCondition, tempPredicate);
                } else if (cValue.getValue() instanceof LocalDate) {
                  tempPredicate = cb.between(p.as(LocalDate.class), (LocalDate) cValue.getValue(),
                      (LocalDate) cValue.getValueB());
                  filterCondition = cb.and(filterCondition, tempPredicate);
                } else if (cValue.getValue() instanceof LocalDateTime) {
                  tempPredicate = cb.between(p.as(LocalDateTime.class),
                      (LocalDateTime) cValue.getValue(), (LocalDateTime) cValue.getValueB());
                  filterCondition = cb.and(filterCondition, tempPredicate);
                } else if (cValue.getValue() instanceof Integer) {
                  tempPredicate = cb.between(p.as(Integer.class), (Integer) cValue.getValue(),
                      (Integer) cValue.getValueB());
                  filterCondition = cb.and(filterCondition, tempPredicate);
                } else if (cValue.getValue() instanceof Long) {
                  tempPredicate = cb.between(p.as(Long.class), (Long) cValue.getValue(),
                      (Long) cValue.getValueB());
                  filterCondition = cb.and(filterCondition, tempPredicate);
                } else if (cValue.getValue() instanceof Double) {
                  tempPredicate = cb.between(p.as(Double.class), (Double) cValue.getValue(),
                      (Double) cValue.getValueB());
                  filterCondition = cb.and(filterCondition, tempPredicate);
                } else if (cValue.getValue() instanceof BigDecimal) {
                  tempPredicate = cb.between(p.as(BigDecimal.class), (BigDecimal) cValue.getValue(),
                      (BigDecimal) cValue.getValueB());
                  filterCondition = cb.and(filterCondition, tempPredicate);
                } else if (cValue.getValue() instanceof String) {
                  tempPredicate = cb.between(p.as(String.class), (String) cValue.getValue(),
                      (String) cValue.getValueB());
                  filterCondition = cb.and(filterCondition, tempPredicate);
                }
                break;
              case QueryCriteria.STARTS_WITH:
                filterCondition = cb.and(filterCondition, cb.like(p.as(String.class),
                    ((QueryCriteria) value).getValue().toString() + "%"));
                break;
              case QueryCriteria.NOT_STARTS_WITH:
                filterCondition = cb.and(filterCondition, cb.notLike(p.as(String.class),
                    ((QueryCriteria) value).getValue().toString() + "%"));
                break;
              case QueryCriteria.ENDS_WITH:
                filterCondition = cb.and(filterCondition, cb.like(p.as(String.class),
                    "%" + ((QueryCriteria) value).getValue().toString()));
                break;
              case QueryCriteria.NOT_ENDS_WITH:
                filterCondition = cb.and(filterCondition, cb.notLike(p.as(String.class),
                    "%" + ((QueryCriteria) value).getValue().toString()));
                break;
              case QueryCriteria.LIKE:
                filterCondition = cb.and(filterCondition, cb.like(p.as(String.class),
                    "%" + ((QueryCriteria) value).getValue().toString() + "%"));
                break;
              case QueryCriteria.IS_NULL:
                filterCondition = cb.and(filterCondition, cb.isNull(p.as(String.class)));
                break;
              case QueryCriteria.IS_NOT_NULL:
                filterCondition = cb.and(filterCondition, cb.isNotNull(p.as(String.class)));
                break;
              case QueryCriteria.IN:
                if (cValue.getValue() instanceof List && ((List<T>) cValue.getValue()).size() > 0
                    && ((List<T>) cValue.getValue()).get(0) instanceof String) {
                  In<String> inClause = cb.in(p.as(String.class));
                  for (String o : (List<String>) cValue.getValue()) {
                    inClause.value(o);
                  }
                  filterCondition = cb.and(filterCondition, inClause);
                } else if (cValue.getValue() instanceof List
                    && ((List<T>) cValue.getValue()).size() > 0
                    && ((List<T>) cValue.getValue()).get(0) instanceof Integer) {
                  In<Integer> inClause = cb.in(p.as(Integer.class));
                  for (Integer o : (List<Integer>) cValue.getValue()) {
                    inClause.value(o);
                  }
                  filterCondition = cb.and(filterCondition, inClause);
                }

                break;


              default:
                break;
            }
          } else {
            filterCondition =
                cb.and(filterCondition, cb.like(p.as(String.class), "%" + value + "%"));
          }
        }
      }

    }

    q.where(filterCondition);

    return q;
  }

  /**
   * Permet de faire une recherche paginée.
   *
   * @param root      Object root à utiliser.
   * @param q         Instance de CriteriaQuery.
   * @param count     Permet de calculer le nombe total de résultats.
   * @param first     Indice du premier résultat.
   * @param pageSize  Nombre de lignes d'une page.
   * @param sortField Champ destiné au tri.
   * @param sortOrder Sens du tri.
   * @param filters   Liste des filtres à appliquer sur la recherche.
   * 
   * @return
   */
  public QueryResult<?> findPaginated(Root<T> root, CriteriaQuery<?> q, boolean count, int first,
      int pageSize, String sortField, Boolean sortOrder, Map<String, Object> filters) {
    QueryResult<?> result = new QueryResult<>();

    q = this.filterAndOrderQuery(getEntityManager().getCriteriaBuilder(), q, sortField, sortOrder,
        root, filters);

    TypedQuery<?> tq = getEntityManager().createQuery(q);

    if (pageSize >= 0) {
      tq.setMaxResults(pageSize);
    }
    if (first >= 0) {
      tq.setFirstResult(first);
    }

    result.setRecords(tq.getResultList());

    if (count) {
      CriteriaQuery<Long> qc = getEntityManager().getCriteriaBuilder().createQuery(Long.class);
      qc.select(getEntityManager().getCriteriaBuilder().count(root));
      qc = this.filterAndOrderCount(getEntityManager().getCriteriaBuilder(), qc, null, null, root,
          filters);

      TypedQuery<Long> tqc = getEntityManager().createQuery(qc);

      result.setTotalRecords(tqc.getSingleResult());
    }

    return result;
  }

}
