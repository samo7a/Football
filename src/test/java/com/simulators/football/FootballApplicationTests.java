package com.simulators.football;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(classes = FootballApplication.class)
class FootballApplicationTests {

	@Test
	void contextLoads() {
		assertNotNull(new FootballApplication());
	}
}
