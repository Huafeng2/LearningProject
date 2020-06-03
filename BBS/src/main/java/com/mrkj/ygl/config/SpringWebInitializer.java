package com.mrkj.ygl.config;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * 替换web.xml的DispatcherServlet
 */
public class SpringWebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    private static final Logger logger = Logger.getLogger(SpringWebInitializer.class);

    @Override
    protected Class<?>[] getRootConfigClasses() {
        // TODO Auto-generated method stub
        return new Class<?>[]{RootConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        // TODO Auto-generated method stub
        return new Class<?>[]{WebConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        // TODO Auto-generated method stub
        logger.info("getServletMappings enter.");
        return new String[]{"/"};
    }
}
