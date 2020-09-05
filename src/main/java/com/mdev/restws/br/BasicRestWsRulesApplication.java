package com.mdev.restws.br;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.CommonsRequestLoggingFilter;

@SpringBootApplication
public class BasicRestWsRulesApplication {

	public static void main(String[] args) {
		SpringApplication.run(BasicRestWsRulesApplication.class, args);
	}

	// Abilita il log delle request
	// abilitare logger
	// 		<Logger name="org.springframework.web.filter.CommonsRequestLoggingFilter" level="debug"/>
	// in /resources/log42.xml
	//@Bean
	//public CommonsRequestLoggingFilter requestLoggingFilter() {
	//	CommonsRequestLoggingFilter loggingFilter = new CommonsRequestLoggingFilter();
	//	loggingFilter.setIncludeClientInfo(true);
	//	loggingFilter.setIncludeQueryString(true);
	//	loggingFilter.setIncludePayload(true);
	//	loggingFilter.setMaxPayloadLength(64000);
	//	return loggingFilter;
	//}
}
