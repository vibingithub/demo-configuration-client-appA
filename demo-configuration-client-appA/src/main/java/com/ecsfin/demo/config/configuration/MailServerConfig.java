package com.ecsfin.demo.config.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Data
@Configuration
@ConfigurationProperties(prefix = "mail.server")
public class MailServerConfig {

	private String url;
	private String port;
	private String userName;
	private String password;
}
