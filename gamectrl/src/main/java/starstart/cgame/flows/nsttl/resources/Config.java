package starstart.cgame.flows.nsttl.resources;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class Config {


    private static final String BUNDLE_NAME = "cn.msec.bao.nsttl.resources.config"; //$NON-NLS-1$
    private static final String ERR_TRANSLATE= "cn.msec.bao.nsttl.resources.error"; //$NON-NLS-1$

    private static final ResourceBundle RESOURCE_BUNDLE =ResourceBundle.getBundle(BUNDLE_NAME);
    private static final ResourceBundle RESOURCE_ERR_TRANSLATE =ResourceBundle.getBundle(ERR_TRANSLATE);

    
    private Config() {
    }

    public static String getString(String key) {
        try {
            return RESOURCE_BUNDLE.getString(key).trim();
        } catch (MissingResourceException e) {
            return null;
        }
    }
    
    public static String getErrTranslate(String key) {
        try {
            return RESOURCE_ERR_TRANSLATE.getString("ERR."+key).trim();
        } catch (MissingResourceException e) {
            return null;
        }
    }
}
