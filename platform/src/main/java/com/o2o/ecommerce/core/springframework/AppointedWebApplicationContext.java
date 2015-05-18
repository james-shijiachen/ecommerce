package com.o2o.ecommerce.core.springframework;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.web.context.support.XmlWebApplicationContext;

import javax.servlet.ServletContext;
import java.io.IOException;

/**
 * Created by James on 2015/5/14.
 */
public class AppointedWebApplicationContext extends XmlWebApplicationContext {

    private static final Log logger = LogFactory.getLog(AppointedWebApplicationContext.class);

    public static final String DEFAULT_CONFIG_LOCATION = "/WEB-INF/applicationContextList.prop";
    public static final String DEFAULT_CONFIG_LOCATION_PREFIX = "/WEB-INF/";
    public static final String DEFAULT_CONFIG_LOCATION_SUFFIX = ".prop";

    protected ResourcePatternResolver getResourcePatternResolver() {
        return new AppointedResourcePatternResolver(this);
    }

    protected void loadBeanDefinitions(XmlBeanDefinitionReader reader) throws IOException {
        String[] configLocations = this.getConfigLocations();
        if(configLocations != null) {
            String configLocation = configLocations[0];
            reader.loadBeanDefinitions(configLocation);
        }

    }

}
