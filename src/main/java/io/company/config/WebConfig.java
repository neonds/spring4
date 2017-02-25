package io.company.config;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;

@Configuration
@EnableWebMvc
public class WebConfig extends WebMvcConfigurerAdapter{


  private static final String TEMPLATE_MODE = "HTML";
  private static final String VIEW_SUFFIX = ".html";
  private static final String ENCONDING = "UTF-8";
  private static final String MESSAGE_SOURCE = "/WEB-INF/i18n/messages/lang";
  private static final String VIEWS = "/WEB-INF/views/";
  private static final String RESOURCE_LOCATION = "/resources/";
  private static final String RESOURCE_HANDLER = RESOURCE_LOCATION + "**";


  public void addResourceHandlers(ResourceHandlerRegistry registry) {
    registry.addResourceHandler(RESOURCE_HANDLER).addResourceLocations(RESOURCE_LOCATION);
    registry.addResourceHandler("/webjars/**").addResourceLocations("/webjars/");
  }


  private ApplicationContext applicationContext;

  public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
    this.applicationContext = applicationContext;

  }

  @Bean
  public SpringResourceTemplateResolver templateResolver() {
    SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
    templateResolver.setApplicationContext(this.applicationContext);
    templateResolver.setPrefix(VIEWS);
    templateResolver.setSuffix(VIEW_SUFFIX);
    templateResolver.setCharacterEncoding(ENCONDING);
    templateResolver.setTemplateMode(TEMPLATE_MODE);
    templateResolver.setCacheable(false);
    return templateResolver;
  }

  @Bean
  public SpringTemplateEngine templateEngine() {
    SpringTemplateEngine templateEngine = new SpringTemplateEngine();
    templateEngine.setTemplateResolver(templateResolver());
    return templateEngine;
  }



  @Bean
  public ViewResolver viewResolver() {
    ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
    viewResolver.setTemplateEngine(templateEngine());
    viewResolver.setOrder(Ordered.HIGHEST_PRECEDENCE);
    return viewResolver;
  }

  @Bean(name = "messageSource")
  public MessageSource messageSource() {
      ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
      messageSource.setBasename(MESSAGE_SOURCE);
      messageSource.setCacheSeconds(5);
      return messageSource;
  }


}
