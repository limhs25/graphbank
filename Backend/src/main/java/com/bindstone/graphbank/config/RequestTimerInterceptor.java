package com.bindstone.graphbank.config;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.logging.Logger;

public class RequestTimerInterceptor extends HandlerInterceptorAdapter {
    static Logger log = Logger.getLogger("Rest Request");

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {
        long startTime = System.currentTimeMillis();
        log.info(String.format("[%s] %s", request.getMethod(), request.getRequestURL().toString()));
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
        log.info(String.format("[%s] %s %nms", request.getMethod(), request.getRequestURL().toString(), time));
    }

}