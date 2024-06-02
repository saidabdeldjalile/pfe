/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.commun.model.utils;

import static dz.airalgerie.commun.model.utils.StringListConverter.SEPARATOR;

import dz.airalgerie.commun.ref.entities.RefUser;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class DataAccessQueryBuilder implements Serializable {

  private static final long serialVersionUID = 1;

  private String query = "";
  private List<QueryParameter> parametersList;
  private static final String JPQL_PARAMETER_ALIAS = ":";
  private static final String NATIVE_PARAMETER_ALIAS = "?";

  public static class Builder {

    private RefUser user;
    private String query = "";
    private List<QueryParameter> parametersList;

    public Builder(RefUser user) {
      this.user = user;
      query = "";
      parametersList = new ArrayList<>();
    }

    public Builder initQuery() {
      query = " 1 = 1 ";

      return this;
    }

    /**
     * Permet d'avoir les filiales qu'un utilisateur est autorisé à accéder/consulter pour une
     * requête JPQL.
     *
     * @param alias Alias/column à utiliser.
     * @param parameterAlias Alias du paramètre.
     * 
     * @return Condition à appliquer.
     */
    public Builder withFilialeConstraint(String alias, String parameterAlias) {
      if (user.getFilialeAutorisee() != null && !user.getFilialeAutorisee().isEmpty()) {
        query += buildInClauseJpql(alias, JPQL_PARAMETER_ALIAS + parameterAlias);
        parametersList.add(new QueryParameter(parameterAlias, user.getFilialeAutorisee()));
      }

      return this;
    }

    /**
     * Permet d'avoir les filiales qu'un utilisateur est autorisé à accéder/consulter pour une
     * requête native.
     *
     * @param alias Alias/column à utiliser.
     * @param parameterAlias Alias du paramètre.
     * 
     * @return Condition à appliquer.
     */
    public Builder withFilialeNativeConstraint(String alias, String parameterAlias) {
      if (user.getFilialeAutorisee() != null && !user.getFilialeAutorisee().isEmpty()) {
        query += buildInClause(alias,
            "'" + String.join("'" + SEPARATOR + "'", user.getFilialeAutorisee()) + "'");
      }

      return this;
    }

    /**
     * Permet d'avoir les technicités qu'un utilisateur est autorisé à accéder/consulter pour une
     * requête JPQL.
     *
     * @param alias Alias/column à utiliser.
     * @param parameterAlias Alias du paramètre.
     * 
     * @return Condition à appliquer.
     */
    public Builder withTechConstraint(String alias, String parameterAlias) {
      if (user.getTechAutorisee() != null && !user.getTechAutorisee().isEmpty()) {
        query += buildInClauseJpql(alias, JPQL_PARAMETER_ALIAS + parameterAlias);
        parametersList.add(new QueryParameter(parameterAlias, user.getTechAutorisee()));
      }

      return this;
    }

    /**
     * Permet d'avoir les technicités qu'un utilisateur est autorisé à accéder/consulter pour une
     * requête native.
     *
     * @param alias Alias/column à utiliser.
     * @param parameterAlias Alias du paramètre.
     * 
     * @return Condition à appliquer.
     */
    public Builder withTechNativeConstraint(String alias, String parameterAlias) {
      if (user.getTechAutorisee() != null && !user.getTechAutorisee().isEmpty()) {
        query += buildInClause(alias,
            "'" + String.join("'" + SEPARATOR + "'", user.getTechAutorisee()) + "'");
      }

      return this;
    }

    /**
     * Permet d'avoir les directions qu'un utilisateur est autorisé à accéder/consulter pour une
     * requête JPQL.
     *
     * @param alias Alias/column à utiliser.
     * @param parameterAlias Alias du paramètre.
     * 
     * @return Condition à appliquer.
     */
    public Builder withDirectionConstraint(String alias, String parameterAlias) {
      if (user.getDirectionAutorisee() != null && !user.getDirectionAutorisee().isEmpty()) {
        query += buildInClauseJpql(alias, JPQL_PARAMETER_ALIAS + parameterAlias);
        parametersList.add(new QueryParameter(parameterAlias, user.getDirectionAutorisee()));
      }

      return this;
    }

    /**
     * Permet d'avoir les directions qu'un utilisateur est autorisé à accéder/consulter pour une
     * requête native.
     *
     * @param alias Alias/column à utiliser.
     * @param parameterAlias Alias du paramètre.
     * 
     * @return Condition à appliquer.
     */
    public Builder withDirectionNativeConstraint(String alias, String parameterAlias) {
      if (user.getDirectionAutorisee() != null && !user.getDirectionAutorisee().isEmpty()) {
        query += buildInClause(alias, String.join(SEPARATOR, user.getDirectionAutorisee()));
      }

      return this;
    }

    /**
     * Permet d'avoir les groupes qu'un utilisateur est autorisé à accéder/consulter pour une
     * requête JPQL.
     *
     * @param alias Alias/column à utiliser.
     * @param parameterAlias Alias du paramètre.
     * 
     * @return Condition à appliquer.
     */
    public Builder withGroupeConstraint(String alias, String parameterAlias) {
      if (user.getGroupeAutorise() != null && !user.getGroupeAutorise().isEmpty()) {
        query += buildInClauseJpql(alias, JPQL_PARAMETER_ALIAS + parameterAlias);
        parametersList.add(new QueryParameter(parameterAlias, user.getGroupeAutorise()));
      }

      return this;
    }

    /**
     * Permet d'avoir les groupes qu'un utilisateur est autorisé à accéder/consulter pour une
     * requête native.
     *
     * @param alias Alias/column à utiliser.
     * @param parameterAlias Alias du paramètre.
     * 
     * @return Condition à appliquer.
     */
    public Builder withGroupeNativeConstraint(String alias, String parameterAlias) {
      if (user.getGroupeAutorise() != null && !user.getGroupeAutorise().isEmpty()) {
        query += buildInClause(alias, String.join(SEPARATOR, user.getGroupeAutorise()));
      }

      return this;
    }

    /**
     * Permet d'avoir les journaux qu'un utilisateur est autorisé à accéder/consulter pour une
     * requête JPQL.
     *
     * @param alias Alias/column à utiliser.
     * @param parameterAlias Alias du paramètre.
     * 
     * @return Condition à appliquer.
     */
    public Builder withJournalConstraint(String alias, String parameterAlias) {
      if (user.getJournalAutorise() != null && !user.getJournalAutorise().isEmpty()) {
        query += buildInClauseJpql(alias, JPQL_PARAMETER_ALIAS + parameterAlias);
        parametersList.add(new QueryParameter(parameterAlias, user.getJournalAutorise()));
      }

      return this;
    }

    /**
     * Permet d'avoir les journaux qu'un utilisateur est autorisé à accéder/consulter pour une
     * requête native.
     *
     * @param alias Alias/column à utiliser.
     * @param parameterAlias Alias du paramètre.
     * 
     * @return Condition à appliquer.
     */
    public Builder withJournalNativeConstraint(String alias, String parameterAlias) {
      if (user.getJournalAutorise() != null && !user.getJournalAutorise().isEmpty()) {
        query += buildInClause(alias, String.join(SEPARATOR, user.getJournalAutorise()));
      }

      return this;
    }

    /**
     * Permet d'avoir les journaux qu'un utilisateur est autorisé à accéder/consulter pour une
     * requête JPQL.
     *
     * @param alias Alias/column à utiliser.
     * @param parameterAlias Alias du paramètre.
     * 
     * @return Condition à appliquer.
     */
    public Builder withAgenceConstraint(String alias, String parameterAlias) {
      if (user.getAgenceAutorisee() != null && !user.getAgenceAutorisee().isEmpty()) {
        query += buildInClauseJpql(alias, JPQL_PARAMETER_ALIAS + parameterAlias);
        parametersList.add(new QueryParameter(parameterAlias, user.getAgenceAutorisee()));
      }

      return this;
    }

    /**
     * Permet d'avoir les journaux qu'un utilisateur est autorisé à accéder/consulter pour une
     * requête native.
     *
     * @param alias Alias/column à utiliser.
     * @param parameterAlias Alias du paramètre.
     * 
     * @return Condition à appliquer.
     */
    public Builder withAgenceNativeConstraint(String alias, String parameterAlias) {
      if (user.getAgenceAutorisee() != null && !user.getAgenceAutorisee().isEmpty()) {
        query += buildInClause(alias, String.join(SEPARATOR, user.getAgenceAutorisee()));
      }

      return this;
    }

    /**
     * Permet de construire une clause "IN" pour une requête native.
     *
     * @param alias Alias/column à utiliser.
     * @param parameter Paramètre à passer à la clause.
     * 
     * @return Une clause SQL.
     */
    private String buildInClause(String alias, String parameter) {
      return " AND " + alias + " IN (" + parameter + ") ";
    }

    /**
     * Permet de construire une clause "IN" pour une requête JPQL.
     *
     * @param alias Alias/column à utiliser.
     * @param parameter Paramètre à passer à la clause.
     * 
     * @return Une clause SQL.
     */
    private String buildInClauseJpql(String alias, String parameter) {
      return " AND " + alias + " IN " + parameter + " ";
    }

    /**
     * Permet de construire l'objet DataAccessQueryBuilder.
     *
     * @return Instance de DataAccessQueryBuilder.
     */
    public DataAccessQueryBuilder build() {
      DataAccessQueryBuilder object = new DataAccessQueryBuilder();
      object.query = this.query;
      object.parametersList = this.parametersList;

      return object;
    }

  }

  private DataAccessQueryBuilder() {}

  public String getQuery() {
    return query;
  }

  public void setQuery(String query) {
    this.query = query;
  }

  public List<QueryParameter> getParametersList() {
    return parametersList;
  }

  public void setParametersList(List<QueryParameter> parametersList) {
    this.parametersList = parametersList;
  }
}
