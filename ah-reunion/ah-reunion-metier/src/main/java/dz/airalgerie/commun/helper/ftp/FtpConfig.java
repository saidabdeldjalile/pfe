/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.commun.helper.ftp;


/**
 *
 */
public class FtpConfig {

  private String host;
  private int port;
  private String username;
  private String password;
  private String rootPath;

  public FtpConfig() {
  }

  public FtpConfig(String host, String username, String password) {
    this.host = host;
    this.port = 21;
    this.username = username;
    this.password = password;
  }

  public FtpConfig(String host, int port, String username, String password) {
    this.host = host;
    this.port = port;
    this.username = username;
    this.password = password;
  }

  public FtpConfig(String host, String username, String password, String rootPath) {
    this.host = host;
    this.port = 21;
    this.username = username;
    this.password = password;
    this.rootPath = rootPath;
  }

  /**
   * Permet de recuperer le root path remote folder FTP
   * 
   * @param remotefolder
   * @return
   */
  public String findRootPathRemoteFolder(String remotefolder) {
    if (remotefolder == null) {
      remotefolder = "";
    }
    String rootPathRemoteFolder = getRootPath() + remotefolder;
    return rootPathRemoteFolder;
  }

  public String getHost() {
    return host;
  }

  public void setHost(String host) {
    this.host = host;
  }

  public int getPort() {
    return port;
  }

  public void setPort(int port) {
    this.port = port;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getRootPath() {
    return rootPath;
  }

  public void setRootPath(String rootPath) {
    this.rootPath = rootPath;
  }

}
