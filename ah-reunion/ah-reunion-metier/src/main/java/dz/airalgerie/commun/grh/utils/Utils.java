/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.commun.grh.utils;

/**
 *
 * @author Administrateur
 */
public class Utils {

  public static final String dbSchema = StaticVariables.DB_SCHEMA;

  public static String findDbSchema(String codeDir) {
    try {
      if (codeDir.equals("20")) {
        return "CAT_PAIE";
      } else if (codeDir.equals("18")) {
        return "CARGO_PAIE";
      } else {
        return "PAIE";
      }
    } catch (Exception e) {
      return "PAIE";
    }
  }

  public static String findCodeFiliale() {
    try {
      if (dbSchema.equals("CARGO_PAIE")) {
        return "G";
      } else if (dbSchema.equals("CAT_PAIE")) {
        return "C";
      } else {
        return "A";
      }
    } catch (Exception e) {
      return "A";
    }
  }

  public static String findDbSchemaByCodeFil(String codeFil) {
    try {
      if (codeFil.equals("C")) {
        return "CAT_PAIE";
      } else if (codeFil.equals("G")) {
        return "CARGO_PAIE";
      } else {
        return "PAIE";
      }
    } catch (Exception e) {
      return "PAIE";
    }
  }

  public static String findCodeFilFromDir(String codeDir) {
    try {
      if (codeDir != null) {
        if (codeDir.equals("20")) {
          return "C";
        } else if (codeDir.equals("18")) {
          return "G";
        } else {
          return "A";
        }
      } else {
        return codeDir;
      }
    } catch (Exception e) {
      return "A";
    }
  }

  public static String findDbLikeCondition() {
    try {
      if (dbSchema.equals("CARGO_PAIE")) {
        return " AND C.GRP_CHAP LIKE '18%' ";
      } else if (dbSchema.equals("CAT_PAIE")) {
        return " AND C.GRP_CHAP LIKE '20%' ";
      } else {
        return " AND C.GRP_CHAP NOT LIKE '18%' AND C.GRP_CHAP NOT LIKE '20%' ";
      }
    } catch (Exception e) {
      return "";
    }
  }

  public static String findDbBpLikeCondition() {
    try {
      if (dbSchema.equals("CARGO_PAIE")) {
        return " AND BP.CODE_FIL = 'G' ";
      } else if (dbSchema.equals("CAT_PAIE")) {
        return " AND BP.CODE_FIL = 'C' ";
      } else {
        return " AND BP.CODE_FIL = 'A' ";
      }
    } catch (Exception e) {
      return "";
    }
  }

}
