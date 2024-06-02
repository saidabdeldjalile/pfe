/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dz.airalgerie.grh.model.dto.commun;

/**
 * Class permetant d'enregister les parametres de configuration externes au
 * demarrage
 *
 * @author AGHA Riadh
 */
public class ExternelConfigurationParameters {

    private String usernameFtp;
    private String passwordFtp;
    private String hostFtp;
    private String rootPathFtp ;

    public ExternelConfigurationParameters() {
    }

    public ExternelConfigurationParameters(String usernameFtp, String passwordFtp) {
        this.usernameFtp = usernameFtp;
        this.passwordFtp = passwordFtp;
    }

    public ExternelConfigurationParameters(String usernameFtp, String passwordFtp, String hostFtp) {
        this.usernameFtp = usernameFtp;
        this.passwordFtp = passwordFtp;
        this.hostFtp = hostFtp;
    }

    public ExternelConfigurationParameters(String usernameFtp, String passwordFtp, String hostFtp, String rootPathFtp) {
        this.usernameFtp = usernameFtp;
        this.passwordFtp = passwordFtp;
        this.hostFtp = hostFtp;
        this.rootPathFtp = rootPathFtp;
    }
    
    public String getUsernameFtp() {
        return usernameFtp;
    }

    public void setUsernameFtp(String usernameFtp) {
        this.usernameFtp = usernameFtp;
    }

    public String getPasswordFtp() {
        return passwordFtp;
    }

    public void setPasswordFtp(String passwordFtp) {
        this.passwordFtp = passwordFtp;
    }

    public String getHostFtp() {
        return hostFtp;
    }

    public void setHostFtp(String hostFtp) {
        this.hostFtp = hostFtp;
    }

    public String getRootPathFtp() {
        return rootPathFtp;
    }

    public void setRootPathFtp(String rootPathFtp) {
        this.rootPathFtp = rootPathFtp;
    }
    

}
