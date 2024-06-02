/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this
 * license Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package dz.airalgerie.commun.model.utils;

import java.io.InputStream;
import java.io.Serializable;

/**
 *
 */
public class FileDTO implements Serializable {

  private static final long serialVersionUID = 1;

  private String name;
  private String extension;
  private InputStream inputStream;

  public FileDTO() {
  }

  public FileDTO(String name, String extension, InputStream inputStream) {
    this.name = name;
    this.extension = extension;
    this.inputStream = inputStream;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getExtension() {
    return extension;
  }

  public void setExtension(String extension) {
    this.extension = extension;
  }

  public InputStream getInputStream() {
    return inputStream;
  }

  public void setInputStream(InputStream inputStream) {
    this.inputStream = inputStream;
  }
}
