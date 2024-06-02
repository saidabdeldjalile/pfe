/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.commun.helper.mail;

import static dz.airalgerie.commun.utils.ErpConstante.GlobalResources;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 *
 */
public class MailSessionConfigImpl implements Serializable, MailSessionConfig {

  private String serverHost;
  private String serverPort;
  private String username;
  private String password;
  private String alias;
  private String sslTrust;
  private String enableTls;
  private String protocol;
  private String auth;
  private String testAdress;
  private boolean enabled;
  private Map<String, String> addressList;

  public MailSessionConfigImpl() {
    enableTls = "true";
    protocol = "smtp";
    auth = "true";
    alias = GlobalResources.EMAIL_SENDER_LABEL;
    enabled = true;
    addressList = new HashMap<>();
  }

  @Override
  public String getServerHost() {
    return serverHost;
  }

  public void setServerHost(String serverHost) {
    this.serverHost = serverHost;
  }

  @Override
  public String getServerPort() {
    return serverPort;
  }

  public void setServerPort(String serverPort) {
    this.serverPort = serverPort;
  }

  @Override
  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  @Override
  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  @Override
  public String getAlias() {
    return alias;
  }

  public void setAlias(String alias) {
    this.alias = alias;
  }

  @Override
  public String getSslTrust() {
    return sslTrust;
  }

  public void setSslTrust(String sslTrust) {
    this.sslTrust = sslTrust;
  }

  @Override
  public String getEnableTls() {
    return enableTls;
  }

  public void setEnableTls(String enableTls) {
    this.enableTls = enableTls;
  }

  @Override
  public String getProtocol() {
    return protocol;
  }

  public void setProtocol(String protocol) {
    this.protocol = protocol;
  }

  @Override
  public String getAuth() {
    return auth;
  }

  public void setAuth(String auth) {
    this.auth = auth;
  }

  @Override
  public String getTestAdress() {
    return testAdress;
  }

  public void setTestAdress(String testAdress) {
    this.testAdress = testAdress;
  }

  @Override
  public boolean isEnabled() {
    return enabled;
  }

  public void setEnabled(boolean enabled) {
    this.enabled = enabled;
  }

  @Override
  public Map<String, String> getAddressList() {
    return addressList;
  }

  public void setAddressList(Map<String, String> addressList) {
    this.addressList = addressList;
  }

  @Override
  public String toString() {
    return "MailSessionConfigImpl{" + "serverHost=" + serverHost + ", serverPort=" + serverPort
        + ", username=" + username + ", password=" + password + ", alias=" + alias + ", sslTrust="
        + sslTrust + ", enableTls=" + enableTls + ", protocol=" + protocol + ", auth=" + auth
        + ", testAdress=" + testAdress + ", enabled=" + enabled + ", addressList=" + addressList
        + '}';
  }

}
