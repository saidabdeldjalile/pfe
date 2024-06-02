/*
 * To change this license header, choose License Headers in Project Properties. To change this
 * template file, choose Tools | Templates and open the template in the editor.
 */

package dz.airalgerie.commun.helper.mail;

import java.util.Map;

/**
 *
 */
public interface MailSessionConfig {

  public String getServerHost();

  public String getServerPort();

  public String getUsername();

  public String getPassword();

  public String getAlias();

  public String getSslTrust();

  public String getEnableTls();

  public String getProtocol();

  public String getAuth();

  public String getTestAdress();

  public boolean isEnabled();

  public Map<String, String> getAddressList();

}
