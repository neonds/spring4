package io.company.sample;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
public class SampleServiceTest {

  @Mock 
  private SampleService sampleService;
  
  @Mock 
  private SampleRepository sampleRepository;
  
  
  @Test
  public void testGetServiceName(){
    when(sampleService.getServiceName()).thenReturn(SampleServiceImpl.class.getName());
    
    
    String serviceName = sampleService.getServiceName();
    
    Assert.assertEquals(serviceName, "io.company.sample.SampleServiceImpl");
    
    verify(sampleService, times(1)).getServiceName();    
    
  }
}
