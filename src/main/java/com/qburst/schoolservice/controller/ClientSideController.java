package com.qburst.schoolservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.qburst.schoolservice.config.RibbonConfiguration;


@RibbonClient(name = "student-service", configuration = RibbonConfiguration.class)
@RestController
public class ClientSideController {

	private final Logger LOG = LoggerFactory.getLogger(this.getClass());
	
	
	

	
	@Autowired
	RestTemplate restTemplate;

	@RequestMapping("/client/frontend")
	public String forward() {
		//String randomString = this.restTemplate.getForObject("http://student-service/backend", String.class);
		String randomString1 = this.restTemplate.getForObject("http://student-service/backend", String.class);
		LOG.info("inside forward message");
		return "Server Response :: " + randomString1;
	}

	//comment to revert commit
	private void testcmdRevet(){

	}
}
