package com.qburst.schoolservice.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AvailabilityFilteringRule;
import com.netflix.loadbalancer.IPing;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.PingUrl;

/**
 * Interface class for load balancer configurations
 */
public class RibbonConfiguration {
	@Autowired
    IClientConfig config;
 
    // bean for autowiring
    @Bean
    public IPing ribbonPing(IClientConfig config) {
        return new PingUrl();
    }
    // Ribbon rule configuration
    @Bean
    public IRule ribbonRule(IClientConfig config) {
        return new AvailabilityFilteringRule();
    }
    public void addedMethod(){

    }
}
