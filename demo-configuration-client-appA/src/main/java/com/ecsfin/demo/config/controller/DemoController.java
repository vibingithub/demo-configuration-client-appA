package com.ecsfin.demo.config.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecsfin.demo.config.configuration.MailServerConfig;

/**
 * Use http://{domain}/actuator/refresh to get the latest config values On fly
 */

@RefreshScope
@RestController
@RequestMapping("/api")
public class DemoController {

	
	@Value("${list.demo.values}")
	private List<String> lists;
	
	@Value("#{${map.demo.values}}")
	private Map<String, String> maps;
	
	@Autowired
	private MailServerConfig mailServerConfig;
	
	@GetMapping("/value")
	public String getValue() {
		return "Values of List "+lists+", map "+maps;
	}
	
	@GetMapping("/objValue")
	public String getObjValue() {
		return "Values of Object :"+mailServerConfig;
	}
}
