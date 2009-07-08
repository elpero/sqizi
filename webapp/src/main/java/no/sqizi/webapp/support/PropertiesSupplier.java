package no.sqizi.webapp.support;

import org.springframework.core.io.Resource;

import java.util.Properties;
import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * User: SG0206005
 * Date: Jun 28, 2009
 * Time: 12:25:03 PM
 * To change this template use File | Settings | File Templates.
 */
public class PropertiesSupplier {
    private Resource propertiesFile;

    private Properties props;

    public Resource getPropertiesFile() {
        return propertiesFile;
    }

    public void setPropertiesFile(Resource propertiesFile) throws IOException {
        this.propertiesFile = propertiesFile;
        props = new Properties();
        props.load(propertiesFile.getInputStream());
    }

    public String getProperty(String key){

        if (props==null){
            return null;
        }
        return props.getProperty(key);

    }



}
