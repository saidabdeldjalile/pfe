/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dz.airalgerie.commun.utils;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author AGHA RIADH
 */
@LocalBean
@Stateless
public class CheckConfigurationParameters {

    @Resource(name = ErpConstante.GlobalResources.FTP_CONFIGURATION_PARAMETERS)
    private Properties properties;

    /**
     * Recuperer la valeur de parametere de configuration externe suivant son
     * nom via le nom la ressource au niveau serveur
     *
     *
     * @param configParameter
     *
     * @return
     */
    public String getConfigurationParameters(String configParameter) throws NamingException {
        String valueParameters = "";
        Context initialContext = new InitialContext();
        try {
            properties = (Properties) initialContext.lookup(ErpConstante.GlobalResources.FTP_CONFIGURATION_PARAMETERS);
            valueParameters = properties.getProperty(configParameter);
            initialContext.close();
            return valueParameters;
        } catch (NamingException ex) {
            Logger.getLogger(CheckConfigurationParameters.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            initialContext.close();
        }
        return null;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

}
