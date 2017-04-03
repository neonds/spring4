package io.company.config;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Profile("test")
@Configuration
public class PersistenceH2FlywayConfig {


  private static final String DATASOURCE_PASSWORD = "datasource.password";

  private static final String DATASOURCE_USERNAME = "datasource.username";

  private static final String DATASOURCE_URL = "datasource.url";

  private static final String DATASOURCE_DRIVER = "datasource.driver";
  
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


}
