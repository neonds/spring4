package io.company.config;

import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.util.ClassUtils;

import io.company.Application;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackageClasses = Application.class)
public class PersistenceConfig {


  private static final String DATASOURCE_PASSWORD = "datasource.password";

  private static final String DATASOURCE_USERNAME = "datasource.username";

  private static final String DATASOURCE_URL = "datasource.url";

  private static final String DATASOURCE_DRIVER = "datasource.driver";
  
  private static final String APP_NAME = "app.name";
  
  private static final String CLASSPATH_DB_MIGRATION = "classpath:db/migration";

  @Autowired
  private Environment env;
  
  @Bean
  public DataSource dataSource() throws SQLException {

    DriverManagerDataSource dataSource = new DriverManagerDataSource();
    dataSource.setDriverClassName(env.getProperty(DATASOURCE_DRIVER));
    dataSource.setUrl(env.getProperty(DATASOURCE_URL));
    dataSource.setUsername(env.getProperty(DATASOURCE_USERNAME));
    dataSource.setPassword(env.getProperty(DATASOURCE_PASSWORD));
    
    //Flyway Migration, not necesary for existing Schema in database
    Flyway flyway = new Flyway();
    flyway.setLocations(CLASSPATH_DB_MIGRATION);
    flyway.setClassLoader(this.getClass().getClassLoader());
    flyway.setDataSource(dataSource);
    flyway.migrate();
    
    return flyway.getDataSource();
  }



  @Bean
  public LocalContainerEntityManagerFactoryBean entityManagerFactory() throws SQLException {
    LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
    em.setDataSource(dataSource());
    em.setPersistenceUnitName(env.getProperty(APP_NAME));
    em.setPackagesToScan(ClassUtils.getPackageName(Application.class));
    JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
    em.setJpaVendorAdapter(vendorAdapter);
    em.setJpaProperties(additionalProperties());
    return em;
  }

  private Properties additionalProperties() {
    Properties properties = new Properties();
    properties.setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
    return properties;
  }

  @Bean
  public JpaTransactionManager transactionManager() throws SQLException {
    JpaTransactionManager transactionManager = new JpaTransactionManager();
    transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
    return transactionManager;
  }

}
