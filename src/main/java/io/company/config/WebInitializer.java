package io.company.config;

import javax.servlet.Filter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.mobile.device.DeviceResolverRequestFilter;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.guillermods.common.security.config.WebCommonSecurityConfig;

public class WebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

  private static final String ENCODING = "UTF-8";

  @Override
  public void onStartup(ServletContext context) throws ServletException {
    super.onStartup(context);
  }


  @Override
  protected Class<?>[] getRootConfigClasses() {
    return new Class[] {ApplicationConfig.class, WebCommonSecurityConfig.class};
  }


  @Override
  protected Class<?>[] getServletConfigClasses() {
    return new Class[] {};
  }

  @Override
  protected Filter[] getServletFilters() {
    CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
    characterEncodingFilter.setEncoding(ENCODING);
    DelegatingFilterProxy securityFilterChain =
        new DelegatingFilterProxy("springSecurityFilterChain");
    DeviceResolverRequestFilter deviceResolverRequestFilter = new DeviceResolverRequestFilter();
    return new Filter[] {characterEncodingFilter, securityFilterChain, deviceResolverRequestFilter};
  }


  @Override
  protected String[] getServletMappings() {
    return new String[] {"/"};
  }
}
