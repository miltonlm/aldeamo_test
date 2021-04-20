package com.aldeamo.bartender;

import com.aldeamo.bartender.bartender.DTOBartenderRequest;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Testing for the system.
 * */
@SpringBootTest
class BartenderApplicationTests {

	/**
	 * Will test the endpoint.
	 * */
	@Test
	void testCalculation() {
		RestTemplateBuilder restTemplateBuilder = new RestTemplateBuilder();
		RestTemplate restTemplate = restTemplateBuilder.build();

		DTOBartenderRequest dtoBartenderRequest = new DTOBartenderRequest();

		dtoBartenderRequest.setRecordId(3);
		dtoBartenderRequest.setIterations(3);

		ResponseEntity<Map> response = restTemplate.postForEntity("http://localhost:8080/bartender", dtoBartenderRequest, Map.class);
		Map responseMap = response.getBody();

		assertEquals(responseMap.get("r"), "9,11,13");
	}
}
