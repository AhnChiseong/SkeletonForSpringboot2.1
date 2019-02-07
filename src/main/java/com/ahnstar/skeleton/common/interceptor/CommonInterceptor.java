package com.ahnstar.skeleton.common.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import ch.qos.logback.classic.Logger;

@Component
public class CommonInterceptor implements HandlerInterceptor {
	protected final Logger logger = (Logger) LoggerFactory.getLogger(getClass());
		
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		this.logger.debug(">> preHandler start!");
		return HandlerInterceptor.super.preHandle(request, response, handler);
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		this.logger.debug(">> postHandler start!");
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
		this.logger.debug(">> afterCompletion start!");
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}
}
