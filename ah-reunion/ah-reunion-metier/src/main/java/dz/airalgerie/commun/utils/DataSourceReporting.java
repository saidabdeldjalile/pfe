/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.commun.utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.*;
import javax.sql.*;

/**
 *
 * @author AGHA Riadh
 */
public class DataSourceReporting {

  /**
   * Permet de pointer sur le pool de connexion associé au jndi niveau serveur.
   * 
   * @param jndi
   * 
   * @return
   */
  public static Connection getconnection(String jndi) throws SQLException {

    DataSource dataSource = null;
    Connection result = null;
    try {
      Context initialContext = new InitialContext();
      Context environmentContext = (Context) initialContext.lookup("java:comp/env");
      dataSource = (DataSource) environmentContext.lookup(jndi);
      result = dataSource.getConnection();
    } catch (NamingException e) {

      e.printStackTrace();
    }

    return result;

  }

  /**
   * Permet d'excuter une requete sql via une connexion attribué
   * 
   *
   * @param requet
   * @param connexion
   * 
   * @return
   */
  public static ResultSet executeQuery(String requet, Connection connexion) throws SQLException {

    return connexion.createStatement().executeQuery(requet);

  }

}
