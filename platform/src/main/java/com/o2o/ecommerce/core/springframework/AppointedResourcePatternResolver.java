package com.o2o.ecommerce.core.springframework;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.web.context.support.ServletContextResourcePatternResolver;

import javax.servlet.ServletContext;
import java.io.IOException;

/**
 * Created by James on 2015/5/14.
 */
public class AppointedResourcePatternResolver extends ServletContextResourcePatternResolver {

    private static final Log logger = LogFactory.getLog(AppointedResourcePatternResolver.class);

    public AppointedResourcePatternResolver(ServletContext servletContext) {
        super(servletContext);
    }

    public AppointedResourcePatternResolver(ResourceLoader resourceLoader) {
        super(resourceLoader);
    }

    protected Resource[] findPathMatchingResources(String locationPattern) throws IOException {
        Resource[] pathMatchingResources = super.findPathMatchingResources(locationPattern);

        if(logger.isDebugEnabled()) {
            logger.debug("Searching jar file [" + "] for entries matching [" + "]");
        }
        return pathMatchingResources;
    }

}
