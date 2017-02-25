package io.company.config;

import javax.servlet.Filter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

  private static final String ENCODING = "UTF-8";


  @Override
  public void onStartup(ServletContext context) throws ServletException {
    // context.setInitParameter("spring.profiles.active", "test");
    super.onStartup(context);
  }


  @Override
  protected Class<?>[] getRootConfigClasses() {
    return new Class[] {ApplicationConfig.class};
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
    return new Filter[] {characterEncodingFilter, securityFilterChain};
  }


  @Override
  protected String[] getServletMappings() {
    return new String[] {"/"};
  }
}
