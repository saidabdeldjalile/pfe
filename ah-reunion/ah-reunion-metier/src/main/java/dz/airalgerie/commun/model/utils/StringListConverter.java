/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.commun.model.utils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 *
 */
@Converter
public class StringListConverter implements AttributeConverter<Set<String>, String> {

  public static final String SEPARATOR = ",";

  @Override
  public String convertToDatabaseColumn(Set<String> list) {
    if (list != null && !list.isEmpty()) {
      return String.join(SEPARATOR, list);
    }
    return null;
  }

  @Override
  public Set<String> convertToEntityAttribute(String joined) {
    if (joined != null && !joined.isEmpty()) {
      return new HashSet<>(Arrays.asList(joined.split(SEPARATOR)));
    }
    return new HashSet<>();
  }

}
