package com.ahnstar.skeleton.base.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.ahnstar.skeleton.base.interceptor.BaseInterceptor;
import com.navercorp.lucy.security.xss.servletfilter.XssEscapeServletFilter;

import nz.net.ultraq.thymeleaf.LayoutDialect;

@Configuration
public class ContextConfig implements WebMvcConfigurer{
	
	@Autowired
	private BaseInterceptor baseInterceptor;
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(baseInterceptor);
	}
	
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**");
	}
	
	@Bean
	public ResourceBundleMessageSource messageSource() {
	    ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
	    messageSource.setBasename("Messages");
	    return messageSource;
	}
	
	/*
	 * @Bean public TilesConfigurer tilesConfigurer() { final TilesConfigurer
	 * configurer = new TilesConfigurer(); configurer.setDefinitions(new String[] {
	 * "classpath:config/tiles2.xml" }); configurer.setCheckRefresh(true); return
	 * configurer; }
	 * 
	 * @Bean public TilesViewResolver tilesViewResolver() { final TilesViewResolver
	 * resolver = new TilesViewResolver(); resolver.setViewClass(TilesView.class);
	 * return resolver; }
	 */
	

	
	@Bean
    public FilterRegistrationBean<XssEscapeServletFilter> getFilterRegistrationBean(){
        FilterRegistrationBean<XssEscapeServletFilter> registrationBean = new FilterRegistrationBean<XssEscapeServletFilter>();
        registrationBean.setFilter(new XssEscapeServletFilter());
        registrationBean.setOrder(1);
        registrationBean.addUrlPatterns("/**");
        
        return registrationBean;
    }
	
	@Bean
	public LayoutDialect layoutDialect() {
		return new LayoutDialect();
	}
}
