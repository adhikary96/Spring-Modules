package com.cg.application.appconfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.cg.application.bean.Day;
import com.cg.application.bean.Game;

@Configuration
@ComponentScan(basePackages= {"com.cg.application"})
public class AppConfig {
	
	@Bean
	@Scope("singleton")
	public Map<String, Day> getMap() {
		Map<String, Day> data = new HashMap<String, Day>();

		return data;
	}

}
