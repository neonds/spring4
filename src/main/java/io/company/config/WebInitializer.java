package io.company.config;

import javax.servlet.Filter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

  private static final String SERVLET_MAP = "/";

  /**
   * Uncomment for spring security config
   */
  // private static final String SPRING_SECURITY_FILTER_CHAIN = "springSecurityFilterChain";
  private static final String ENCODING = "UTF-8";


  @Override
  public void onStartup(ServletContext context) throws ServletException {
    // Uncoment for define a profile.
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

    /**
     * Just necesary if you add Spring security
     */
    // DelegatingFilterProxy securityFilterChain = new
    // DelegatingFilterProxy(SPRING_SECURITY_FILTER_CHAIN);
    // return new Filter[] {characterEncodingFilter, securityFilterChain};

    return new Filter[] {characterEncodingFilter};

  }


  @Override
  protected String[] getServletMappings() {
    return new String[] {SERVLET_MAP};
  }
}
