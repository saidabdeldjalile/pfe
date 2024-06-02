/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.commun.utils;

import dz.airalgerie.commun.exception.InvalidPasswordException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.glassfish.soteria.identitystores.hash.Pbkdf2PasswordHashImpl;
import org.passay.CharacterData;
import org.passay.CharacterRule;
import org.passay.EnglishCharacterData;
import org.passay.LengthRule;
import org.passay.PasswordData;
import org.passay.PasswordGenerator;
import org.passay.PasswordValidator;
import org.passay.Rule;
import org.passay.RuleResult;

/**
 *
 */
public class PasswordHash implements Serializable {

  private static final long serialVersionUID = 1L;

  public static final String ERROR_CODE = "ERRONEOUS_SPECIAL_CHARS";

  /**
   * Permet d'initialiser l'objet passwordHash.
   *
   * @return
   */
  private static Pbkdf2PasswordHashImpl init() {
    Pbkdf2PasswordHashImpl passwordHash = new Pbkdf2PasswordHashImpl();
    Map<String, String> parameters = new HashMap<>();
    parameters.put("Pbkdf2PasswordHash.Iterations", "3072");
    parameters.put("Pbkdf2PasswordHash.Algorithm", "PBKDF2WithHmacSHA512");
    parameters.put("Pbkdf2PasswordHash.SaltSizeBytes", "64");
    passwordHash.initialize(parameters);

    return passwordHash;
  }

  /**
   * Permet de hasher une chaine de caractères.
   *
   * @param value Valeur de la chaine à hasher.
   * 
   * @return Un hash.
   * 
   * @throws InvalidPasswordException
   */
  public static String hash(String value) throws InvalidPasswordException {
    if (value != null && !value.isEmpty()) {
      Pbkdf2PasswordHashImpl passwordHash = init();

      return passwordHash.generate(value.toCharArray());
    } else {
      throw new InvalidPasswordException("Mot de passe requis.");
    }
  }

  /**
   * Permet de vérifier le hash de deux chaines.
   *
   * @param value       : Valeur de la chaine à hasher.
   * @param hashedValue : Valeur de la chaine hashée.
   * 
   * @return Renvoi vrai si les deux hash sont identiques.
   * 
   * @throws InvalidPasswordException
   */
  public static boolean verifyHash(String value, String hashedValue)
      throws InvalidPasswordException {
    if (value != null && !value.isEmpty()) {
      Pbkdf2PasswordHashImpl passwordHash = init();

      return passwordHash.verify(value.toCharArray(), hashedValue);
    } else {
      throw new InvalidPasswordException("Mot de passe requis.");
    }
  }

  /**
   * Permet d'initialiser les contraintes sur un password.
   *
   * @return
   */
  private static List<? extends Rule> initRules() {

    CharacterData specialChars = new CharacterData() {
      @Override
      public String getErrorCode() {
        return ERROR_CODE;
      }

      @Override
      public String getCharacters() {
        return "!@?*()_+-.";
      }
    };

    return Arrays.asList(new CharacterRule(EnglishCharacterData.LowerCase, 1),
        new CharacterRule(EnglishCharacterData.UpperCase, 1),
        new CharacterRule(EnglishCharacterData.Digit, 1), new CharacterRule(specialChars, 1));
  }

  /**
   * Permet de générer un mot de passe aléatoirement.
   *
   * @return Mot de passe aléatoire.
   */
  public static String generatePassword() {
    PasswordGenerator gen = new PasswordGenerator();

    List<CharacterRule> rules = (List<CharacterRule>) initRules();

    String password = gen.generatePassword(12, rules);
    return password;
  }

  /**
   * Permet de vérifier les contraintes sur un mot de passe.
   *
   * @param password : Mot de passe à vérifier.
   * 
   * @return Renvoi vrai si le mot de passe est valide.
   */
  public static boolean verifyPassword(String password) {
    List<Rule> rules = new ArrayList<>();
    rules.addAll(initRules());
    rules.add((Rule) new LengthRule(8, 50));

    PasswordValidator validator = new PasswordValidator(rules);

    RuleResult result = validator.validate(new PasswordData(password));

    return result.isValid();
  }

}
