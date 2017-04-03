package io.company.sample;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class SampleRepositoryTest {

  @Autowired
  private SampleRepository repository;

  @Test
  public void testSampleRepositoryIsNotNull() {
    Assert.assertNotNull(repository);
  }

}
