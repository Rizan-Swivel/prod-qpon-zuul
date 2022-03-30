package com.swivel.qpon.filters;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import com.swivel.qpon.util.RequestHeaderLoggerUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * Request Filter
 */
@Component
@Slf4j
public class RequestFilter extends ZuulFilter {

    public static final String PRE_FILTER_TYPE = "pre";
    private static final int FILTER_ORDER = 1;
    private static final boolean SHOULD_FILTER = true;
    private final RequestHeaderLoggerUtil requestHeaderLoggerUtil;

    public RequestFilter(RequestHeaderLoggerUtil requestHeaderLoggerUtil) {
        this.requestHeaderLoggerUtil = requestHeaderLoggerUtil;
    }

    @Override
    public String filterType() {
        return PRE_FILTER_TYPE;
    }

    @Override
    public int filterOrder() {
        return FILTER_ORDER;
    }

    @Override
    public boolean shouldFilter() {
        return SHOULD_FILTER;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        log.debug("Request headers: {}", requestHeaderLoggerUtil.getRequestHeaderMap(ctx.getRequest()));
        return null;
    }
}
