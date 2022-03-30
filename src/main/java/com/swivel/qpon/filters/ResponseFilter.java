package com.swivel.qpon.filters;

import brave.Tracer;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Response Filter
 */
@Component
@Slf4j
public class ResponseFilter extends ZuulFilter {

    public static final String CORRELATION_ID = "tkb-correlation-id";
    public static final String POST_FILTER_TYPE = "post";
    private static final int FILTER_ORDER = 1;
    private static final boolean SHOULD_FILTER = true;

    private final Tracer tracer;

    @Autowired
    public ResponseFilter(Tracer tracer) {
        this.tracer = tracer;
    }

    @Override
    public String filterType() {
        return POST_FILTER_TYPE;
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
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        ctx.getResponse().addHeader(CORRELATION_ID, tracer.currentSpan().context().traceIdString());
        log.debug("Completing outgoing request for {}.", ctx.getRequest().getRequestURI());
        return null;
    }
}
