package io.company.sample;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import io.company.config.ApplicationConfigAware;


public class SampleRepositoryIntegrationTest extends ApplicationConfigAware{

  @Autowired
  private SampleRepository sampleRepository;
  
  @Test
  public void testNotNull() {
    Assert.assertNotNull(sampleRepository);
  }

}
