package com.simulators.football;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = FootballApplication.class)
class FootballApplicationTest {

	@Test
	public void contextLoads() {
		FootballApplication.main(new String[] {});
	}
}
