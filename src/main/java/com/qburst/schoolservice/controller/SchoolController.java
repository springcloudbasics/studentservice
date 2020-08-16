package com.qburst.schoolservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;


@RestController
public class SchoolController {

	//school controller --revert
    @Autowired
    RestTemplate restTemplate;
 
	//hysterix added comment
	@HystrixCommand(fallbackMethod = "defaultStudentDetails")
	@GetMapping(value = "/getSchoolDetails/{schoolname}")
    public String getStudents(@PathVariable String schoolname) 
    {
      
 
        String response = restTemplate.exchange("http://student-service/getStudentDetailsForSchool/{schoolname}",
                                HttpMethod.GET, null, new ParameterizedTypeReference<String>() {}, schoolname).getBody();
 
      
 
        return "School Name is  " + schoolname + " \n Student Details " + response;
    }

    @HystrixCommand(fallbackMethod = "defaultStudentDetails")
    @GetMapping(value = "/getSchoolDetails/{schoolname}")
    public String getStudentDetails(@PathVariable String schoolname)
    {


        String response = restTemplate.exchange("http://student-service/getStudentDetailsForSchool/{schoolname}",
                HttpMethod.GET, null, new ParameterizedTypeReference<String>() {}, schoolname).getBody();



        return "School Name is  " + schoolname + " \n Student Details " + response;
    }
 
	private String defaultStudentDetails(String name) {
        return "Hello User!"+name;
    }
}
