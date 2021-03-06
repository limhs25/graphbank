package com.bindstone.graphbank.config.interceptor;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestTimerInterceptor extends HandlerInterceptorAdapter {
    private static Logger log = LoggerFactory.getLogger("Rest Request");

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {
        long startTime = System.currentTimeMillis();
        log.info("[{}] {}", request.getMethod(), request.getRequestURL());
        request.setAttribute("startTime", startTime);
        //if returned false, we need to make sure 'response' is sent
        return true;
    }

    /**
     * @Override public void postHandle(HttpServletRequest request,
     * HttpServletResponse response, Object handler,
     * ModelAndView modelAndView) throws Exception {
     * System.out.println("Request URL::" + request.getRequestURL().toString()
     * + " Sent to Handler :: Current Time=" + System.currentTimeMillis());
     * //we can add attributes in the modelAndView and use that in the view page
     * }
     **/

    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        long startTime = (Long) request.getAttribute("startTime");
        long time = System.currentTimeMillis() - startTime;
        log.info("[{}] {} [{}ms]", request.getMethod(), request.getRequestURL(), time);
    }

}