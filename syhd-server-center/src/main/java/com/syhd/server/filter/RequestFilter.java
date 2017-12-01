package com.syhd.server.filter;

import com.netflix.zuul.ZuulFilter;
import org.apache.log4j.Logger;


public class RequestFilter extends ZuulFilter {

    private static final Logger logger=Logger.getLogger(RequestFilter.class);
    @Override
    public String filterType() {
        logger.info("1");
        return null;
    }

    @Override
    public int filterOrder() {
        logger.info("2");
        return 0;
    }

    //@Override
    public boolean shouldFilter() {
        logger.info("3");
        return false;
    }

    //@Override
    public Object run() {
        logger.info("4");
        return null;
    }
}
