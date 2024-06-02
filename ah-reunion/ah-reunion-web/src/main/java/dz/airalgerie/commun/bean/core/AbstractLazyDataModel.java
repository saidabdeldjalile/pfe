/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.commun.bean.core;

import dz.airalgerie.commun.model.utils.QueryResult;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import org.primefaces.model.FilterMeta;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortMeta;

/**
 *
 */
public abstract class AbstractLazyDataModel<T> extends LazyDataModel<T> {

  private static final long serialVersionUID = 1L;

  private boolean changed = true;

  @Override
  public List<T> load(int offset, int pageSize, Map<String, SortMeta> sortBy,
      Map<String, FilterMeta> filterBy) {

    String sortField = null;

    Boolean order = null;
    if (sortBy != null && !sortBy.isEmpty()) {
      // TODO: Multi sorting for querying.
      sortField = sortBy.entrySet().stream().findFirst().get().getKey();

      switch (sortBy.get(sortField).getOrder()) {
        case ASCENDING:
          order = true;
          break;
        case DESCENDING:
          order = false;
          break;
        default:
          order = null;
          break;
      }
    }
    Map<String, Object> filters = filterMetaToFilters(filterBy);

    QueryResult<T> result = findResult(changed, offset, pageSize, sortField, order, filters);

    if (changed) {
      this.setRowCount(result.getTotalRecords().intValue());
      this.recalculateFirst(offset, pageSize, this.getRowCount());

      changed = false;
    }

    return (List<T>) result.getRecords();
  }

  @Override
  public int count(Map<String, FilterMeta> filterBy) {
    return this.getRowCount();
  }

  /**
   * Permet de mapper les filtres selon le format <i>field -> condition</i>.
   * 
   * @param filterBy Liste des filtres depuis le datatable.
   * @return Les filtres
   */
  public static Map<String, Object> filterMetaToFilters(Map<String, FilterMeta> filterBy) {
    if (filterBy == null || filterBy.isEmpty()) {
      return new HashMap<String, Object>();
    }

    return filterBy.entrySet().stream().filter(e -> Objects.nonNull(e.getValue().getFilterValue()))
        .collect(Collectors.toMap(Map.Entry::getKey, e -> e.getValue().getFilterValue()));
  }

  /**
   * Permet d'exécuter la recherche paginée.
   *
   * @param changed   Indicateur de changement pour le calcul du nombre de résultats attendus.
   * @param first     Indice du premier résultat.
   * @param pageSize  Nombre de lignes d'une page.
   * @param sortField Champ destiné au tri.
   * @param sortOrder Sens du tri.
   * @param filters   Liste des filtres à appliquer sur la recherche.
   * 
   * @return
   */
  public abstract QueryResult<T> findResult(boolean changed, int first, int pageSize,
      String sortField, Boolean sortOrder, Map<String, Object> filters);

  public boolean isChanged() {
    return changed;
  }

  public void setChanged(boolean changed) {
    this.changed = changed;
  }

}
