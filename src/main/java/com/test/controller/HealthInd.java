package com.test.controller;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Controller;

@Controller
public class HealthInd implements HealthIndicator{

	@Override
	public Health health() {
		return Health.up().withDetail("API status", "Good mama Good").build();
	}

}
