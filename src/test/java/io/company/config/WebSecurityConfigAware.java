package io.company.config;

import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mobile.device.DeviceResolverRequestFilter;
import org.springframework.security.web.FilterChainProxy;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

public abstract class WebSecurityConfigAware extends ApplicationConfigAware {

    @Autowired
    private FilterChainProxy springSecurityFilterChain;

    @Before
    public void before() {
      mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
      DeviceResolverRequestFilter deviceResolverRequestFilter = new DeviceResolverRequestFilter();

      mockMvc = MockMvcBuilders.webAppContextSetup(context)
          .addFilters(this.springSecurityFilterChain, deviceResolverRequestFilter).build();
    }
}